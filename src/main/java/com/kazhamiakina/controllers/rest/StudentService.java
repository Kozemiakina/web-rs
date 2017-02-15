package com.kazhamiakina.controllers.rest;

import com.kazhamiakina.controllers.soap.HelloWorld;
import com.kazhamiakina.controllers.soap.HelloWorldService;
import com.kazhamiakina.model.entity.Price.Price;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.net.MalformedURLException;

/**
 * Created by Lenovo on 02.02.2017.
 */
@Path("student")
public class StudentService {


    //@WebServiceRef(HelloWorldService.class)//(wsdlLocation = "http://localhost:8080/students?wsdl")
    //private HelloWorldService service;

    private HelloWorldService service;

    public StudentService() throws MalformedURLException {
        service = new HelloWorldService();
    }

    @GET
    @Produces("application/json")//@Produces(MediaType.APPLICATION_JSON)
    public Price[] getTrackInJSON() throws MalformedURLException{
        HelloWorld hello = service.getHelloWorldImplPort();
        Price[] result = hello.getAllPriceOfLens();
        return result;

    }

}
