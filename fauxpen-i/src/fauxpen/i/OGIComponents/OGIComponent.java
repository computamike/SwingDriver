/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fauxpen.i.OGIComponents;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Mike
 */
 
public class OGIComponent  
{     
    private String name;
    protected String text;
    
    public OGIComponent(JButton button) {
        text = button.getText();
        Type = button.getClass().getTypeName();
    }
        public OGIComponent(JTextField TextField) {
        text = TextField.getText();
         Type = TextField.getClass().getTypeName();
    }
    public OGIComponent() {
        
    }
    
        private String Type;

    /**
     * Get the value of Type
     *
     * @return the value of Type
     */
    public String getType() {
        return Type;
    }

    /**
     * Set the value of Type
     *
     * @param Type new value of Type
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    
    
    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of text
     *
     * @return the value of text
     */
    public String getText() {
        return text;
    }

    /**
     * Set the value of text
     *
     * @param text new value of text
     */
    public void setText(String text) {
        this.text = text;
    }

 
}

