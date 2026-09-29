package UI;

import model.entities.DigitalGame;
import model.entities.Game;
import model.entities.PhyicalGame;
import model.enums.GameType;
import model.enums.Platform;
import model.repositories.GameImplements;
import model.repositories.GameRepository;
import model.services.GameService;
import model.utility.InputValidator;

import java.util.List;
import java.util.Scanner;

public class MenuGame {
    Scanner userInput = new Scanner(System.in);

    GameRepository<Game> gameRepository = new GameImplements();
    GameService<Game> gameService = new GameService<>(gameRepository);

    public void run(){
        int option;
        do{
            displayMenu();
            option = readOption(userInput);
            processOption(option, userInput);
        }while (option != 7);
    }

    public int readOption(Scanner userInput){
        try{
           return Integer.parseInt(userInput.nextLine());
        }catch (NumberFormatException e){
            return 0;
        }
    }

    public void processOption(int option, Scanner userInput){
        switch (option){
            case 1 -> displayRegistration(userInput);
            case 2 -> displayGamesInCatalog();
        }
    }

    public void displayMenu(){
        System.out.println("=".repeat(20));
        System.out.println("   \uD83C\uDFAE GAME STORE");
        System.out.println("=".repeat(20));
        System.out.println("[1] Add game to the catalog");
        System.out.println("[2] List all games in the catalog");
        System.out.println("[3] Find a game by name");
        System.out.println("[4] Filter games by type");
        System.out.println("[5] Modify game");
        System.out.println("[6] Remove game from catalog");
        System.out.println("[7] Exit");
    }

    public void displayRegistration(Scanner userInput){
        System.out.println("> Enter the new game's information <");
        System.out.print("Name: ");
        String name = userInput.nextLine();
        while(!InputValidator.validateGameName(name)){
            System.out.print("Invalid name. Try again: ");
            name = userInput.nextLine();
        }
        System.out.print("Genre: ");
        String genre = userInput.nextLine();
        while(!InputValidator.validateGenreGame(genre)){
            System.out.print("Invalid genre. Try again: ");
            genre = userInput.nextLine();
        }
        System.out.print("What kind of game?\n- (Digital/Physical)");
        String typeChoice = userInput.nextLine().toUpperCase();

        System.out.println("DEBUG: [" + typeChoice + "]");

        Game game;

        while(!InputValidator.validateGameType(typeChoice)){
            System.out.print("This type of game does not exist. Try again: ");
            typeChoice = userInput.nextLine().toUpperCase();
        }

        GameType type = GameType.valueOf(typeChoice);
        if(type == GameType.DIGITAL){
            System.out.print("Which platform? ");
            String platformChoice = userInput.nextLine().toUpperCase();

            while(!InputValidator.validatePlatform(platformChoice)){
                System.out.print("This platform does not exist. Try again: ");
                platformChoice = userInput.nextLine().toUpperCase();
            }

            Platform platform = Platform.valueOf(platformChoice);

            game = new DigitalGame(name, genre, platform);
            gameService.save(game);
            System.out.println(game.getName() + " successfully added to the catalog.");
        }else{
            System.out.print("Physical media items: ");
            int numberOfMediaItems = InputValidator.validateMediaItemsInput(userInput);

            game = new PhyicalGame(name, genre, numberOfMediaItems);
            gameService.save(game);
            System.out.println(game.getName() + " sucessfully added to the catalog.");
        }
    }

    public void displayGamesInCatalog(){
        List<Game> catalogedGames = gameService.listAll();

        int counter = 1;
        if(catalogedGames.isEmpty()){
            System.out.println("ERROR: There are no games in the catalog.");
            return;
        }
        for(Game game : catalogedGames){
            System.out.println("[" + counter + "] \n" + game + "\n");
            counter++;
        }
    }
}
