import UI.MenuGame;
import model.entities.DigitalGame;
import model.entities.Game;
import model.entities.PhyicalGame;
import model.enums.GameType;
import model.enums.Platform;
import model.repositories.GameImplements;
import model.repositories.GameRepository;
import model.services.GameService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        MenuGame menuGame = new MenuGame();

        Game digitalGame = new DigitalGame("GTA 6", "PORRADARIA", Platform.ROCKSTAR);
        Game fisico = new PhyicalGame("CRASH", "LIVRE", 10);

        GameRepository gameRepository = new GameImplements();
        GameService gameService = new GameService(gameRepository);

        gameService.save(fisico);
        gameService.save(digitalGame);

        gameService.filterByType(GameType.PHYSICAL);
        gameService.filterByType(GameType.DIGITAL);

    }
}
