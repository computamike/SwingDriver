
package com.opengi.awtomation.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.opengi.awtomation.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetControlsResponse_QNAME = new QName("http://awtomation.opengi.com/", "GetControlsResponse");
    private final static QName _SetControl_QNAME = new QName("http://awtomation.opengi.com/", "SetControl");
    private final static QName _GetControlResponse_QNAME = new QName("http://awtomation.opengi.com/", "GetControlResponse");
    private final static QName _ScreenShotResponse_QNAME = new QName("http://awtomation.opengi.com/", "ScreenShotResponse");
    private final static QName _GetString_QNAME = new QName("http://awtomation.opengi.com/", "GetString");
    private final static QName _ScreenShot_QNAME = new QName("http://awtomation.opengi.com/", "ScreenShot");
    private final static QName _GetControls_QNAME = new QName("http://awtomation.opengi.com/", "GetControls");
    private final static QName _SetControlResponse_QNAME = new QName("http://awtomation.opengi.com/", "SetControlResponse");
    private final static QName _GetControl_QNAME = new QName("http://awtomation.opengi.com/", "GetControl");
    private final static QName _IllegalAccessException_QNAME = new QName("http://awtomation.opengi.com/", "IllegalAccessException");
    private final static QName _ClickControlResponse_QNAME = new QName("http://awtomation.opengi.com/", "ClickControlResponse");
    private final static QName _IOException_QNAME = new QName("http://awtomation.opengi.com/", "IOException");
    private final static QName _AWTomationException_QNAME = new QName("http://awtomation.opengi.com/", "AWTomationException");
    private final static QName _ClickControl_QNAME = new QName("http://awtomation.opengi.com/", "ClickControl");
    private final static QName _GetStringResponse_QNAME = new QName("http://awtomation.opengi.com/", "GetStringResponse");
    private final static QName _ScreenShotResponseReturn_QNAME = new QName("", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.opengi.awtomation.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetStringResponse }
     * 
     */
    public GetStringResponse createGetStringResponse() {
        return new GetStringResponse();
    }

    /**
     * Create an instance of {@link AWTomationException }
     * 
     */
    public AWTomationException createAWTomationException() {
        return new AWTomationException();
    }

    /**
     * Create an instance of {@link ClickControl }
     * 
     */
    public ClickControl createClickControl() {
        return new ClickControl();
    }

    /**
     * Create an instance of {@link ClickControlResponse }
     * 
     */
    public ClickControlResponse createClickControlResponse() {
        return new ClickControlResponse();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link IllegalAccessException }
     * 
     */
    public IllegalAccessException createIllegalAccessException() {
        return new IllegalAccessException();
    }

    /**
     * Create an instance of {@link SetControlResponse }
     * 
     */
    public SetControlResponse createSetControlResponse() {
        return new SetControlResponse();
    }

    /**
     * Create an instance of {@link GetControl }
     * 
     */
    public GetControl createGetControl() {
        return new GetControl();
    }

    /**
     * Create an instance of {@link GetControls }
     * 
     */
    public GetControls createGetControls() {
        return new GetControls();
    }

    /**
     * Create an instance of {@link ScreenShot }
     * 
     */
    public ScreenShot createScreenShot() {
        return new ScreenShot();
    }

    /**
     * Create an instance of {@link GetString }
     * 
     */
    public GetString createGetString() {
        return new GetString();
    }

    /**
     * Create an instance of {@link ScreenShotResponse }
     * 
     */
    public ScreenShotResponse createScreenShotResponse() {
        return new ScreenShotResponse();
    }

    /**
     * Create an instance of {@link SetControl }
     * 
     */
    public SetControl createSetControl() {
        return new SetControl();
    }

    /**
     * Create an instance of {@link GetControlResponse }
     * 
     */
    public GetControlResponse createGetControlResponse() {
        return new GetControlResponse();
    }

    /**
     * Create an instance of {@link GetControlsResponse }
     * 
     */
    public GetControlsResponse createGetControlsResponse() {
        return new GetControlsResponse();
    }

    /**
     * Create an instance of {@link OgiComponent }
     * 
     */
    public OgiComponent createOgiComponent() {
        return new OgiComponent();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetControlsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://awtomation.opengi.com/", name = "GetControlsResponse")
    public JAXBElement<GetControlsResponse> createGetControlsResponse(GetControlsResponse value) {
        return new JAXBElement<GetControlsResponse>(_GetControlsResponse_QNAME, GetControlsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetControl }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://awtomation.opengi.com/", name = "SetControl")
    public JAXBElement<SetControl> createSetControl(SetControl value) {
        return new JAXBElement<SetControl>(_SetControl_QNAME, SetControl.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetControlResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://awtomation.opengi.com/", name = "GetControlResponse")
    public JAXBElement<GetControlResponse> createGetControlResponse(GetControlResponse value) {
        return new JAXBElement<GetControlResponse>(_GetControlResponse_QNAME, GetControlResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScreenShotResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://awtomation.opengi.com/", name = "ScreenShotResponse")
    public JAXBElement<ScreenShotResponse> createScreenShotResponse(ScreenShotResponse value) {
        return new JAXBElement<ScreenShotResponse>(_ScreenShotResponse_QNAME, ScreenShotResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://awtomation.opengi.com/", name = "GetString")
    public JAXBElement<GetString> createGetString(GetString value) {
        return new JAXBElement<GetString>(_GetString_QNAME, GetString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScreenShot }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://awtomation.opengi.com/", name = "ScreenShot")
    public JAXBElement<ScreenShot> createScreenShot(ScreenShot value) {
        return new JAXBElement<ScreenShot>(_ScreenShot_QNAME, ScreenShot.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetControls }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://awtomation.opengi.com/", name = "GetControls")
    public JAXBElement<GetControls> createGetControls(GetControls value) {
        return new JAXBElement<GetControls>(_GetControls_QNAME, GetControls.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetControlResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://awtomation.opengi.com/", name = "SetControlResponse")
    public JAXBElement<SetControlResponse> createSetControlResponse(SetControlResponse value) {
        return new JAXBElement<SetControlResponse>(_SetControlResponse_QNAME, SetControlResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetControl }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://awtomation.opengi.com/", name = "GetControl")
    public JAXBElement<GetControl> createGetControl(GetControl value) {
        return new JAXBElement<GetControl>(_GetControl_QNAME, GetControl.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IllegalAccessException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://awtomation.opengi.com/", name = "IllegalAccessException")
    public JAXBElement<IllegalAccessException> createIllegalAccessException(IllegalAccessException value) {
        return new JAXBElement<IllegalAccessException>(_IllegalAccessException_QNAME, IllegalAccessException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClickControlResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://awtomation.opengi.com/", name = "ClickControlResponse")
    public JAXBElement<ClickControlResponse> createClickControlResponse(ClickControlResponse value) {
        return new JAXBElement<ClickControlResponse>(_ClickControlResponse_QNAME, ClickControlResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://awtomation.opengi.com/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AWTomationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://awtomation.opengi.com/", name = "AWTomationException")
    public JAXBElement<AWTomationException> createAWTomationException(AWTomationException value) {
        return new JAXBElement<AWTomationException>(_AWTomationException_QNAME, AWTomationException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClickControl }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://awtomation.opengi.com/", name = "ClickControl")
    public JAXBElement<ClickControl> createClickControl(ClickControl value) {
        return new JAXBElement<ClickControl>(_ClickControl_QNAME, ClickControl.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStringResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://awtomation.opengi.com/", name = "GetStringResponse")
    public JAXBElement<GetStringResponse> createGetStringResponse(GetStringResponse value) {
        return new JAXBElement<GetStringResponse>(_GetStringResponse_QNAME, GetStringResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = ScreenShotResponse.class)
    public JAXBElement<byte[]> createScreenShotResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_ScreenShotResponseReturn_QNAME, byte[].class, ScreenShotResponse.class, ((byte[]) value));
    }

}
