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

    public void save(T game){
        if(findByName(game.getName()) != null){
            throw new IllegalArgumentException("ERROR: Game already exists.");
        }
        gameRepository.save(game);
    }

    public List<T> listAll(){
        return gameRepository.findAll();
    }

    public T findByName(String name){
        return gameRepository.findByName(name);
    }

    //FILTER - PREDICATE: função que recebe um objeto como argumento
    public List<T> filterByType(GameType gameType){
        List<T> receivedList = gameRepository.findAll();
        if(!receivedList.isEmpty()){
            List<T> filtredList = receivedList.stream().
                    filter((game) -> game.getType().equals(gameType))
                    .collect(Collectors.toList());

            return filtredList;
        }
        return List.of();
    }

    public void updateName(String currentName, String newName){
        T game = gameRepository.findByName(currentName);

        if (game == null) {
            throw new IllegalArgumentException("ERROR: Game not found.");
        }
        if (gameRepository.findByName(newName) != null) {
            throw new IllegalArgumentException("ERROR: Game already exists.");
        }
        game.setName(newName);
    }

    public void deleteGame(String name){
        T game = gameRepository.findByName(name);

        if(game == null){
            throw new IllegalArgumentException("ERROR: Game not found.");
        }

        gameRepository.deleteGame(name);
    }
}
