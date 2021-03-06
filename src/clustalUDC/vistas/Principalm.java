/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustalUDC.vistas;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.biojava.nbio.structure.Structure;
import org.biojava.nbio.structure.io.PDBFileReader;
import clustalUDC.PJmol;
import clustalUDC.persistencia.CargarBD;
import clustalUDC.tutorial.TutorialPrincipal;
import java.awt.Desktop;
import javax.swing.JProgressBar;

/**
 *
 * @author DANIEL OROZCO
 */
public class Principalm extends javax.swing.JFrame {
    
    
    /**
     * Creates new form Principalm
     */
    
    private int contadorArchivo;
    private int codon;
    private String mutacion;
    public Principalm() {
        
        initComponents();
        jMenuItem6.setVisible(false);
        
    }
    
    public void importarArchivo(){
        try{
            JFileChooser Ventana = new JFileChooser(System.getProperty("user.dir"));
            int validador = Ventana.showOpenDialog(this);
            File Abrir = Ventana.getSelectedFile();
            if (Abrir != null && validador == JFileChooser.APPROVE_OPTION){
                FileReader fichero = new FileReader(Abrir);
                BufferedReader leer = new BufferedReader(fichero);
                String a;
                String b ="";
                String conf="";
                int i = 0;
                while((a = leer.readLine()) != null){
                    if (i==0){
                        conf=a;
                    }
                        
                    if (i>0){
                        b=b+a;
                    }
                    i++;
                    
                }
                
                if(verificarProteina(b)) {
                    String strFasta = analizarFasta(b);
                    jTextArea2.append("\n" + conf + "\n");
                } else {

                    accionMenu.setEnabled(false);
                    JOptionPane.showMessageDialog(null, 
                            "La Proteina ingresada no cumple con el estandar."
                                    + "\nEste error puede ocurrir por una extención no válida "
                                    + "o por escribir mal la secuencia de la proteina."
                            + "\n\nPor favor revisar cual es la forma correcta de ingresar el archivo de proteina\n"
                            + "en la documentacion del software."
                            + "\nSe esperaba una secuencia \"CGG GTC CTA...\"",
                            "Error al cargar Proteina", JOptionPane.ERROR_MESSAGE);

                }

            }


            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public String analizarFasta(String fasta){
    
        String strNormal="ATG GAG GAG CCG CAG TCA GAT CCT AGC GTC GAG CCC CCT CTG AGT CAG GAA ACA TTT TCA " +
"GAC CTA TGG AAA CTA CTT CCT GAA AAC AAC GTT CTG TCC CCC TTG CCG TCC CAA GCA ATG " +
"GAT GAT TTG ATG CTG TCC CCG GAC GAT ATT GAA CAA TGG TTC ACT GAA GAC CCA GGT CCA " +
"GAT GAA GCT CCC AGA ATG CCA GAG GCT GCT CCC CGC GTG GCC CCT GCA CCA GCA GCT CCT " +
"ACA CCG GCG GCC CCT GCA CCA GCC CCC TCC TGG CCC CTG TCA TCT TCT GTC CCT TCC CAG " +
"AAA ACC TAC CAG GGC AGC TAC GGT TTC CGT CTG GGC TTC TTG CAT TCT GGG ACA GCC AAG " +
"TCT GTG ACT TGC ACG TAC TCC CCT GCC CTC AAC AAG ATG TTT TGC CAA CTG GCC AAG ACC " +
"TGC CCT GTG CAG CTG TGG GTT GAT TCC ACA CCC CCG CCC GGC ACC CGC GTC CGC GCC ATG " +
"GCC ATC TAC AAG CAG TCA CAG CAC ATG ACG GAG GTT GTG AGG CGC TGC CCC CAC CAT GAG " +
"CGC TGC TCA GAT AGC GAT GGT CTG GCC CCT CCT CAG CAT CTT ATC CGA GTG GAA GGA AAT " +
"TTG CGT GTG GAG TAT TTG GAT GAC AGA AAC ACT TTT CGA CAT AGT GTG GTG GTG CCC TAT " +
"GAG CCG CCT GAG GTT GGC TCT GAC TGT ACC ACC ATC CAC TAC AAC TAC ATG TGT AAC AGT " +
"TCC TGC ATG GGC GGC ATG AAC CGG AGG CCC ATC CTC ACC ATC ATC ACA CTG GAA GAC TCC " +
"AGT GGT AAT CTA CTG GGA CGG AAC AGC TTT GAG GTG CGT GTT TGT GCC TGT CCT GGG AGA " +
"GAC CGG CGC ACA GAG GAA GAG AAT CTC CGC AAG AAA GGG GAG CCT CAC CAC GAG CTG CCC " +
"CCA GGG AGC ACT AAG CGA GCA CTG CCC AAC AAC ACC AGC TCC TCT CCC CAG CCA AAG AAG " +
"AAA CCA CTG GAT GGA GAA TAT TTC ACC CTT CAG ATC CGT GGG CGT GAG CGC TTC GAG ATG " +
"TTC CGA GAG CTG AAT GAG GCC TTG GAA CTC AAG GAT GCC CAG GCT GGG AAG GAG CCA GGG " +
"GGG AGC AGG GCT CAC TCC AGC CAC CTG AAG TCC AAA AAG GGT GAG TCT ACC TCC CGC CAT " +
"AAA AAA CTC ATG TTC AAG ACA GAA GGG CCT GAC TCA GAC TGA";
        int cont = 0;
        int contAux = 0, posicionCorrecta = 0;
        fasta = fasta.toUpperCase();
        String cadenaAux[] = strNormal.split(" ");
      
        strNormal = strNormal.replaceAll(" ", "");
        System.out.println(strNormal);
        System.out.println("\n");
        fasta = fasta.replaceAll(" ", "");
        System.out.println(fasta);
        
        for (int i = 0; i < (strNormal.length() - fasta.length()); i++) {

            cont=0;
            for (int j = 0; j < fasta.length(); j++) {

                if (strNormal.toCharArray()[i + j] == fasta.toCharArray()[j]) {
                    cont++;
                }

            }
            if (cont > contAux) {
                contAux = cont;
                posicionCorrecta = i;
            }

        }

        String cambios = new String();
        int contadorC = 0;
        for (int i = posicionCorrecta; i < (posicionCorrecta + fasta.length()); i++) {
            
            if(strNormal.toCharArray()[i] == fasta.toCharArray()[contadorC])
                cambios = cambios.concat(" ");
            else
                cambios = cambios.concat("*");
            contadorC++;
        }
        System.out.println(cambios);
        String strAux="";
        for (int i = 0; i < posicionCorrecta; i++) {
            strAux += " ";
        }
        fasta = strAux.concat(fasta);
        cambios = strAux.concat(cambios);
        
        String codonMut;
        String codonNorm;
        String matrizTempX[][] = new String[cambios.replaceAll(" ", "").trim().length()][5];
        int contadorMatriz = 0;
        
        for (int i = 0; i < cambios.length(); i++) {
            
            if(cambios.toCharArray()[i] == '*'){
                for (int j = 0; j < strNormal.length(); j = j+3) {
                    if(j == i){
                        
                        matrizTempX[contadorMatriz][0] = strNormal.substring(j, j + 3);
                        matrizTempX[contadorMatriz][1] = fasta.substring(j, j + 3);
                        matrizTempX[contadorMatriz][2] = Integer.valueOf(i).toString();
                        matrizTempX[contadorMatriz][3] = onChangeBaseNToAminoacid(matrizTempX[contadorMatriz][0]);
                        matrizTempX[contadorMatriz][4] = onChangeBaseNToAminoacid(matrizTempX[contadorMatriz][1]);
                        contadorMatriz++;
                        break;

                    }else if(j > i){

                        matrizTempX[contadorMatriz][0]  = strNormal.substring(j-3, j);
                        matrizTempX[contadorMatriz][1] = fasta.substring(j-3, j);
                        matrizTempX[contadorMatriz][2] = Integer.valueOf(i).toString();
                        matrizTempX[contadorMatriz][3] = onChangeBaseNToAminoacid(matrizTempX[contadorMatriz][0]);
                        matrizTempX[contadorMatriz][4] = onChangeBaseNToAminoacid(matrizTempX[contadorMatriz][1]);
                        contadorMatriz++;
                        break;
                    }
                }
            }
        }
//        jTextArea1.setText("");
//        jTextArea3.setText("");
        
        contadorArchivo++;
        String informeMutacion ="";
        jTextArea4.append("Archivo número "+contadorArchivo+"\n");
        if(matrizTempX.length == 0){
            informeMutacion =
                        "No se halla ninguna mutación en el análisis "
                                + "parece haber ingresado la proteína en estado normal. "
                                + "\n";
        }
        
        for (String[] info : matrizTempX) {
            if(!info[4].equals(info[3]))
              informeMutacion =
                        "Se halla mutación en la posición " + info[2] + "\n" 
                        + "El aminoácido del codón " + ((parseInt(info[2]) / 3) + 1)
                        + " ha mutado"
                        + ": " + info[0] + " -> " + info[1] + ". \n"
                        + "Aminoácido mutado: "+info[3]+" -> "+ info[4] +"\n";
            else
               informeMutacion = "Se halla mutación en la posición " +info[2] + "\n"
                        + " El aminoácido del codón "+ ((parseInt(info[2])/3)+1) 
                        + " \nNO ha cambiado. "+info[4]+"->"+info[3]+"\n";
        }
        abrirInforme(informeMutacion);
        
        jTextArea4.append(informeMutacion);
        jTextArea4.append("\n\n");
        String otroAux = "";
        for (int i = 0; i < strNormal.length(); i = i+3) {
            otroAux = otroAux.concat(strNormal.substring(i, i+3).concat(" "));
        }
        
        strNormal = otroAux;
        
        otroAux = "";
        for (int i = 0; i < fasta.length(); i = i+3) {
            otroAux = otroAux.concat(fasta.substring(i, i+3).concat(" "));
        }
        
        fasta = otroAux;
        
        otroAux = "";
        for (int i = 0; i < cambios.length(); i = i+3) {
            otroAux = otroAux.concat(cambios.substring(i, i+3).concat(" "));
        }
        
        cambios = otroAux;
        if (contadorArchivo == 1) {
//            jTextArea1.append(strNormal.toUpperCase());
        }

        jTextArea1.append("\n" + fasta.toUpperCase() + "\n" + cambios);
        mutacion = null;
        codon = 0;
        if (matrizTempX.length != 0) {
            codon = (parseInt(matrizTempX[contadorMatriz - 1][2]) / 3) + 1;
            mutacion = matrizTempX[contadorMatriz - 1][1];
        }
        
        if(mutacion == null)
            accionMenu.setEnabled(false);
        else
            accionMenu.setEnabled(true);
        
        return fasta;
    }
    
    public String onChangeBaseNToAminoacid(String entrada){
                
        String cadenaModificada = entrada;
        cadenaModificada = cadenaModificada.replaceAll("GCT", "Alanina (A)");
        cadenaModificada = cadenaModificada.replaceAll("GCC", "Alanina (A)");
        cadenaModificada = cadenaModificada.replaceAll("GCG", "Alanina (A)");
        cadenaModificada = cadenaModificada.replaceAll("GCA", "Alanina (A)");
        cadenaModificada = cadenaModificada.replaceAll("CGT", "Arginina (R)");
        cadenaModificada = cadenaModificada.replaceAll("CGC", "Arginina (R)");
        cadenaModificada = cadenaModificada.replaceAll("CGG", "Arginina (R)");
        cadenaModificada = cadenaModificada.replaceAll("CGA", "Arginina (R)");
        cadenaModificada = cadenaModificada.replaceAll("AGA", "Arginina (R)");
        cadenaModificada = cadenaModificada.replaceAll("AGG", "Arginina (R)");
        cadenaModificada = cadenaModificada.replaceAll("AAC", "Asparagina (N)");
        cadenaModificada = cadenaModificada.replaceAll("AAT", "Asparagina (N)");
        cadenaModificada = cadenaModificada.replaceAll("GAC", "Aspartato (D)");
        cadenaModificada = cadenaModificada.replaceAll("GAT", "Aspartato (D)");
        cadenaModificada = cadenaModificada.replaceAll("TGC", "Cisteina (C)");
        cadenaModificada = cadenaModificada.replaceAll("TGT", "Cisteina (C)");
        cadenaModificada = cadenaModificada.replaceAll("GAA", "Glutamato (E)");
        cadenaModificada = cadenaModificada.replaceAll("GAG", "Glutamato (E)");
        cadenaModificada = cadenaModificada.replaceAll("CAG", "Glutamina (Q)");
        cadenaModificada = cadenaModificada.replaceAll("CAA", "Glutamina (Q)");
        cadenaModificada = cadenaModificada.replaceAll("GGT", "Glicina (G)");
        cadenaModificada = cadenaModificada.replaceAll("GGC", "Glicina (G)");
        cadenaModificada = cadenaModificada.replaceAll("GGG", "Glicina (G)");
        cadenaModificada = cadenaModificada.replaceAll("GGA", "Glicina (G)");
        cadenaModificada = cadenaModificada.replaceAll("CAT", "Histidina (H)");
        cadenaModificada = cadenaModificada.replaceAll("CAC", "Histidina (H)");
        cadenaModificada = cadenaModificada.replaceAll("ATC", "Isoleucina (I)");
        cadenaModificada = cadenaModificada.replaceAll("ATT", "Isoleucina (I)");
        cadenaModificada = cadenaModificada.replaceAll("CTG", "Leucina (L)");
        cadenaModificada = cadenaModificada.replaceAll("CTA", "Leucina (L)");
        cadenaModificada = cadenaModificada.replaceAll("CTT", "Leucina (L)");
        cadenaModificada = cadenaModificada.replaceAll("CTC", "Leucina (L)");
        cadenaModificada = cadenaModificada.replaceAll("TTG", "Leucina (L)");
        cadenaModificada = cadenaModificada.replaceAll("AAG", "Lisina (K)");
        cadenaModificada = cadenaModificada.replaceAll("AAA", "Lisina (K)");
        cadenaModificada = cadenaModificada.replaceAll("ATG", "Metionina (M)");
        cadenaModificada = cadenaModificada.replaceAll("TTC", "Fenilalanina (F)");
        cadenaModificada = cadenaModificada.replaceAll("TTT", "Fenilalanina (F)");
        cadenaModificada = cadenaModificada.replaceAll("CCT", "Prolina (P)");
        cadenaModificada = cadenaModificada.replaceAll("CCG", "Prolina (P)");
        cadenaModificada = cadenaModificada.replaceAll("CCA", "Prolina (P)");
        cadenaModificada = cadenaModificada.replaceAll("CCC", "Prolina (P)");
        cadenaModificada = cadenaModificada.replaceAll("TCA", "Serina (S)");
        cadenaModificada = cadenaModificada.replaceAll("AGC", "Serina (S)");
        cadenaModificada = cadenaModificada.replaceAll("AGT", "Serina (S)");
        cadenaModificada = cadenaModificada.replaceAll("TCC", "Serina (S)");
        cadenaModificada = cadenaModificada.replaceAll("TCT", "Serina (S)");
        cadenaModificada = cadenaModificada.replaceAll("ACG", "Serina (S)");
        cadenaModificada = cadenaModificada.replaceAll("ACC", "Treonina (T)");
        cadenaModificada = cadenaModificada.replaceAll("ACA", "Treonina (T)");
        cadenaModificada = cadenaModificada.replaceAll("ACT", "Treonina (T)");
        cadenaModificada = cadenaModificada.replaceAll("TGG", "Triptofano (W)");
        cadenaModificada = cadenaModificada.replaceAll("TAC", "Tirosina (Y)");
        cadenaModificada = cadenaModificada.replaceAll("TAT", "Tirosina (Y)");
        cadenaModificada = cadenaModificada.replaceAll("GTG", "Valina (V)");
        cadenaModificada = cadenaModificada.replaceAll("GTC", "Valina (V)");
        cadenaModificada = cadenaModificada.replaceAll("GTT", "Valina (V)");
        cadenaModificada = cadenaModificada.replaceAll("TGA", "Terminacion"); // codon de terminacion
  

        return cadenaModificada;
    }
    
    public void abrirBD(int codon, String mutacion){
        File f = new File("bd/baseDatosP53.xlsx");
        if (f.exists()){
            CargarBD obj = new CargarBD(f,codon+".0",mutacion);
            RegistroBD prueba = new RegistroBD(obj.getCellData());
            prueba.setLocationRelativeTo(null);
            prueba.setVisible(true);
        }
        
    }
    
    public void abrir3D(int codon){
        try {

           PDBFileReader pdbr = new PDBFileReader();            
           pdbr.setPath("/Path/To/PDBFiles/");

           String pdbCode = "1t4w";

           Structure struc = pdbr.getStructureById(pdbCode);

           PJmol ex = new PJmol();
           ex.setStructure(struc);
           ex.cambiaMutacion(struc, codon, true);
            
             
       } catch (Exception e){  
           e.printStackTrace();  
       }  
    }
    private void abrir3Dnormal(int codon) {
        try {

           PDBFileReader pdbr = new PDBFileReader();            
           pdbr.setPath("/Path/To/PDBFiles/");

           String pdbCode = "1t4w";

           Structure struc = pdbr.getStructureById(pdbCode);

           PJmol ex = new PJmol();
           ex.setStructure(struc);
           ex.cambiaMutacion(struc, codon, false);
            
             
       } catch (Exception e){  
           e.printStackTrace();  
       }  
        
    }
    
    private void abrirAbout() {
        JOptionPane.showMessageDialog(null,"El objetivo principal de esta investigación es facilitar el \n" +
"estudio de la secuencia aminoacídica de p53. De tal \n" +
"forma que se pueda realizar comparaciones entre la \n" +
"secuencia de aminoácidos de p53 en su forma común\n" +
"con ejemplos de otras p53 que tendrían mutaciones en\n" +
"su secuencia de aminoácidos, comparar los resultados\n" +
"obtenidos con otras investigaciones que relacionan el tipo\n" +
"de mutación con un tipo de hepatocarcinoma celular (HCC)\n" +
"especifico y posteriormente graficar en un modelo 3D \n" +
"la estructura de la proteína mutada.\n\n"
                + "Grupo de investigación:  GIMATICA.\n\n"
                + "Investigadores:\nLuis Carlos Tovar Garrido\n"
                + "Javier David Castillo Beltrán\n"
                + "Daniel Andres Orozco Mendez\n", "About", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void abrirInforme(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Informe de Analisis", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private boolean verificarProteina(String b) {
        b =b.replaceAll(" ", "");
        b = b.toUpperCase();
        if(b.contains("M") || b.contains("E") || b.contains("P") || b.contains("Q") 
                || b.contains("S") || b.contains("S") || b.contains("D") || 
                 b.contains("V") || b.contains("L") || b.contains("H") || 
                 b.contains("F") || b.contains("W") || b.contains("K") ||
                 b.contains("N") || b.contains("I") || b.contains("R") ||
                 b.contains("Y") || b.contains("Q") || b.contains("P") ||
                b.isEmpty() || b.trim().length()%3 != 0){
            return false;
        }
        return true;
    
    }
    
    public void visualizarFasta(String strFasta, String conf){
        
            //imprimir cadenaFasta
            
            /*Iterator<Character> nombreIterator = cadenaFasta.iterator();
            while(nombreIterator.hasNext()){
                Character elemento = nombreIterator.next();
                System.out.print(elemento);
            }*/    
            ArrayList<Character> cadenaFasta= new ArrayList<>();
            String strNormal="MEEPQSDPSVEPPLSQETFSDLWKLLPENNVLSPLPSQAMDDLMLSPDDIEQWFTEDPGPDEAPRMPEAAPRVAPAPAAPTPAAPAPAPSWPLSSSVPSQKTYQGSYGFRLGFLHSGTAKSVTCSYSPALNKMFCQLAKTCPVQLWVDSTPPPGTRVRAMAIYKQSQHMSEVVRRCPHHERCSDSDGLAPPQHLIRVEGNLRVEYLDDRNTFRHSVVVPYEPPEVGSDCTTIHYNYMCNSSCMGGMNRRPILTIITLEDSSGNLLGRNSFEVRVCACPGRDRRTEEENLRKKGEPHHELPPGSTKRALPNNTSSSPQPKKKPLDGEYFTLQIRGRERFEMFRELNEALELKDAQAGKEPGGSRAHSSHLKSKKGESTSRHKKLMFKTEGPDSDU";
            for (char c : strFasta.toCharArray()) {
                    cadenaFasta.add(c);
                }
            ArrayList<Character> cadenaNormal =new ArrayList<>();
            for (char c : strNormal.toCharArray()) {
                    cadenaNormal.add(c);
                }
            
            ArrayList<Integer> cambios=neighborJoining(cadenaNormal, cadenaFasta);
            String str="";
            for(int i=0; i< cambios.get(cambios.size()-1); i++){
                
                str=str+" ";
                
            }
            strFasta=str+strFasta;
            
            for(int i=0; i<cambios.size();i++){
                str=str+cambios.get(i).toString();
            }
            jTextArea2.setText(">Gen en estado normal\n"+conf);
            jTextArea1.setText(strNormal.toUpperCase()+"\n"+strFasta.toUpperCase()+"\n"+str);
    }

    public ArrayList<Integer> neighborJoining(
            ArrayList<Character> cadenaN, ArrayList<Character> cadenaM){
        
        int  variante = 0, aux=0, cont=0, contAux=999999999;
        
        ArrayList<Integer> cadenaAux = new ArrayList<>(cadenaM.size());
        
        for(int i=0; i<7; i++){
            
            cont=0;
            for (int j = 0; j < cadenaM.size(); j++) {
                
                if(!cadenaM.get(j).equals(cadenaN.get(aux))){
                    cont++;
                }
                
                aux++;
            }
            if(cont < contAux){
                
                variante=aux - cadenaM.size();
                contAux = cont;
            }
        }
        
        for(int i = 0; i < cadenaM.size(); i++){
            
            
            if(cadenaM.get(i) != cadenaN.get(i+variante)){
                cadenaAux.add(1);
            }else{
                cadenaAux.add(0);
            }
            
        }
        
        cadenaAux.add(variante);
        
        return cadenaAux;
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        archivoMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        accionMenu = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        ayudaMenu = new javax.swing.JMenu();
        ayudaDoc = new javax.swing.JMenuItem();
        tutorial = new javax.swing.JMenuItem();
        about = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ClustalUDC");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Lucida Console", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("Analisis de la proteina");
        jScrollPane2.setViewportView(jTextArea1);

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Lucida Console", 0, 13)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setToolTipText("Encabezado del archivo (Primera linea)");
        jScrollPane3.setViewportView(jTextArea2);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Lucida Console", 0, 13)); // NOI18N
        jTextArea3.setRows(5);
        jScrollPane1.setViewportView(jTextArea3);

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.setToolTipText("Resultados obtenidos por archivos");
        jScrollPane4.setViewportView(jTextArea4);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clustalUDC/src/escudo-unicartagena.png"))); // NOI18N
        jLabel1.setToolTipText("Universidad de Cartagena");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("About");
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel2MouseMoved(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(66, 66, 66))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        archivoMenu.setText("Archivo");

        jMenuItem1.setText("Abrir FASTA");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        archivoMenu.add(jMenuItem1);

        jMenuItem4.setText("Salir");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        archivoMenu.add(jMenuItem4);

        jMenuBar1.add(archivoMenu);

        accionMenu.setText("Accion");
        accionMenu.setEnabled(false);

        jMenuItem3.setText("Comparar Resultados");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        accionMenu.add(jMenuItem3);

        jMenu2.setText("Modelo 3D");

        jMenuItem5.setText("Mutacion");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Estado Normal");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        accionMenu.add(jMenu2);

        jMenuBar1.add(accionMenu);

        ayudaMenu.setText("Ayuda");

        ayudaDoc.setText("Manual de Usuario");
        ayudaDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaDocActionPerformed(evt);
            }
        });
        ayudaMenu.add(ayudaDoc);

        tutorial.setText("Abrir Tutorial");
        tutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutorialActionPerformed(evt);
            }
        });
        ayudaMenu.add(tutorial);

        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        ayudaMenu.add(about);

        jMenuBar1.add(ayudaMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        importarArchivo();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String strNormal="ATG GAG GAG CCG CAG TCA GAT CCT AGC GTC GAG CCC CCT CTG AGT CAG GAA ACA TTT TCA " +
"GAC CTA TGG AAA CTA CTT CCT GAA AAC AAC GTT CTG TCC CCC TTG CCG TCC CAA GCA ATG " +
"GAT GAT TTG ATG CTG TCC CCG GAC GAT ATT GAA CAA TGG TTC ACT GAA GAC CCA GGT CCA " +
"GAT GAA GCT CCC AGA ATG CCA GAG GCT GCT CCC CGC GTG GCC CCT GCA CCA GCA GCT CCT " +
"ACA CCG GCG GCC CCT GCA CCA GCC CCC TCC TGG CCC CTG TCA TCT TCT GTC CCT TCC CAG " +
"AAA ACC TAC CAG GGC AGC TAC GGT TTC CGT CTG GGC TTC TTG CAT TCT GGG ACA GCC AAG " +
"TCT GTG ACT TGC ACG TAC TCC CCT GCC CTC AAC AAG ATG TTT TGC CAA CTG GCC AAG ACC " +
"TGC CCT GTG CAG CTG TGG GTT GAT TCC ACA CCC CCG CCC GGC ACC CGC GTC CGC GCC ATG " +
"GCC ATC TAC AAG CAG TCA CAG CAC ATG ACG GAG GTT GTG AGG CGC TGC CCC CAC CAT GAG " +
"CGC TGC TCA GAT AGC GAT GGT CTG GCC CCT CCT CAG CAT CTT ATC CGA GTG GAA GGA AAT " +
"TTG CGT GTG GAG TAT TTG GAT GAC AGA AAC ACT TTT CGA CAT AGT GTG GTG GTG CCC TAT " +
"GAG CCG CCT GAG GTT GGC TCT GAC TGT ACC ACC ATC CAC TAC AAC TAC ATG TGT AAC AGT " +
"TCC TGC ATG GGC GGC ATG AAC CGG AGG CCC ATC CTC ACC ATC ATC ACA CTG GAA GAC TCC " +
"AGT GGT AAT CTA CTG GGA CGG AAC AGC TTT GAG GTG CGT GTT TGT GCC TGT CCT GGG AGA " +
"GAC CGG CGC ACA GAG GAA GAG AAT CTC CGC AAG AAA GGG GAG CCT CAC CAC GAG CTG CCC " +
"CCA GGG AGC ACT AAG CGA GCA CTG CCC AAC AAC ACC AGC TCC TCT CCC CAG CCA AAG AAG " +
"AAA CCA CTG GAT GGA GAA TAT TTC ACC CTT CAG ATC CGT GGG CGT GAG CGC TTC GAG ATG " +
"TTC CGA GAG CTG AAT GAG GCC TTG GAA CTC AAG GAT GCC CAG GCT GGG AAG GAG CCA GGG " +
"GGG AGC AGG GCT CAC TCC AGC CAC CTG AAG TCC AAA AAG GGT GAG TCT ACC TCC CGC CAT " +
"AAA AAA CTC ATG TTC AAG ACA GAA GGG CCT GAC TCA GAC TGA";
        for(int i=1; i<=394; i++){
            if(i<10)
                jTextArea1.append("00"+i+" ");
            if(i>=10 && i<100)
                jTextArea1.append("0"+i+" ");
            if(i>=100 && i<394)
                jTextArea1.append(i+" ");
            if(i==394)
                jTextArea1.append(i+"");
        }
        jTextArea1.append("\n");
        for(int i=0; i<1575; i++){
            jTextArea1.append("-");
        }
        jTextArea1.append("\n"+strNormal.toUpperCase());
        jTextArea2.append(">\n>\n>Gen en estado normal");
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        abrirBD(codon, mutacion);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       JProgressBar barraDeEspera = new JProgressBar();
       barraDeEspera.doLayout();
       abrir3D(codon);
       abrir3Dnormal(codon);       
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       abrirAbout();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseMoved
        
    }//GEN-LAST:event_jLabel2MouseMoved

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        Font font = jLabel2.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        jLabel2.setFont(font.deriveFont(attributes));
        //jLabel2.setFont(new Font("Tahoma", Font.BOLD, 12));
        jLabel2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 12));
    }//GEN-LAST:event_jLabel2MouseExited

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        abrirAbout();
    }//GEN-LAST:event_aboutActionPerformed

    private void ayudaDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaDocActionPerformed
        try{
            Desktop.getDesktop().open(new java.io.File("bd/Manual-de-usuario-ClustalUDC.pdf"));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas al cargar el manual de usuario:\n\n"+e);
        }
    }//GEN-LAST:event_ayudaDocActionPerformed

    private void tutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutorialActionPerformed
        this.setVisible(false);
//        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_DEACTIVATED));
        clustalUDC.tutorial.TutorialPrincipal tuto = new TutorialPrincipal();
        tuto.setVisible(true);
        tuto.setLocationRelativeTo(null); 
    }//GEN-LAST:event_tutorialActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principalm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principalm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principalm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principalm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principalm().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JMenu accionMenu;
    private javax.swing.JMenu archivoMenu;
    private javax.swing.JMenuItem ayudaDoc;
    private javax.swing.JMenu ayudaMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JMenuItem tutorial;
    // End of variables declaration//GEN-END:variables

    
}
