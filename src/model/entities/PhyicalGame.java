package model.entities;

import model.enums.GameType;

public class PhyicalGame extends Game{
    private static GameType type = GameType.PHYSICAL;
    private int numberOfMediaItems;

    public PhyicalGame(String name, String genre, int numberOfMediaItems){
        super(name, genre);
        this.numberOfMediaItems = numberOfMediaItems;
    }

    public GameType getType() {
        return type;
    }

    public int getNumberOfMediaItems() {
        return numberOfMediaItems;
    }
    public void setNumberOfMediaItems(int numberOfMediaItems) {
        this.numberOfMediaItems = numberOfMediaItems;
    }

    @Override
    public String toString(){
        return "Game: " + getName() + "\n"
                + "Type: " + getType() + "\n"
                + "Genre: " + getGenre() + "\n"
                + "Number of media items: " + getNumberOfMediaItems();
    }
}
