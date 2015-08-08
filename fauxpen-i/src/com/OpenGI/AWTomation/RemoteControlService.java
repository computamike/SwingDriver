/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OpenGI.AWTomation;

import fauxpen.i.OGIComponents.OGIComponent;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Mike
 */
@WebService(name = "RemoteControlService", serviceName = "RemoteControlService")
/**
 *
 * @author Mike
 */
public class RemoteControlService {
    
    //<editor-fold desc="Utility Functions">
    /**
     * Utility function to find a control
     * @param Path
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException 
     */
    private Component GetActualControl(String Path) throws IllegalArgumentException, IllegalAccessException {
        Window[] w = Window.getWindows();//  RegisteredWindow.getWindows();
        String[] strings = Path.split("\\\\");
        List<String> parts = new ArrayList<>(Arrays.asList(strings));
        Component result = null;
        if (parts.size() > 0) {
            String RequiredWindow = parts.get(0);
            parts.remove(0);
            Window actualWindow = FindWindow(RequiredWindow);
            result =actualWindow;
            if (parts.size()>0)
            {
                result = foobar2(actualWindow, parts);
            }
            
        }
        return result;
    }
    

    
    /**
     * This method should be renamed?  
     * It scans a container (recursively) 
     * passing what is lect of the search path, and the container the search
     * into each iteration
     * @param container
     * @param Path
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException 
     */
    private Component foobar2(Container container, List<String> Path) throws IllegalArgumentException, IllegalAccessException {
        Field[] fields = container.getClass().getDeclaredFields();
        String RequiredControl = Path.get(0);
        Path.remove(0);
        for (Field field : fields) {
            if (field.getName().equals(RequiredControl)) {
                field.setAccessible(true);
                final Container potentialMatch = (Container) field.get(container);
                if ((Path.size() > 0) && (Component.class.isAssignableFrom(Container.class))) {
                    return foobar2(potentialMatch, Path);
                }
                return potentialMatch;
            }

        }
        return null;
    }

    /**
     * Method that converts a Component to an OGIComponent.  Standard swing 
     * components cannot be sent across the wire to services, therefore they 
     * are 'copied' to an OGIComponent.
     * @param C
     * @return 
     */
    private OGIComponent ConvertComponentToOGIComponent(Component C) {
        OGIComponent convertedType = new OGIComponent();

        if (C.getClass().isAssignableFrom(JButton.class)) {
            return new OGIComponent((JButton) C);
        }

        if (C.getClass().isAssignableFrom(JTextField.class)) {
            return new OGIComponent((JTextField) C);
        }

        if (C.getClass().isAssignableFrom(JComboBox.class)) {
            return new OGIComponent((JComboBox) C);
        }

        if (C.getClass().isAssignableFrom(JCheckBox.class)) {
            return new OGIComponent((JCheckBox) C);
        }

        if (C.getClass().isAssignableFrom(JTextArea.class)) {
            return new OGIComponent((JTextArea) C);
        }

        return convertedType;
    }


        // - Maybe consider moving these to a utility class?
    private static void SetControlValue(JTextField TextField, String Value) {
        TextField.setText(Value);
    }

    private static void SetControlValue(JCheckBox TextField, String Value) {
        TextField.setSelected(Boolean.parseBoolean(Value));
    }

    private static void SetControlValue(JTextArea TextField, String Value) {
        TextField.setText(Value);
    }

    private static void SetControlValue(JComboBox comboBox, String Value) {
        comboBox.setSelectedItem(Value);
    }

    /**
     * Finds a window based on the name specified.
     * @param WindowName
     * @return 
     */
    private Window FindWindow(String WindowName) {
        Window[] windows = Window.getWindows();//RegisteredWindow.getWindows();
        for (int i = 0; i < windows.length; i++) {
            Window window = windows[i];
            if (window.getName().equals(WindowName)) {
                return window;
            }
        }
        return null;
    }
    
    
    
    
    
    
    
    //</editor-fold>
    
