package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CityInfoDTO;
import dtos.PersonDTO;
import utils.EMF_Creator;
import facades.PersonFacade;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

//Todo Remove or change relevant parts before ACTUAL use
@Path("person")
public class PersonResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final PersonFacade FACADE = PersonFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }


    @POST
    @Path("createperson")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    //@RolesAllowed("user")
    public Response createPerson(PersonDTO personDTO) {
        personDTO = FACADE.createPerson(personDTO);
        return Response.ok().entity(GSON.toJson(personDTO)).build();

    }


    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllPersons() {
        List<PersonDTO> rns = FACADE.getAllPersons();
        System.out.println(rns);
        return Response.ok().entity(GSON.toJson(rns)).build();
    }

    @GET
    @Path("/zips")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllZips() throws EntityExistsException {
        List<CityInfoDTO> c = new ArrayList<>(FACADE.getAllZips());
        return  Response.ok().entity(GSON.toJson(c)).build();
    }

}
