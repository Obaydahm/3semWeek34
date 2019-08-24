/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import com.google.gson.Gson;
import dto.EmployeeDTO;
import entities.Employee;
import facades.EmployeeFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Obaydah Mohamad
 */
@Path("employee")
public class EmployeeResource {
    Gson gs = new Gson();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); 
    EmployeeFacade ef =  EmployeeFacade.getEmployeeFacade(emf);
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        return gs.toJson(ef.getAllEmployees());
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getById(@PathParam("id") Long id) {
        return gs.toJson(new EmployeeDTO(ef.getEmployeeById(id)));
    }
    
    @GET
    @Path("/highestpaid")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHighestPaid() {
        return gs.toJson(ef.getEmployeesWithHighestSalary());
    }
    
    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getById(@PathParam("name") String name) {
        return gs.toJson(ef.getEmployeesByName(name));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"succes\"}";
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Employee entity) {
        throw new UnsupportedOperationException();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void update(Employee entity, @PathParam("id") int id) {
        throw new UnsupportedOperationException();
    }
}
