/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fauxpen.i;

 
import fauxpen.i.OGIComponents.OGIComponent;
import java.awt.Component;
import java.awt.Label;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


@WebService(name = "RemoteControlService" ,serviceName = "RemoteControlService")
/**
 *
 * @author Mike
 */
public class RemoteControlService implements IWebDriver {
    
    
    
    @WebMethod(operationName = "GetString")
    @Override
    public String GetString()
    {
        return "Hello World";
    }
    
    @WebMethod(operationName = "GetForms") 
    @Override
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
    
    @WebMethod(operationName = "GetControlsList")
    public List<String> GetControlsList( String WindowName) throws IllegalArgumentException, IllegalAccessException {
       Component c=  FindWindow(WindowName);
        Field[] f =c.getClass().getDeclaredFields();
        List<String> compList = new ArrayList<String>();
                
        for(Field field:f){
            if(Component.class.isAssignableFrom(field.getType()))
            {
                                
                field.setAccessible(true);

//                final Object potentialMatch = field.get(c);
//                OGIComponent str = (OGIComponent)potentialMatch;
                compList.add(field.getName());
            } 

        }
    return compList;
}
    
    private OGIComponent ConvertComponentToOGIComponent(Component C)
    {   OGIComponent convertedType = new OGIComponent();
        
        if (C.getClass().isAssignableFrom(JButton.class))
        {
            return new OGIComponent((JButton)C);
        }
        
        if (C.getClass().isAssignableFrom(JTextField.class))
        {
            return new OGIComponent((JTextField)C);
        }
        
        if (C.getClass().isAssignableFrom(JComboBox.class))
        {
            return new OGIComponent((JComboBox)C);
        }
        
        if (C.getClass().isAssignableFrom(JCheckBox.class))
        {
            return new OGIComponent((JCheckBox)C);
        }
        
        if (C.getClass().isAssignableFrom(JTextArea.class))
        {
            return new OGIComponent((JTextArea)C);
        }
        
        
        
        
        return convertedType;
    }
    
    /**
     * Takes a screen shot / image of the named window / form.
     * @param WindowName
     * @return
     * @throws IOException
     */
    @WebMethod(operationName = "ScreenShot") 
    public   byte[] getScreenShot(String WindowName) throws IOException {
        Component component = FindWindow( WindowName);
        BufferedImage image = new BufferedImage(component.getWidth(),component.getHeight(),BufferedImage.TYPE_INT_RGB);
        // call the Component's paint method, using
        // the Graphics object of the image.
        component.paint( image.getGraphics() ); // alternately use .printAll(..)
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	
        ImageIO.write( image, "png", baos );
	baos.flush();
	byte[] imageInByte = baos.toByteArray();
	baos.close();
 
 
                
        
        return imageInByte;
    }
    
    
    @WebMethod(operationName = "GetControl")
    public OGIComponent GetControl( String WindowName, String Control ) throws IllegalArgumentException, IllegalAccessException {
       Component c=  FindWindow(WindowName);
        Field[] f =c.getClass().getDeclaredFields();
        OGIComponent compList = new OGIComponent();
                
        for(Field field:f){
            if(Component.class.isAssignableFrom(field.getType()))
            {
                field.setAccessible(true);
                if  (field.getName().equals(Control))          
                {         
                    
                    final Component potentialMatch = (Component)field.get(c);
//                OGIComponent str = (OGIComponent)potentialMatch;
                  compList=   ConvertComponentToOGIComponent(potentialMatch);
                }
            } 

        }
    return compList;
    }
    
 
    @WebMethod(operationName = "ClickButton")
    public void ClickButton( String WindowName, String Control ) throws IllegalArgumentException, IllegalAccessException {
       Component c=  FindWindow(WindowName);
        Field[] f =c.getClass().getDeclaredFields();
        OGIComponent compList = new OGIComponent();
                
        for(Field field:f){
            if(JButton.class.isAssignableFrom(field.getType()))
            {
                field.setAccessible(true);
                if  (field.getName().equals(Control))
                {         
                    
                    final JButton potentialMatch = (JButton)field.get(c);
//                potenti
                    potentialMatch.doClick();
                }
            } else {
            }
            
        }
     }
    
    
    @WebMethod(operationName = "GetControlByLabel")
    public OGIComponent GetControlByLabel( String WindowName, String Caption ) throws IllegalArgumentException, IllegalAccessException {
       Component c=  FindWindow(WindowName);
        Field[] f =c.getClass().getDeclaredFields();
        OGIComponent compList = new OGIComponent();
                
        for(Field field:f){
            if(JLabel.class.isAssignableFrom(field.getType()))
            {               
                field.setAccessible(true);
                final JLabel potentialMatch = (JLabel)field.get(c);
                
                if  (potentialMatch.getText().equals(Caption))          
                {  
                    if (potentialMatch.getLabelFor() != null)
                    {
                        compList=   ConvertComponentToOGIComponent(potentialMatch.getLabelFor());
                    }
                 }
            } 
        }
    return compList;
    }
    
