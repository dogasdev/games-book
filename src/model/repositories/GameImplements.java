package model.repositories;

import model.entities.Game;

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

    public Game findByName(String name){
        List<Game> foundedGame = findAll();

        for(Game game : foundedGame){
            if(game.getName().equals(name)){
                return game;
            }
        }
        return  null;
    }

    public void deleteGame(String name){
        listGames.removeIf(game -> game.getName().equals(name));
    }
}