    //<editor-fold desc="Web Methods">
      /**
     *
     * @param Path the address of the control to query - typically in the form
     * \formname\container\container\control
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    @WebMethod(operationName = "GetControl")
    public OGIComponent GetControl(String Path) throws IllegalArgumentException, IllegalAccessException {
        Window[] w = Window.getWindows();//  RegisteredWindow.getWindows();
        OGIComponent compList = null;
        String[] strings = Path.split("\\\\");
        List<String> parts = new ArrayList<>(Arrays.asList(strings));
        Component result = null;
        if (parts.size() > 0) {
            String RequiredWindow = parts.get(0);
            parts.remove(0);
            Window actualWindow = FindWindow(RequiredWindow);
            result = foobar2(actualWindow, parts);
        }
        compList = ConvertComponentToOGIComponent(result);
        return compList;
    }

    @WebMethod(operationName = "ClickControl")
    public void ClickControl(String Path) throws IllegalArgumentException, IllegalAccessException {
        Component Control = GetActualControl(Path);

        if (Control.getClass().isAssignableFrom(JCheckBox.class)) 
        {
            ((JCheckBox) Control).doClick();
        }
        if (Control.getClass().isAssignableFrom(JButton.class)) 
        {
            ((JButton) Control).doClick();
        }        
    }

    /**
     * Takes a screen shot / image of the named window / form.
     * @param WindowName
     * @return
     * @throws IOException
     */
    @WebMethod(operationName = "ScreenShot") 
    public   byte[] getScreenShot(String WindowName) throws  AWTomationException, IOException {
        Component component = null;
        try {
            component = GetActualControl(WindowName);
            if (component !=null)
            {
                byte[] imageInByte =null;
                BufferedImage image = new BufferedImage(component.getWidth(),component.getHeight(),BufferedImage.TYPE_INT_RGB);
                // call the Component's paint method, using
                // the Graphics object of the image.
                component.paint( image.getGraphics() ); // alternately use .printAll(..)
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write( image, "png", baos );
                baos.flush();
                imageInByte = baos.toByteArray();
                baos.close();
                return imageInByte;

            }
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(RemoteControlService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RemoteControlService.class.getName()).log(Level.SEVERE, null, ex);
        }
         throw new AWTomationException("Cannot find Element");
    }
    
    
    
    
    
        @WebMethod(operationName = "SetControl")
    public void SetControl(String WindowName, String Control, String value) throws IllegalArgumentException, IllegalAccessException {
        Component c = FindWindow(WindowName);
        Field[] f = c.getClass().getDeclaredFields();
        OGIComponent compList = new OGIComponent();

        for (Field field : f) {
            if (Component.class.isAssignableFrom(field.getType())) {
                field.setAccessible(true);
                if (field.getName().equals(Control)) {
                    final Component potentialMatch = (Component) field.get(c);

                    if (potentialMatch.getClass().isAssignableFrom(JComboBox.class)) {
                        SetControlValue((JComboBox) potentialMatch, value);
                    }

                    if (potentialMatch.getClass().isAssignableFrom(JTextField.class)) {
                        SetControlValue((JTextField) potentialMatch, value);
                    }

                    if (potentialMatch.getClass().isAssignableFrom(JCheckBox.class)) {
                        SetControlValue((JCheckBox) potentialMatch, value);
                    }

                    if (potentialMatch.getClass().isAssignableFrom(JTextArea.class)) {
                        SetControlValue((JTextArea) potentialMatch, value);
                    }

                }
            }
        }

//        // Check the type of control
//        // Conditionally work with the value passed in 0
//        //
//        // For Text fields - set the value
//        //
//        // For Radio Buttons - click on the option with that label
//        //
//        // for check boxes - click on the option with that label.
//        //
//        // For Drop down lists - select the option with that label.
//        
//    // Do the update here
//         
    }
    
    
    
    
    //</editor-fold>
    
