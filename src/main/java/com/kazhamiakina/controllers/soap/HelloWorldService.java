package com.kazhamiakina.controllers.soap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import java.net.MalformedURLException;
import java.net.URL;

@WebServiceClient(name = "HelloWorldImplService",
        targetNamespace = "http://Controller.kazhamiakina.com/",
        wsdlLocation = "http://localhost:8080/hello?wsdl")
public class HelloWorldService extends Service {

    public HelloWorldService(URL wsdlDocumentLocation, QName serviceName) {
        super(wsdlDocumentLocation, serviceName);
    }

    public HelloWorldService() throws MalformedURLException {
        super(new URL("http://localhost:8080/hello?wsdl"),
                new QName("http://Controller.kazhamiakina.com/", "HelloWorldImplService"));
    }

    @WebEndpoint(name = "HelloWorldImplPort")
    public HelloWorld getHelloWorldImplPort() {
        return (HelloWorld)super.getPort(
                new QName("http://Controller.kazhamiakina.com/", "HelloWorldImplPort"),
                HelloWorld.class);
    }
}
