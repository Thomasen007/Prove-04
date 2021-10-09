package nielson;

import java.io.*;
import java.util.Scanner;

//This program asks for you name and your favorite game.
//It repeats what you said then stores your response in the game.txt file in the src folder.

public class Main {

    public static void main(String[] args) {

        String name;
        String game;
        String output;

        Scanner scan = new Scanner(System.in);
        System.out.println("What is your Name?");
        name = scan.nextLine();
        System.out.println("What is your favorite game?");
        game = scan.nextLine();
        scan.close();
        System.out.print("Your name is " + name + " and your favorite game is " + game + ".\n");

        try (FileWriter write = new FileWriter("game.txt", true)) {
            try (BufferedWriter buffer = new BufferedWriter(write)) {
                try (PrintWriter print = new PrintWriter(buffer)) {

                    print.println(name+"'s favorite game is "+game+".");
                    print.close();
                    System.out.println("Successfully wrote to the file.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
