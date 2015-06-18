/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingdriver;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.JComponent;

/**
 *
 * @author Mike
 */
public interface IWebDriver {
   
    /**
     *Closes the SWING application
     */
    void close();
    
    /**
     * Find an Element
     * @param by the Mechanism by which the find is performed
     * @return
     */
    JComponent findElement(By by);
   List<JComponent> findElements(By by);
   BufferedImage getScreenShot(Component component);
}
