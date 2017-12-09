/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustalUDC;

/**
 *
 * @author LENOVO}
 */
public class Prueba {
    
    public static void main(String[] args){
        new Prueba().comparar();
    }
    
    public void comparar(){
        int cont = 0;
        int contAux = 0, posicionCorrecta = 0;
        
        for (int i = 0; i < (cadena.length()-entrada.length()); i++) {
            
            for (int j = 0; j < entrada.length(); j++) {
                
                if (cadena.toCharArray()[i+j] == entrada.toCharArray()[j])
                    cont++;
                
            }
            if(cont > contAux){
                contAux = cont; 
                posicionCorrecta = i;
            }
                
        }
        
        System.out.println(posicionCorrecta);
        System.out.println(contAux);
        
    }
    
    
    private String cadena = "abdcefghijklmn";
    private String entrada = "defghijklmn";
    
}
