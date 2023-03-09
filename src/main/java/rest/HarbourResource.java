package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.HarbourDTO;
import dtos.BoatDTO;
import entities.Harbour;
import facades.HarbourFacade;
import facades.FacadeExample;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("harbour")

public class HarbourResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final HarbourFacade FACADE =  HarbourFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        List<HarbourDTO> rns = FACADE.getAll();
        return Response.ok().entity(GSON.toJson(rns)).build();
    }

    @POST
    @Path("createharbour")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @RolesAllowed("admin")
    public Response createHarbour(HarbourDTO harbourDTO) {
        harbourDTO = FACADE.createHarbour(harbourDTO);
        return Response.ok().entity(GSON.toJson(harbourDTO)).build();
    }
    @DELETE
    @Path("deleteharbour/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @RolesAllowed("admin")
    public Response deleteAuction(@PathParam("id") int id) {
        FACADE.deleteAuction(id);
        return Response.ok().entity(GSON.toJson(id)).build();
    }

    @PUT
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @RolesAllowed("admin")
    public Response updateHarbour(@PathParam("id") int id, String a) {
        HarbourDTO harbourDTO = GSON.fromJson(a, HarbourDTO.class);
        harbourDTO.setId(id);
        HarbourDTO result = FACADE.updateHarbour(harbourDTO);
        return Response.ok().entity(GSON.toJson(result)).build();
    }
}