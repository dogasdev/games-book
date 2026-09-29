package model.repositories;

import model.entities.Game;

import java.util.List;

//A Interface vai trabalhar com tipos parametrizados. Quem a implementar que defina o tipo específico
public interface GameRepository<T extends Game> {

    void save(T game);

    List<T> findAll();

    T findByName(String name);

    void deleteGame(String name);
}
