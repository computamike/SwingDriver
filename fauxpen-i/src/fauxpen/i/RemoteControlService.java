/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fauxpen.i;

import java.awt.Component;
import java.awt.Container;
import java.awt.Window;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.swing.JButton;

@WebService(name = "RemoteControlService" ,serviceName = "RemoteControlService")
/**
 *
 * @author Mike
 */
public class RemoteControlService {
    
    
    
    @WebMethod(operationName = "GetString")
    public String GetString()
    {
        return "Hello World";
    }
    
    @WebMethod(operationName = "GetForms") 
    public String GetForms()
    {
        Window[] windows =    MainForm.getWindows();
        String result = "WINDOWS : ";
        for (int i = 0; i < windows.length; i++) {
            Window window = windows[i];
            result = result + window.getName() + ",";
        }
        
        List<String> listA = new ArrayList<String>();
        //return listA;
        return result;
    }
    
    public static List<Component> getAllComponents(final Container c) {
    Component[] comps = c.getComponents();
    List<Component> compList = new ArrayList<Component>();
    for (Component comp : comps) {
        compList.add(comp);
        if (comp instanceof Container)
            compList.addAll(getAllComponents((Container) comp));
    }
    return compList;
}
    
    public static Window FindWindow(String WindowName)
    {
        Window[] windows =    MainForm.getWindows();
      
 
        for (int i = 0; i < windows.length; i++) {
            Window window = windows[i]; 
            if (window.getName().equals(WindowName)) {
               return window;
            }
         }
        return null;
    }
    
    public static Component FindControl(Window Window, String ControlID)
    {
        List<Component> Controls = getAllComponents(Window);
        for (Component Control : Controls) {
            
            if (Control.getName() != null && Control.getName().equals(ControlID)) {
                return Control;
            }
                 
        }
        return null;
    }
    
    
    @WebMethod(operationName = "GetControls") 
    public String GetControls(String FormName)
    {
        Window[] windows =    MainForm.getWindows();
        String result = "Controls : ";
        Window RequiredForm = null;
        for (int i = 0; i < windows.length; i++) {
            Window window = windows[i];
            if (window.getName().equals(FormName)) {
                RequiredForm = window;
            }
            
        }
        if (RequiredForm != null) 
        {
            List<Component> Controls = getAllComponents(RequiredForm);
            for (Component Control : Controls) {
                result = result + Control.getName() + "[" + Control.toString() + "]";
            }
   
        }
        
         return result;
    }
    
    
    @WebMethod(operationName = "PressButton")
    public void PressButton()
    {
        Window w = FindWindow("MainForm");
        Component c=   FindControl(w,"jButton1");
        if (c instanceof JButton) {
            JButton j = (JButton)c;
            j.doClick(50);
            
        }
         
    }
    
    
}
