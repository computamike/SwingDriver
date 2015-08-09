/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opengi.awtomation;

import javax.xml.ws.WebFault;

/**
 *
 * @author Mike
 */
@WebFault(name="AWTomationException")
public class AWTomationException extends Exception{
     private String message;
 
    public AWTomationException() {
    }
    public AWTomationException(String message) {
        this.message = message;
    }
 
    public String getMessage() {
        return message;
    }
}
