package rest.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.BankCustomer;
import facades.CustomerFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("bc")
public class BankCustomerResource {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); 
    CustomerFacade cf =  CustomerFacade.getCustomerFacade(emf);
    Gson gs = new GsonBuilder().setPrettyPrinting().create();
    {
        if(cf.getAllBankCustomers().size() == 0){
            cf.addCustomer(new BankCustomer("Johnny", "Bravo", "1", 20000, 3, "bla bla"));
            cf.addCustomer(new BankCustomer("Will", "Smith", "2", 53000, 2, "bla"));
            cf.addCustomer(new BankCustomer("Mads", "Jensen", "3", 100, 3, "Halløj"));
            cf.addCustomer(new BankCustomer("Conor", "McGregor", "4", 150000, 1, "UFC Fighter"));
            cf.addCustomer(new BankCustomer("Toby", "Moby", "5", 0.5, 6, "Broke"));
            cf.addCustomer(new BankCustomer("Ice", "Cube", "1", 6239300, 1, "NWA"));
        }
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getById(@PathParam("id") int id) {
        return gs.toJson(cf.getById(id));
    }
    
    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public String getAll() {
        return gs.toJson(cf.getAllBankCustomers());
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"succes\"}";
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(BankCustomer entity) {
        throw new UnsupportedOperationException();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void update(BankCustomer entity, @PathParam("id") int id) {
        throw new UnsupportedOperationException();
    }
}
