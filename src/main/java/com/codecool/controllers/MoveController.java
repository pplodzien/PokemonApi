package com.codecool.controllers;

import com.codecool.DatabaseConnector.Connector;
import com.codecool.models.Move;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class MoveController {



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Move> getAll() {
        EntityManager em = Connector.getInstance().startTransaction();
        Query query = em.createQuery("select m from Move m");
        List<Move> moves = query.getResultList();
        Connector.getInstance().endTransaction();
        return moves;
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Move getMoveById(@PathParam("id") int id) {
        EntityManager em = Connector.getInstance().startTransaction();
        Move move = em.find(Move.class, id);
        Connector.getInstance().endTransaction();
        return move;
    }

//    @GET
//    @Path("/{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Move getMoveByName(@PathParam("name") String name) {
//        EntityManager em = Connector.getInstance().startTransaction();
//        Query query = em.createQuery("from Move where name = :name");
//        query.setParameter("name", name);
//        Move move = (Move) query.getSingleResult();
//        Connector.getInstance().endTransaction();
//        return move;
//    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewMove(Move move) {
        EntityManager em = Connector.getInstance().startTransaction();
        em.persist(move);
        Connector.getInstance().endTransaction();
        String response = "move added";
        return Response.ok().entity(response).build();
    }

//    @DELETE
//    @Path("{id}")
//    public Response deleteMove(@PathParam("id") int id) {
//
//    }


}
