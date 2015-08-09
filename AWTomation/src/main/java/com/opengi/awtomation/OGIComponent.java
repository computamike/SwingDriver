/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opengi.awtomation;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Mike
 */
 
public class OGIComponent  
{     

    private boolean Checked;

    /**
     * Get the value of Checked
     *
     * @return the value of Checked
     */
    public boolean isChecked() {
        return Checked;
    }

    /**
     * Set the value of Checked
     *
     * @param Checked new value of Checked
     */
    public void setChecked(boolean Checked) {
        this.Checked = Checked;
    }

    
    private String name;
    protected String text;
    
    private String[] Values;

    /**
     * Get the value of Values
     *
     * @return the value of Values
     */
    public String[] getValues() {
        return Values;
    }

    /**
     * Set the value of Values
     *
     * @param Values new value of Values
     */
    public void setValues(String[] Values) {
        this.Values = Values;
    }

    /**
     * Get the value of Values at specified index
     *
     * @param index the index of Values
     * @return the value of Values at specified index
     */
    public String getValues(int index) {
        return this.Values[index];
    }

    /**
     * Set the value of Values at specified index.
     *
     * @param index the index of Values
     * @param Values new value of Values at specified index
     */
    public void setValues(int index, String Values) {
        this.Values[index] = Values;
    }

    public OGIComponent(JButton button) {
        text = button.getText();
        Type = button.getClass().getTypeName();
    }
        public OGIComponent(JTextField TextField) {
        text = TextField.getText();
         Type = TextField.getClass().getTypeName();
    }
        
    public OGIComponent(JComboBox TextField) {
        text = TextField.getSelectedItem().toString();
        Type = TextField.getClass().getTypeName();
        Values = new String[TextField.getItemCount()];
        for ( int i = 0;  i < TextField.getItemCount(); i++) {
            setValues(i,  (String)TextField.getItemAt(i));
        }
    }
    
    public OGIComponent(JCheckBox TextField) {
        text = TextField.getText();
        setChecked(TextField.isSelected());
        Type = TextField.getClass().getTypeName();
    }
       
    
        public OGIComponent(JTextArea TextField) {
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

