package model.utility;

import model.enums.GameType;
import model.enums.Platform;

import java.util.Scanner;

public class InputValidator {

    public static boolean validateGameType(String typeChoice){
        try {
            GameType.valueOf(typeChoice);
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }
    }

    public static boolean validatePlatform(String platformChoice){
        try{
            Platform.valueOf(platformChoice);
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }
    }

    public static int validateMediaItemsInput(Scanner userInput){
        while(true){
            try{
                return Integer.parseInt(userInput.nextLine());
            }catch (NumberFormatException e){
                System.out.print("ERROR: This physical number of media items is invalid. Try again: ");
            }
        }
    }

    public static boolean validateGameName(String name){
        return name != null && !name.isBlank();
    }

    public static boolean validateGenreGame(String genre){
        return genre != null && genre.length() >= 4;
    }
}

