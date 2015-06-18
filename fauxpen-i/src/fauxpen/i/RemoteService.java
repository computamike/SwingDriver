/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fauxpen.i;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
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

    private static RemoteService instance = null;

    protected RemoteService() {
        // Exists only to defeat instantiation.
    }

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
    }

    private void StopRemoteService() {
      		endpoint.stop();
		server.stop(1);
    }

}
