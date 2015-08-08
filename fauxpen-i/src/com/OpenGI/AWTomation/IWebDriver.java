/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OpenGI.AWTomation;

import java.awt.Component;
import java.util.List;
import javax.jws.WebMethod;

/**
 *
 * @author Mike
 */
public interface IWebDriver {

    // The interface
    // * I need to be able to : 
    // * List the Forms
    // * List the control for a Form
    // * Click on a button
    // * Enter text into a control
    // * read values from a control
    // * take a screenshot
    
    @WebMethod(operationName = "GetFormsArray")
    List<String> GetFormsArray();    
    
    @WebMethod(operationName = "GetControls")
    String GetControls(String FormName);

  
   
    
    @WebMethod(operationName = "GetForms")
    String GetForms();

    @WebMethod(operationName = "GetString")
    String GetString();

    @WebMethod(operationName = "PressButton")
    void PressButton();

    
    
}
