package com.kazhamiakina.controllers.rest.Price;

import com.kazhamiakina.controllers.soap.HelloWorld;
import com.kazhamiakina.controllers.soap.HelloWorldService;
import com.kazhamiakina.model.entity.Price.Price;

import javax.ws.rs.*;
import java.net.MalformedURLException;

/**
 * Created by alisa on 09.02.2017.
 */
@Path("/prlens")
public class PriceLensService {
    private HelloWorldService service;

    public PriceLensService() throws MalformedURLException {
        service = new HelloWorldService();
    }
    @GET
    @Produces("application/json")
    public Price[] getAllPriceOfLens() throws MalformedURLException{
        HelloWorld hello = service.getHelloWorldImplPort();
        Price[] result = hello.getAllPriceOfLens();
        return result;
    }
    @POST
    @Produces("application/json")
    public Price createPriceOfLens(Price price) throws MalformedURLException{
        HelloWorld hello = service.getHelloWorldImplPort();
        Price result = hello.createPriceOfLens(price);
        return result;
    }
    @DELETE
    @Path("{id}")
    public void deletePriceOfLens(@PathParam("id") int id) throws MalformedURLException{
        HelloWorld hello = service.getHelloWorldImplPort();
        hello.deletePriceOfLens(id);
    }
    @PUT
    @Path("{characteristicByLens}")
    public void updatePriceOfLens(Price price) throws MalformedURLException{
        HelloWorld hello = service.getHelloWorldImplPort();
        hello.updatePriceOfLens(price);
    }
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Price getByPKPriceOfLens(@PathParam("id") int id) throws MalformedURLException{
        HelloWorld hello = service.getHelloWorldImplPort();
        Price price = hello.getByPKPriceOfLens(id);
        return price;
    }


}
