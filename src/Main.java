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

        MenuGame menuGame = new MenuGame();

        menuGame.run();
    }
}
