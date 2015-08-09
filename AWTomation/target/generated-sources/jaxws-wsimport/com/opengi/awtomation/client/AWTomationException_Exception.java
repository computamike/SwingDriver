
package com.opengi.awtomation.client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "AWTomationException", targetNamespace = "http://awtomation.opengi.com/")
public class AWTomationException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private AWTomationException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public AWTomationException_Exception(String message, AWTomationException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public AWTomationException_Exception(String message, AWTomationException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.opengi.awtomation.client.AWTomationException
     */
    public AWTomationException getFaultInfo() {
        return faultInfo;
    }

}