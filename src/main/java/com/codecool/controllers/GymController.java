package com.codecool.controllers;

import com.codecool.DatabaseConnector.Connector;
import com.codecool.models.Gym;
import com.codecool.models.Trainer;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("gyms")
public class GymController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Trainer> getAll()  {
        EntityManager em = Connector.getInstance().startTransaction();
        List<Trainer> trainers = em.createNamedQuery("Gym.findAllGyms").getResultList();
        Connector.getInstance().endTransaction();
        return trainers;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Gym getGymById(@PathParam("id") int id) {
        EntityManager em = Connector.getInstance().startTransaction();
        Gym gym = em.find(Gym.class, id);
        Connector.getInstance().endTransaction();
        return gym;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewGym(Gym gym) {
        EntityManager em = Connector.getInstance().startTransaction();
        em.persist(gym);
        Connector.getInstance().endTransaction();
        String response = "gym added";
        return Response.ok().entity(response).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteGym(@PathParam("id") int id) {
        EntityManager em = Connector.getInstance().startTransaction();
        Gym gym = em.find(Gym.class, id);
        em.remove(gym);
        Connector.getInstance().endTransaction();
        String response = "gym deleted";
        return Response.ok().entity(response).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateGym(@PathParam("id") Integer id, Gym gym){
        EntityManager em = Connector.getInstance().startTransaction();
        Gym oldGym = em.find(Gym.class, id);
        oldGym.setName(gym.getName());
        oldGym.setType(gym.getType());
        oldGym.setLocation(gym.getLocation());
        Connector.getInstance().endTransaction();
        String response = "gym updated";
        return Response.ok().entity(response).build();
    }
}
