package com.codecool.controllers;

import com.codecool.DatabaseConnector.Connector;
import com.codecool.models.Move;
import com.codecool.models.Pokemon;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("pokemons")
public class PokemonController {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pokemon getPokemonById(@PathParam("id") Integer id) {
        EntityManager em = Connector.getInstance().startTransaction();
        Pokemon pokemon = em.find(Pokemon.class, id);
        Connector.getInstance().endTransaction();
        return pokemon;
    }

    @GET
    @Path("{id}/moves")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Move> getPokemonsMoves(@PathParam("id") Integer id) {
        EntityManager em = Connector.getInstance().startTransaction();
        Pokemon pokemon = em.find(Pokemon.class, id);
        List<Move> moves = pokemon.getMoves();
        Connector.getInstance().endTransaction();
        return moves;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pokemon> getFilteredPokemons(@DefaultValue("%") @QueryParam("name") String name, @DefaultValue("%") @QueryParam("type") String type){
        EntityManager em = Connector.getInstance().startTransaction();
        List<Pokemon> pokemons = em.createNamedQuery("Pokemon.findFiltered").setParameter("pokName", name).setParameter("pokType", type).getResultList();
        return pokemons;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPokemon(Pokemon pokemon) {
        EntityManager em = Connector.getInstance().startTransaction();
        em.persist(pokemon);
        Connector.getInstance().endTransaction();
        String response = "pokemon added";
        return Response.ok().entity(response).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePokemon(@PathParam("id") Integer id, Pokemon pokemon){
        EntityManager em = Connector.getInstance().startTransaction();
        Pokemon oldPokemon = em.find(Pokemon.class, id);
        oldPokemon.setHeight(pokemon.getHeight());
        oldPokemon.setName(pokemon.getName());
        oldPokemon.setNextEvolution(pokemon.getNextEvolution());
        oldPokemon.setPokedexNumber(pokemon.getPokedexNumber());
        oldPokemon.setType(pokemon.getType());
        oldPokemon.setWeight(pokemon.getWeight());
        Connector.getInstance().endTransaction();
        String response = "pokemon updated";
        return Response.ok().entity(response).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletePokemon(@PathParam("id") int id) {
        EntityManager em = Connector.getInstance().startTransaction();
        Pokemon pokemon = em.find(Pokemon.class, id);
        em.remove(pokemon);
        Connector.getInstance().endTransaction();
        String response = "Pokemon deleted";
        return Response.ok().entity(response).build();
    }
}
