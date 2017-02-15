package com.kazhamiakina.controllers.soap;

import com.kazhamiakina.model.entity.Price.Price;

import java.net.MalformedURLException;


/**
 * Created by Lenovo on 05.02.2017.
 */
public class Test {

    //@WebServiceRef(wsdlLocation = "HelloWorldImplService")//"http://localhost:8080/students?wsdl")
   // private static HelloWorld service;

    public static void main(String[] args) throws MalformedURLException {
        HelloWorldService service = new HelloWorldService();
        HelloWorld hello = service.getHelloWorldImplPort();
        Price[] result =hello.getAllPriceOfLens();
        //Student[] result =service.getAll();
        for (Price item : result){
            System.out.println(item.toString());
        }
    }
}
