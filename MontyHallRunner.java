import java.util.Scanner;

public class MontyHallRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Monty Hall game!");
        System.out.println("There are two goats and a car randomly placed behind doors 1, 2, and 3.");
        System.out.println("Where do you think the car is? Enter 1, 2, or 3:");
        int chosenDoor = scanner.nextInt();

        if (chosenDoor < 1 || chosenDoor > 3) {
            System.out.println("Invalid choice. Please choose a door between 1 and 3.");
            return;
        }

        MontyHall game = new MontyHall(chosenDoor);
        game.revealDoor();
        System.out.println("Do you want to switch your guess? Yes or No:");

        String switchChoice = scanner.next();
        if (switchChoice.equals("yes")) {
            game.switchDoors();
            System.out.println("You switched doors to door " + game.chosenDoor + ".");
        } else if (switchChoice.equals("no")) {
            System.out.println("You chose to stick with your initial choice of door " + chosenDoor + ".");
        } else {
            System.out.println(
                    "Invalid input. Assuming you want to stick with your initial choice of door " + chosenDoor + ".");
        }

        boolean win = game.checkWin();

        if (win) {
            System.out.println("You won the car!");
        } else {
            System.out.println(
                    "The car was behind door " + game.winningDoor + ". You lost! (Or you could say you won a goat!)");
        }
    }
}