    // - Maybe consider moving these to a utility class?
    
    private static void SetControlValue(JTextField TextField, String Value)
    {
        TextField.setText(Value);
    }
    
    
    private static void SetControlValue(JCheckBox TextField, String Value)
    {
        TextField.setSelected(Boolean.parseBoolean(Value));
    }
        
    private static void SetControlValue(JTextArea TextField, String Value)
    {
        TextField.setText(Value);
    }
    
    private static void SetControlValue(JComboBox comboBox, String Value)
    {
        comboBox.setSelectedItem(Value);
        
//        for (int i = 0; comboBox.getItemCount() >= i; i++) 
//        {
//            Object itemAt = comboBox.getItemAt(i);
//            if (comboBox.getItemAt(i).
//            
//        }
    
    }
    
    
    
    
    
    
     @WebMethod(operationName = "SetControl")
    public void SetControl( String WindowName, String Control, String value ) throws IllegalArgumentException, IllegalAccessException {
       Component c=  FindWindow(WindowName);
        Field[] f =c.getClass().getDeclaredFields();
        OGIComponent compList = new OGIComponent();
                
        for(Field field:f){
            if(Component.class.isAssignableFrom(field.getType()))
            {
                field.setAccessible(true);
                if  (field.getName().equals(Control))          
                {
                    final Component potentialMatch = (Component)field.get(c);
                    
                    if (potentialMatch.getClass().isAssignableFrom(JComboBox.class))
                    {
                         SetControlValue((JComboBox)potentialMatch,  value);
                    }
                    
                    if (potentialMatch.getClass().isAssignableFrom(JTextField.class))
                    {
                         SetControlValue((JTextField)potentialMatch,  value);
                    }
                                        
                    if (potentialMatch.getClass().isAssignableFrom(JCheckBox.class))
                    {
                         SetControlValue((JCheckBox)potentialMatch,  value);
                    }
                                                            
                    if (potentialMatch.getClass().isAssignableFrom(JTextArea.class))
                    {
                         SetControlValue((JTextArea)potentialMatch,  value);
                    }
                    
                    
                    
                }
            } 
        }
 
        // Check the type of control
        // Conditionally work with the value passed in 0
        //
        // For Text fields - set the value
        //
        // For Radio Buttons - click on the option with that label
        //
        // for check boxes - click on the option with that label.
        //
        // For Drop down lists - select the option with that label.
        
    // Do the update here
         
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
    
    @WebMethod(operationName = "PressButton")
    @Override
    public void PressButton()
    {
        Window w = FindWindow("MainForm");
        //Component c = null;
        //try {
           // c = (w,"jButton1");
        //} catch (IllegalArgumentException ex) {
        //    Logger.getLogger(RemoteControlService.class.getName()).log(Level.SEVERE, null, ex);
        //} catch (IllegalAccessException ex) {
        //    Logger.getLogger(RemoteControlService.class.getName()).log(Level.SEVERE, null, ex);
       // }
        //if (c instanceof JButton) {
        //    JButton j = (JButton)c;
         //   j.doClick(50);
            
        //}
         
    }

    @Override
    public List<String> GetFormsArray() {
        
        List<String> results = new ArrayList<String>();
        Window[] windows =    MainForm.getWindows();
        for (int i = 0; i < windows.length; i++) {
            Window window = windows[i];
            results.add(window.getName());
        }
        
         return results;
    }
 

    @Override
    public String GetControls(String FormName) {
   return"foo";
    }


}
