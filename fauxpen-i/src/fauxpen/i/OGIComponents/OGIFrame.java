/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fauxpen.i.OGIComponents;

import fauxpen.i.RemoteService;
import java.awt.Window;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mike
 */
public class OGIFrame extends javax.swing.JFrame{
   private RemoteService rs;
 
    
    /**
     *
     */
    public OGIFrame()  
    {
        super();
//        try {
//        Window ThisWindow = SwingUtilities.getWindowAncestor(this);
//        rs = RemoteService.getInstance(ThisWindow);
//        
//        } catch (IOException ex) {
//            Logger.getLogger(OGIFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }


    {
  
        try {
            rs = RemoteService.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(OGIFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}


