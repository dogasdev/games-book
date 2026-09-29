package model.services;

import model.entities.Game;
import model.enums.GameType;
import model.repositories.GameRepository;

import java.util.List;
import java.util.stream.Collectors;

public class GameService<T extends Game> {

    GameRepository<T> gameRepository;

    public GameService(GameRepository<T> gameRepository){
        this.gameRepository = gameRepository;
    }

    //CREATE
    public void save(T game){
        gameRepository.save(game);
    }
    //READ
    public List<T> listAll(){
        return gameRepository.findAll();
    }

    //FILTER - PREDICATE: função que recebe um objeto como argumento
    public List<T> filterByType(GameType gameType){
        List<T> receivedList = gameRepository.findAll();
        List<T> filtredList = receivedList.stream().filter((game)
                -> game.getType().equals(gameType))
                .collect(Collectors.toList());

        return filtredList;
    }
}
