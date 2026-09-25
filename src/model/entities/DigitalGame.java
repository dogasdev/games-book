package model.entities;

import model.enums.GameType;
import model.enums.Platform;

public class DigitalGame extends Game{
    private static GameType type = GameType.DIGITAL;
    private Platform platform;

    public DigitalGame(String name, String genre, Platform platform){
        super(name, genre);
        this.platform = platform;
    }

    public GameType getType(){
        return type;
    }

    public Platform getPlataform() {
        return platform;
    }

@Override
    public String toString(){
        return "Game: " + getName() + "\n"
                + "Type: " + getType() + "\n"
                + "Genre: " + getGenre() + "\n"
                + "Plataform: " + getPlataform();
    }
}
