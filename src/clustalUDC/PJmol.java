/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustalUDC;

//import java.awt.Container;
//import java.awt.Dimension;
//import javax.swing.JFrame;
//import org.biojava.nbio.structure.Structure;
//import org.jmol.api.JmolViewer;
//import org.openscience.jmol.app.jmolpanel.JmolPanel;

import java.awt.Container; 
import java.awt.Dimension; 
import java.awt.Graphics; 
import java.awt.Rectangle; 
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import org.biojava.nbio.structure.Structure; 
import org.jmol.adapter.smarter.SmarterJmolAdapter; 
import org.jmol.api.JmolAdapter; 
import org.jmol.api.JmolViewer;

/**
 *
 * @author Home
 */
public class PJmol {
    JmolViewer viewer;  
    Structure structure; 

    JmolPanel jmolPanel;  
    JFrame frame ;
    
    public PJmol(){
        frame = new JFrame();  
        frame.addWindowListener(new ApplicationCloser());  
        Container contentPane = frame.getContentPane();  
        jmolPanel = new JmolPanel();  
    
        jmolPanel.setPreferredSize(new Dimension(500,500));  
        contentPane.add(jmolPanel);
        contentPane.add(jmolPanel);
        
        frame.setTitle("ClustalUDC (jmol)");

        frame.pack();  
        frame.setVisible(true); 
        
    }
    public void setStructure(Structure s) {  
         
        frame.setName(s.getPDBCode());

        // actually this is very simple  
        // just convert the structure to a PDB file  

        String pdb = s.toPDB();  

        structure = s;  
        JmolViewer viewer = jmolPanel.getViewer();

        // Jmol could also read the file directly from your file system  
        //viewer.openFile("/Path/To/PDB/1tim.pdb");  

        // send the PDB file to Jmol.  
        // there are also other ways to interact with Jmol, but they require more  
        // code. See the link to SPICE above...  
        viewer.openStringInline(pdb);   
        
        viewer.evalString("select *; spacefill off; wireframe off; backbone 0.5;  ");
        viewer.evalString("color chain;  ");
        this.viewer = viewer;

    }
    
    public void cambiaMutacion(Structure s, int codon, Boolean val) {  
         

        String pdb = structure.toPDB();
        JmolViewer viewer = jmolPanel.getViewer();

        // Jmol could also read the file directly from your file system  
        //viewer.openFile("/Path/To/PDB/1tim.pdb");  

        // send the PDB file to Jmol.  
        // there are also other ways to interact with Jmol, but they require more  
        // code. See the link to SPICE above...  
        viewer.openStringInline(pdb);

        viewer.evalString("select *; spacefill on; wireframe on; cartoon on;  ");
        if(val == true){
            viewer.evalString("select *; spacefill off; wireframe off; cartoon on;  ");
        }
        viewer.evalString("select nucleic; cartoon on;");
        viewer.evalString("select * ; color chain;");
        viewer.evalString("select atomno >= " + codon + " and atomno <= " + (codon + 5) + "; color {51,255,51};");
        this.viewer = viewer;

    } 
    
    public void setTitle(String label){  
        frame.setTitle(label);  
    }

    public JmolViewer getViewer(){

        return jmolPanel.getViewer();  
    }

    static class ApplicationCloser extends WindowAdapter {  
        public void windowClosing(WindowEvent e) {  
            new PJmol().frame.dispose();
        }  
    }

   static class JmolPanel extends JPanel {  
       /**  
        *   
        */  
        private static final long serialVersionUID = -3661941083797644242L;  
        JmolViewer viewer;  
        JmolAdapter adapter;  
        JmolPanel() {  
            adapter = new SmarterJmolAdapter();  
            viewer = JmolViewer.allocateViewer(this, adapter);  

        }

        public JmolViewer getViewer() {  
            return viewer;  
        }

        public void executeCmd(String rasmolScript){  
            viewer.evalString(rasmolScript);  
        }

        final Dimension currentSize = new Dimension();  
        final Rectangle rectClip = new Rectangle();

        public void paint(Graphics g) {  
            getSize(currentSize);  
            g.getClipBounds(rectClip);  
            viewer.renderScreenImage(g, currentSize, rectClip);  
        }  
    }
   
}
