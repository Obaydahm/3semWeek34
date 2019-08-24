/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entities.Animal1;
import entities.AnimalFacade;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Obaydah Mohamad
 */
@Path("animal")
public class AnimalResource {
    Gson gs = new Gson();
    Random r = new Random();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    AnimalFacade af = AnimalFacade.getInstance(emf);
    List<Animal1> animals = af.allAnimals();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalResource
     */
    public AnimalResource() {
    }

    /**
     * Retrieves representation of an instance of rest.AnimalResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/random")
    //@Produces(MediaType.APPLICATION_JSON)
    public String getRandom() {
        return gs.toJson(animals.get(r.nextInt(animals.size())));
    }
    
    @GET
    @Path("/all")
    //@Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        return gs.toJson(animals);
    }
    
    @GET
    @Path("/{id}")
    //@Produces(MediaType.APPLICATION_JSON)
    public String byId(@PathParam("id") Long id) {
        return gs.toJson(af.findByID(id));
    }

    /**
     * PUT method for updating or creating an instance of AnimalResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
