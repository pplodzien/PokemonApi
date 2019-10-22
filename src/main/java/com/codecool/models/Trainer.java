package com.codecool.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@NamedQuery(name="Trainer.findAllTrainers",
        query="SELECT t FROM Trainer t")

@Entity
public class Trainer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String nickName;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST

    )
    private List<Pokemon> pokemons;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST
    )
    private List<Gym> gymsBeaten;

    public Trainer(){ }

    public Trainer(String firstName, String lastName, String nickName, List<Pokemon> pokemons, List<Gym> gymsBeaten){
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.pokemons = pokemons;
        this.gymsBeaten = gymsBeaten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Gym> getGymsBeaten() {
        return gymsBeaten;
    }

    public void setGymsBeaten(List<Gym> gymsBeaten) {
        this.gymsBeaten = gymsBeaten;
    }
}
