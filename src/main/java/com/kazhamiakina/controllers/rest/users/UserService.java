package com.kazhamiakina.controllers.rest.users;

import com.kazhamiakina.model.DAO.DAOMySQL.Users.UserController;
import com.kazhamiakina.model.entity.Users.User;

import javax.ws.rs.*;
import java.net.MalformedURLException;

/**
 * Created by alisa on 09.02.2017.
 */
@Path("/user")
public class UserService {
    UserController userController =new UserController();
    @GET
    @Produces("application/json")
    public User[] getAll() throws MalformedURLException {
        return (User[])userController.getAll().toArray();
    }
    @GET
    @Path("{id}")
    @Produces("application/json")
    public User getByPK(@PathParam("id") int id) throws MalformedURLException {
        return userController.getByPK(id);
    }
    @DELETE
    @Path("{id}")
    public void delete (@PathParam("id") int id) throws MalformedURLException {
        userController.delete(id);
    }
    @PUT
    @Path("{characteristicByLens}")
    public void update( User user) throws MalformedURLException {
        userController.update(user);
    }
    @POST
    public void create(User user) throws MalformedURLException {
        userController.create(user);
    }
}
