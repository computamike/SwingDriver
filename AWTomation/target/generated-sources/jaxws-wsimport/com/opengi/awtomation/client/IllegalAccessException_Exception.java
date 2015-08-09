
package com.opengi.awtomation.client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "IllegalAccessException", targetNamespace = "http://awtomation.opengi.com/")
public class IllegalAccessException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private IllegalAccessException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public IllegalAccessException_Exception(String message, IllegalAccessException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public IllegalAccessException_Exception(String message, IllegalAccessException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.opengi.awtomation.client.IllegalAccessException
     */
    public IllegalAccessException getFaultInfo() {
        return faultInfo;
    }

}
