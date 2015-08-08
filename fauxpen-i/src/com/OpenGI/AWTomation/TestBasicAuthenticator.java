/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OpenGI.AWTomation;

import com.sun.net.httpserver.BasicAuthenticator;

/**
 *
 * @author Mike
 */
class TestBasicAuthenticator extends  BasicAuthenticator {

    public TestBasicAuthenticator(String string) {
        super(string);
    }

    
    @Override
    public boolean checkCredentials(String string, String string1) {
return true;        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
