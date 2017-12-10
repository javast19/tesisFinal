/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustalUDC.tutorial;

/**
 *
 * @author Usuario
 */
public class TutorialPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TutorialPrincipal
     */
    public TutorialPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        EscudoUDC = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        skipTutorial = new javax.swing.JButton();
        Continuar = new javax.swing.JButton();
        descripcion = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        descripcion1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelTutorial1 = new javax.swing.JPanel();
        siguiente = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        skipTutorial2 = new javax.swing.JButton();
        tituloTutorial1 = new javax.swing.JLabel();
        scrollDescription1 = new javax.swing.JScrollPane();
        descriptionTutorial1 = new javax.swing.JTextArea();
        imagenTutorial1 = new javax.swing.JLabel();
        panelTutorial2 = new javax.swing.JPanel();
        siguiente1 = new javax.swing.JButton();
        atras1 = new javax.swing.JButton();
        skipTutorial3 = new javax.swing.JButton();
        tituloTutorial2 = new javax.swing.JLabel();
        scrollDescription2 = new javax.swing.JScrollPane();
        descriptionTutorial2 = new javax.swing.JTextArea();
        imagenTutorial2 = new javax.swing.JLabel();
        panelTutorial3 = new javax.swing.JPanel();
        siguiente2 = new javax.swing.JButton();
        atras2 = new javax.swing.JButton();
        skipTutorial4 = new javax.swing.JButton();
        tituloTutorial3 = new javax.swing.JLabel();
        scrollDescription3 = new javax.swing.JScrollPane();
        descriptionTutorial3 = new javax.swing.JTextArea();
        imagenTutorial3 = new javax.swing.JLabel();
        panelTutorial4 = new javax.swing.JPanel();
        siguiente3 = new javax.swing.JButton();
        atras3 = new javax.swing.JButton();
        skipTutorial5 = new javax.swing.JButton();
        tituloTutorial4 = new javax.swing.JLabel();
        scrollDescription4 = new javax.swing.JScrollPane();
        descriptionTutorial4 = new javax.swing.JTextArea();
        imagenTutorial4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelPrincipal.setPreferredSize(new java.awt.Dimension(500, 400));

        EscudoUDC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clustalUDC/src/escudo-unicartagena.png"))); // NOI18N

        titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titulo.setText("ClustalUDC");

        skipTutorial.setText("Saltar Tutorial");
        skipTutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipTutorialActionPerformed(evt);
            }
        });

        Continuar.setText("Continuar");

        descripcion.setLabelFor(titulo);
        descripcion.setText("Bienvenido al sotfware de analisis y modelado 3D de la proteina TP53, ClustalUDC. ");
        descripcion.setAutoscrolls(true);
        descripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        descripcion.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        descripcion.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        salir.setText("Salir");

        descripcion1.setLabelFor(titulo);
        descripcion1.setText("A continuacion encontrara el tutorial de como usar el aplicativo.");
        descripcion1.setAutoscrolls(true);
        descripcion1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        descripcion1.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        descripcion1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel1.setText("Como hacer un analisis y como visualizar su modelo.");

        jLabel2.setText("Investigadores:");

        jLabel3.setText("Luis Carlos Tovar Garrido.");

        jLabel4.setText("Javier David Castillo Beltrán.");

        jLabel5.setText("Daniel Andres Orozoco Méndez.");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(salir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(skipTutorial)
                        .addGap(18, 18, 18)
                        .addComponent(Continuar))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGap(182, 182, 182)
                                .addComponent(titulo))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(descripcion1))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(40, 40, 40)
                        .addComponent(EscudoUDC))
                    .addComponent(descripcion))
                .addGap(0, 171, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descripcion1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(EscudoUDC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(40, 40, 40)))
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Continuar)
                    .addComponent(skipTutorial)
                    .addComponent(salir))
                .addContainerGap())
        );

        descripcion.getAccessibleContext().setAccessibleDescription("Bienvenido al sotfware de analisis y modelado 3D de la proteina TP53, ClustalUDC. A continuacion encontrara el tutorial de como usar el aplicativo, como hacer un analisis y como visualizar su modelo.");

        siguiente.setText("Siguiente");

        atras.setText("Atras");

        skipTutorial2.setText("Saltar Tutorial");

        tituloTutorial1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tituloTutorial1.setText("Lobby");

        descriptionTutorial1.setBackground(new java.awt.Color(240, 240, 240));
        descriptionTutorial1.setColumns(20);
        descriptionTutorial1.setRows(5);
        descriptionTutorial1.setText("Al iniciar el programa se presentara una vista con tres secciones donde\nse muestra información. se encuentra una barra con opciones de menu con \nla que se puede interactuar con las distintas funciones del sistema y \nel logo de la universidad de Cartagena que despliega una descripcion de\nla investigación.");
        descriptionTutorial1.setBorder(null);
        descriptionTutorial1.setPreferredSize(new java.awt.Dimension(190, 94));
        scrollDescription1.setViewportView(descriptionTutorial1);

        imagenTutorial1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clustalUDC/src/Lobby.png"))); // NOI18N

        javax.swing.GroupLayout panelTutorial1Layout = new javax.swing.GroupLayout(panelTutorial1);
        panelTutorial1.setLayout(panelTutorial1Layout);
        panelTutorial1Layout.setHorizontalGroup(
            panelTutorial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTutorial1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTutorial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTutorial1Layout.createSequentialGroup()
                        .addComponent(skipTutorial2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(atras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(siguiente))
                    .addGroup(panelTutorial1Layout.createSequentialGroup()
                        .addGroup(panelTutorial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(scrollDescription1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloTutorial1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imagenTutorial1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTutorial1Layout.setVerticalGroup(
            panelTutorial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTutorial1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloTutorial1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollDescription1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagenTutorial1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(panelTutorial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siguiente)
                    .addComponent(atras)
                    .addComponent(skipTutorial2))
                .addContainerGap())
        );

        siguiente1.setText("Siguiente");
        siguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguiente1ActionPerformed(evt);
            }
        });

        atras1.setText("Atras");

        skipTutorial3.setText("Saltar Tutorial");

        tituloTutorial2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tituloTutorial2.setText("Lobby");

        descriptionTutorial2.setBackground(new java.awt.Color(240, 240, 240));
        descriptionTutorial2.setColumns(20);
        descriptionTutorial2.setRows(5);
        descriptionTutorial2.setText("La sección sombreada en negro es la sección donde se muestra el analisis\nde la proteina ingresada, aqui despues de cargar la proteina se refleja\nel analisis realizado por el sistema mostrando las mutaciones\ncorrespodientes a dicha proteina.");
        descriptionTutorial2.setBorder(null);
        descriptionTutorial2.setPreferredSize(new java.awt.Dimension(190, 94));
        scrollDescription2.setViewportView(descriptionTutorial2);

        imagenTutorial2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clustalUDC/src/Lobby4.png"))); // NOI18N

        javax.swing.GroupLayout panelTutorial2Layout = new javax.swing.GroupLayout(panelTutorial2);
        panelTutorial2.setLayout(panelTutorial2Layout);
        panelTutorial2Layout.setHorizontalGroup(
            panelTutorial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTutorial2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTutorial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTutorial2Layout.createSequentialGroup()
                        .addComponent(skipTutorial3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(atras1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(siguiente1))
                    .addComponent(scrollDescription2)
                    .addGroup(panelTutorial2Layout.createSequentialGroup()
                        .addGroup(panelTutorial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloTutorial2)
                            .addComponent(imagenTutorial2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTutorial2Layout.setVerticalGroup(
            panelTutorial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTutorial2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloTutorial2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollDescription2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagenTutorial2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelTutorial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siguiente1)
                    .addComponent(atras1)
                    .addComponent(skipTutorial3))
                .addContainerGap())
        );

        siguiente2.setText("Siguiente");

        atras2.setText("Atras");

        skipTutorial4.setText("Saltar Tutorial");

        tituloTutorial3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tituloTutorial3.setText("Lobby");

        descriptionTutorial3.setBackground(new java.awt.Color(240, 240, 240));
        descriptionTutorial3.setColumns(20);
        descriptionTutorial3.setRows(5);
        descriptionTutorial3.setText("La sección sombreada en negro es la sección donde se muestra el nombre\nde la proteina ingresada, aqui despues de cargar la proteina se refleja\nel nombre que viene incluido en el archivo como encabezado, esdecir,\nla primera Linea del archivo cargado.");
        descriptionTutorial3.setBorder(null);
        descriptionTutorial3.setPreferredSize(new java.awt.Dimension(190, 94));
        scrollDescription3.setViewportView(descriptionTutorial3);

        imagenTutorial3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clustalUDC/src/Lobby5.png"))); // NOI18N

        javax.swing.GroupLayout panelTutorial3Layout = new javax.swing.GroupLayout(panelTutorial3);
        panelTutorial3.setLayout(panelTutorial3Layout);
        panelTutorial3Layout.setHorizontalGroup(
            panelTutorial3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTutorial3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTutorial3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTutorial3Layout.createSequentialGroup()
                        .addComponent(skipTutorial4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(atras2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(siguiente2))
                    .addGroup(panelTutorial3Layout.createSequentialGroup()
                        .addGroup(panelTutorial3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(scrollDescription3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloTutorial3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imagenTutorial3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTutorial3Layout.setVerticalGroup(
            panelTutorial3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTutorial3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloTutorial3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollDescription3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagenTutorial3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(panelTutorial3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siguiente2)
                    .addComponent(atras2)
                    .addComponent(skipTutorial4))
                .addContainerGap())
        );

        siguiente3.setText("Siguiente");

        atras3.setText("Atras");

        skipTutorial5.setText("Saltar Tutorial");

        tituloTutorial4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tituloTutorial4.setText("Lobby");

        descriptionTutorial4.setBackground(new java.awt.Color(240, 240, 240));
        descriptionTutorial4.setColumns(20);
        descriptionTutorial4.setRows(5);
        descriptionTutorial4.setText("La sección sombreada en negro es la sección donde se muestran los \nresultados obtenidos en el analisis realizado al momento del cargue del\narchivo, aqui despues de analizar la proteina se reflejan los cambios\nque se obtuvieron, es decir, las mutaciones encontradas y su posición.");
        descriptionTutorial4.setBorder(null);
        descriptionTutorial4.setPreferredSize(new java.awt.Dimension(190, 94));
        scrollDescription4.setViewportView(descriptionTutorial4);

        imagenTutorial4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clustalUDC/src/Lobby6.png"))); // NOI18N

        javax.swing.GroupLayout panelTutorial4Layout = new javax.swing.GroupLayout(panelTutorial4);
        panelTutorial4.setLayout(panelTutorial4Layout);
        panelTutorial4Layout.setHorizontalGroup(
            panelTutorial4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTutorial4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTutorial4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTutorial4Layout.createSequentialGroup()
                        .addComponent(skipTutorial5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(atras3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(siguiente3))
                    .addGroup(panelTutorial4Layout.createSequentialGroup()
                        .addGroup(panelTutorial4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(scrollDescription4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloTutorial4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imagenTutorial4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTutorial4Layout.setVerticalGroup(
            panelTutorial4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTutorial4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloTutorial4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollDescription4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagenTutorial4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(panelTutorial4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siguiente3)
                    .addComponent(atras3)
                    .addComponent(skipTutorial5))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelTutorial1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelTutorial2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelTutorial3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelTutorial4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelTutorial1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelTutorial2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelTutorial3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelTutorial4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void skipTutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipTutorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skipTutorialActionPerformed

    private void siguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguiente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_siguiente1ActionPerformed

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
            java.util.logging.Logger.getLogger(TutorialPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TutorialPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TutorialPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TutorialPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TutorialPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Continuar;
    private javax.swing.JLabel EscudoUDC;
    private javax.swing.JButton atras;
    private javax.swing.JButton atras1;
    private javax.swing.JButton atras2;
    private javax.swing.JButton atras3;
    private javax.swing.JLabel descripcion;
    private javax.swing.JLabel descripcion1;
    private javax.swing.JTextArea descriptionTutorial1;
    private javax.swing.JTextArea descriptionTutorial2;
    private javax.swing.JTextArea descriptionTutorial3;
    private javax.swing.JTextArea descriptionTutorial4;
    private javax.swing.JLabel imagenTutorial1;
    private javax.swing.JLabel imagenTutorial2;
    private javax.swing.JLabel imagenTutorial3;
    private javax.swing.JLabel imagenTutorial4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTutorial1;
    private javax.swing.JPanel panelTutorial2;
    private javax.swing.JPanel panelTutorial3;
    private javax.swing.JPanel panelTutorial4;
    private javax.swing.JButton salir;
    private javax.swing.JScrollPane scrollDescription1;
    private javax.swing.JScrollPane scrollDescription2;
    private javax.swing.JScrollPane scrollDescription3;
    private javax.swing.JScrollPane scrollDescription4;
    private javax.swing.JButton siguiente;
    private javax.swing.JButton siguiente1;
    private javax.swing.JButton siguiente2;
    private javax.swing.JButton siguiente3;
    private javax.swing.JButton skipTutorial;
    private javax.swing.JButton skipTutorial2;
    private javax.swing.JButton skipTutorial3;
    private javax.swing.JButton skipTutorial4;
    private javax.swing.JButton skipTutorial5;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel tituloTutorial1;
    private javax.swing.JLabel tituloTutorial2;
    private javax.swing.JLabel tituloTutorial3;
    private javax.swing.JLabel tituloTutorial4;
    // End of variables declaration//GEN-END:variables
}
