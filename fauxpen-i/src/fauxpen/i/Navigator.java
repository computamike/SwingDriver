/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fauxpen.i;

import java.awt.Frame;
import java.awt.Window;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFrame;
import fauxpen.i.MainForm;

/**
 *
 * @author Mike
 */
public class Navigator {

    
    private static java.awt.Container FooBar2(java.awt.Container container ,List<String> Path)
    {
        return container;
    }
    
    public static java.awt.Container foobar(String Path)
    {
        Window[] w= JFrame.getWindows();
        Frame[] f = JFrame.getFrames();
        List<String> parts = Arrays.asList(Path.split("\\"));
        java.awt.Container res = null ;
                
        if (parts.size() > 0)
        {
            String RequiredWindow = parts.get(0);
            parts.remove(0);
            for (Frame win : f) {
                if(win.getName() == null ? RequiredWindow == null : win.getName().equals(RequiredWindow))
                {
                    res  = FooBar2(win,parts);
                }
            }
        }
        
        return res;
        // if the Path is Not empty
        //  Get the children for the component
        //  if I Find the child matching the name
        //  -- Return the results of foobar(rest of path, child)
        //  else
        //  return Null
        // else
        //  return component
        //
    }
    
}
