/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fauxpen.i;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.AWTEventListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.xml.ws.Endpoint;

/**
 * Remote Service - an object that allows clients to retrieve information about
 * the forms and their contents displayed on screen, and also interact with GUI
 * controls - such as buttons, text boxes, labels, check boxes, radio buttons
 * etc.
 *
 * On Constructor : Register and create a webservice On Finalise : de register
 * the web service
 *
 * @author Mike Hingley
 */
public class RemoteService {

    static long eventMask =   AWTEvent.MOUSE_EVENT_MASK + AWTEvent.ITEM_EVENT_MASK;
  
  //static long eventMask = AWTEvent.MOUSE_MOTION_EVENT_MASK + AWTEvent.MOUSE_EVENT_MASK + AWTEvent.ITEM_EVENT_MASK;
  
    
    private static RemoteService instance = null;

    protected RemoteService() {
        // Exists only to defeat instantiation.
    }

    static Inspector ins = null;
    static
    {
        //Toolkit.getDefaultToolkit().addAWTEventListener((AWTEvent awte) -> 
        //{
         //   JFrame topFrame =  null;
         //   topFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) awte.getSource());
                
            
            
            
            
            
            //if (ins == null)
            //{
                //ins = new Inspector();
            //}
            //ins.setVisible(true);
            //if (topFrame != null && !topFrame.getClass().isAssignableFrom(Inspector.class))
            //{
               //ins.ShowAWTEvent(awte);  
            //}
            
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //}, eventMask);
    }
    
    public void mouseEventListener()
    {}
    public static RemoteService getInstance() throws IOException {
        if (instance == null) {
            instance = new RemoteService();
            executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
            StartRemoteService();

        }
        return instance;
    }
    private static Endpoint endpoint = null;

    private static ThreadPoolExecutor executor;

    private static HttpServer server = null;
    private static HttpContext context = null;

    /**
     *
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        StopRemoteService();
    }

    private static void StartRemoteService() throws IOException {
        server = HttpServer.create(new InetSocketAddress(1970), 5);
        endpoint = Endpoint.create(new RemoteControlService());
        //server.setExecutor(executor);
        server.start();

        context = server.createContext("/RemoteService/RemoteControl");
        context.setAuthenticator(new TestBasicAuthenticator("test"));
        endpoint.publish(context);
 
        System.out.println("Starting Services " + endpoint.toString());
        
    }

    private void StopRemoteService() {
      		endpoint.stop();
		server.stop(1);
    }

}
