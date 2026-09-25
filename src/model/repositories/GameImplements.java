package model.repositories;

import model.entities.DigitalGame;
import model.entities.Game;
import model.enums.Platform;

import java.util.ArrayList;
import java.util.List;

//Tipo parametrizado escolhido == DIGITAL GAME
public class GameImplements implements GameRepository<Game>{

    List<Game> listGames = new ArrayList<>();

    public void save(Game game){
        listGames.add(game);
    }

    public List<Game> findAll(){
        return listGames;
    }
}
