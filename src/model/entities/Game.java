package model.entities;

import model.enums.GameType;
import model.utility.InputValidator;

import java.util.UUID;

public abstract class Game {
    private static UUID internalId;
    private String name;
    private String genre;
    private GameType type;

    public Game(String name, String genre){
        this.internalId = UUID.randomUUID();
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public GameType getType(){
        return type;
    }

    public abstract String toString();
}
