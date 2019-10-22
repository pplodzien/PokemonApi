package com.codecool.models;

import javax.persistence.*;
import java.util.List;


@NamedQueries(
        {
                @NamedQuery(name="Pokemon.findAllPokemons",
                        query="SELECT p FROM Pokemon p"),

                @NamedQuery(name="Pokemon.findByName",
                        query="SELECT p FROM Pokemon p WHERE p.name LIKE:pokName"),

                @NamedQuery(name="Pokemon.findFiltered",
                        query="SELECT p FROM Pokemon p WHERE p.name LIKE:pokName AND p.type LIKE:pokType"),
        }
)


@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;


    @ManyToMany(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER

    )
    private List<Move> moves;
    private String nextEvolution;
    private int pokedexNumber;
    private String height;
    private String weight;

    public Pokemon(){ }

    public Pokemon(String name, String type, List<Move> moves, String nextEvolution, int pokedexNumber, String height, String weight) {
        this.name = name;
        this.type = type;
        this.moves = moves;
        this.nextEvolution = nextEvolution;
        this.pokedexNumber = pokedexNumber;
        this.height = height;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public String getNextEvolution() {
        return nextEvolution;
    }

    public void setNextEvolution(String nextEvolution) {
        this.nextEvolution = nextEvolution;
    }

    public int getPokedexNumber() {
        return pokedexNumber;
    }

    public void setPokedexNumber(int pokedexNumber) {
        this.pokedexNumber = pokedexNumber;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
