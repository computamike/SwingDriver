/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.opengi.awtomation.RemoteService;
import com.opengi.awtomation.client.RemoteControlService;
import com.opengi.awtomation.client.RemoteControlService_Service;
import fauxpen.i.MainForm;
import java.awt.Component;
import java.awt.Container;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.xml.ws.BindingProvider;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 *
 * @author Mike
 */
public class NewEmptyJUnitTest {
 
    @Test
    public void FakeMainForm() throws IllegalArgumentException, IllegalAccessException
    {
        
        JComboBox potentialMatch = null;
        fauxpen.i.MainForm mockedList = mock(fauxpen.i.MainForm.class);
      
        
        Field[] fields = mockedList.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("jComboBox1")) {
                field.setAccessible(true);
                potentialMatch = (JComboBox) field.get(mockedList);
            }
        }
        String SELITEM = potentialMatch.getSelectedItem().toString();
        Assert.assertEquals("Apples",SELITEM);
    }
    
        @Test
    public void FakeForm()
    {
        // mock creation
        JFrame mockedList = mock(JFrame.class);
        mockedList.setVisible(true);
        verify(mockedList).setVisible(true);
    }
    
    
    @Test
    public void TestThatServiceCanRespondToInternalRequests() throws IOException, InterruptedException
    {
        RemoteService.getInstance().StartRemoteService(); 
        com.opengi.awtomation.client.RemoteControlService_Service Service =new RemoteControlService_Service();
        com.opengi.awtomation.client.RemoteControlService port = Service.getRemoteControlServicePort();
        BindingProvider bp = (BindingProvider)port;
        Map r = bp.getRequestContext();
        r.put(BindingProvider.USERNAME_PROPERTY, "admin");
        r.put(BindingProvider.PASSWORD_PROPERTY, "test");
        String s = port.getString();
        Assert.assertEquals("Hello World",s);
    }
   
}
