package com.kazhamiakina.controllers.soap;

import com.kazhamiakina.model.entity.Price.Price;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Lenovo on 02.02.2017.
 */
//@WebService(name = "HelloWorld", targetNamespace = "http://com.kazhamiakina.controllers.soap/")
@WebService(name = "HelloWorld", targetNamespace = "http://Controller.kazhamiakina.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWorld {
    @WebMethod
    String getHelloWorldAsString();
    @WebMethod Price[] getAllPriceOfLens();
    @WebMethod Price createPriceOfLens(@WebParam(name = "obj") Price obj);
    @WebMethod void deletePriceOfLens(@WebParam(name = "id") int id);
    @WebMethod void updatePriceOfLens(@WebParam(name = "object") Price object);
    @WebMethod Price getByPKPriceOfLens(@WebParam(name = "id") int id);

    @WebMethod Price[] getAllPriceOfVideo();
    @WebMethod Price createPriceOfVideo(@WebParam(name = "obj") Price obj);
    @WebMethod void deletePriceOfVideo(@WebParam(name = "id") int id);
    @WebMethod void updatePriceOfVideo(@WebParam(name = "object") Price object);
    @WebMethod Price getByPKPriceOfVideo(@WebParam(name = "id") int id);


    @WebMethod Price[] getAllPriceOfPhoto();
    @WebMethod Price createPriceOfPhoto(@WebParam(name = "obj") Price obj);
    @WebMethod void deletePriceOfPhoto(@WebParam(name = "id") int id);
    @WebMethod void updatePriceOfPhoto(@WebParam(name = "object") Price object);
    @WebMethod Price getByPKPriceOfPhoto(@WebParam(name = "id") int id);
}
