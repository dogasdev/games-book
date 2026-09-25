package UI;

import java.util.Scanner;

public class MenuGame {

    public int readOption(Scanner userInput){
        try{
           return Integer.parseInt(userInput.nextLine());
        }catch (NumberFormatException e){
            return 0;
        }
    }

    public void processOption(int option, Scanner userInput){
        switch (option){
            case 1 -> System.out.println("OPÇÃO UM");
        }
    }

    public void displayMenu(){
        System.out.println("=".repeat(20));
        System.out.println("   \uD83C\uDFAE GAME STORE");
        System.out.println("=".repeat(20));
    }
}