    /**
     * A simple web method that returns a "Hello World"- can be used to test 
     * that the service is indeed running.
     * @return
     */
    @WebMethod(operationName = "GetString")
    public String GetString() {
        return "Hello World";
    }

//    @WebMethod(operationName = "GetForms") 
//    @Override
//    public String GetForms()
//    {
//        Window[] windows =    Window.getWindows();//RegisteredWindow.getWindows();
//        String result = "WINDOWS : ";
//        for (int i = 0; i < windows.length; i++) {
//            Window window = windows[i];
//            result = result + window.getName() + ",";
//        }
//        
//        List<String> listA = new ArrayList<String>();
//        //return listA;
//        return result;
//    }
//    
//    @WebMethod(operationName = "GetControlsList")
//    public List<String> GetControlsList( String WindowName) throws IllegalArgumentException, IllegalAccessException {
//       Component c=  FindWindow(WindowName);
//        Field[] f =c.getClass().getDeclaredFields();
//        List<String> compList = new ArrayList<String>();
//                
//        for(Field field:f){
//            if(Component.class.isAssignableFrom(field.getType()))
//            {
//                                
//                field.setAccessible(true);
//
////                final Object potentialMatch = field.get(c);
////                OGIComponent str = (OGIComponent)potentialMatch;
//                compList.add(field.getName());
//            } 
//
//        }
//    return compList;
//}

//    @WebMethod(operationName = "GetControl")
//    public OGIComponent GetControl( String WindowName, String Control ) throws IllegalArgumentException, IllegalAccessException {
//       Component c=  FindWindow(WindowName);
//        Field[] f =c.getClass().getDeclaredFields();
//        OGIComponent compList = new OGIComponent();
//                
//        for(Field field:f){
//            if(Component.class.isAssignableFrom(field.getType()))
//            {
//                field.setAccessible(true);
//                if  (field.getName().equals(Control))          
//                {         
//                    
//                    final Component potentialMatch = (Component)field.get(c);
//                  compList=   ConvertComponentToOGIComponent(potentialMatch);
//                }
//            } 
//
//        }
//    return compList;
//        return null;
//    }
//    @WebMethod(operationName = "GetControlByPath")
//    public OGIComponent GetControl( String NavigationPath ) throws IllegalArgumentException, IllegalAccessException {
//       Component c=  FindWindow(WindowName);
//        Field[] f =c.getClass().getDeclaredFields();
//  OGIComponent compList = new OGIComponent();
//                
//        for(Field field:f){
//            if(Component.class.isAssignableFrom(field.getType()))
//            {
//                field.setAccessible(true);
//                if  (field.getName().equals(Control))          
//                {         
//                    
//                    final Component potentialMatch = (Component)field.get(c);
////                OGIComponent str = (OGIComponent)potentialMatch;
//                  compList=   ConvertComponentToOGIComponent(potentialMatch);
//                }
//            } 
//
//        }
//   return compList;
//    }
//    @WebMethod(operationName = "ClickButton")
//    public void ClickButton( String WindowName, String Control ) throws IllegalArgumentException, IllegalAccessException {
//       Component c=  FindWindow(WindowName);
//        Field[] f =c.getClass().getDeclaredFields();
//        OGIComponent compList = new OGIComponent();
//                
//        for(Field field:f){
//            if(JButton.class.isAssignableFrom(field.getType()))
//            {
//                field.setAccessible(true);
//                if  (field.getName().equals(Control))
//                {         
//                    
//                    final JButton potentialMatch = (JButton)field.get(c);
////                potenti
//                    potentialMatch.doClick();
//                }
//            } else {
//            }
//            
//        }
//     }
//    
//    
//    @WebMethod(operationName = "GetControlByLabel")
//    public OGIComponent GetControlByLabel( String WindowName, String Caption ) throws IllegalArgumentException, IllegalAccessException {
//       Component c=  FindWindow(WindowName);
//        Field[] f =c.getClass().getDeclaredFields();
//        OGIComponent compList = new OGIComponent();
//                
//        for(Field field:f){
//            if(JLabel.class.isAssignableFrom(field.getType()))
//            {               
//                field.setAccessible(true);
//                final JLabel potentialMatch = (JLabel)field.get(c);
//                
//                if  (potentialMatch.getText().equals(Caption))          
//                {  
//                    if (potentialMatch.getLabelFor() != null)
//                    {
//                        compList=   ConvertComponentToOGIComponent(potentialMatch.getLabelFor());
//                    }
//                 }
//            } 
//        }
//    return compList;
//    }
//    



//   
//    
//    



//    private static Component FindControl(Window Window, String ControlID) throws IllegalArgumentException, IllegalAccessException
//    {
//        List<Component> Controls = getAllComponents(Window);
//        for (Component Control : Controls) {
//            
//            if (Control.getName() != null && Control.getName().equals(ControlID)) {
//                return Control;
//            }
//                 
//        }
//        return null;
//    }
//    @WebMethod(operationName = "GetControls") 
//    public List<Component>  GetControls(String FormName)
//    {
//        String result = "ERROR";
//        Window[] windows =    MainForm.getWindows();
//        
//        Window RequiredForm = FindWindow(FormName);
//         List<Component> Controls = null;
//         
//        if (RequiredForm != null) 
//        {
//            result = "Controls : ";
//           
//            try {
//                Controls = getAllComponents(RequiredForm);
//            } catch (IllegalArgumentException ex) {
//                Logger.getLogger(RemoteControlService.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IllegalAccessException ex) {
//                Logger.getLogger(RemoteControlService.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            for (Component Control : Controls) {
//                result = result + Control.getName() + "[" + Control.toString() + "]";
//            }
//   
//        }
//        
//         return Controls;
//    }
//    
//    @WebMethod(operationName = "PressButton")
//    @Override
//    public void PressButton()
//    {
//        Window w = FindWindow("MainForm");
//        //Component c = null;
//        //try {
//           // c = (w,"jButton1");
//        //} catch (IllegalArgumentException ex) {
//        //    Logger.getLogger(RemoteControlService.class.getName()).log(Level.SEVERE, null, ex);
//        //} catch (IllegalAccessException ex) {
//        //    Logger.getLogger(RemoteControlService.class.getName()).log(Level.SEVERE, null, ex);
//       // }
//        //if (c instanceof JButton) {
//        //    JButton j = (JButton)c;
//         //   j.doClick(50);
//            
//        //}
//         
//    }
//
//    @Override
//    public List<String> GetFormsArray() {
//        
//        List<String> results = new ArrayList<String>();
//        Window[] windows =    Window.getWindows();// RegisteredWindow.getWindows();
//        for (int i = 0; i < windows.length; i++) {
//            Window window = windows[i];
//            results.add(window.getName());
//        }
//        
//         return results;
//    }
// 
    /**
     *
     * @param FormName
     * @return
     */
    public String GetControls(String FormName) {
        return "foo";
    }

}
