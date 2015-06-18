/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingdriver;

import java.util.List;
import javax.swing.JComponent;

/**
 *
 * @author Mike
 */
public interface IWebDriver {
   void close();
   JComponent findElement(By by);
   List<JComponent> findElements(By by);
   
}
