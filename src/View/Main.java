package View;

import Controller.Menus.*;
import Model.Player.Player;
import Model.Player.Profile;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Menu.init();
        Profile profile;
        Player player;
        while (true) {
            String input = scanner.nextLine();
            if (Menu.menuHandler.getCurrentMenu() == Menu.loginMenu) {
                if (input.equalsIgnoreCase("create account")) {
                    String username = scanner.nextLine();
                    String password = scanner.nextLine();
                    Menu.loginMenu.createAccount(username, password);
                } else if (input.equalsIgnoreCase("login")) {
                    String username = scanner.nextLine();
                    String password = scanner.nextLine();
                    profile = Menu.loginMenu.Login(username, password);
                } else if (input.equalsIgnoreCase("Leaderboard")) {
                    Menu.leaderBoard.showPlayers();
                } else if (input.equalsIgnoreCase("help")) {
                    Menu.help();
                } else if (input.equalsIgnoreCase("Exit")) {
                    Menu.loginMenu.exit();
                } else if (input.equalsIgnoreCase("\n")) {
                    System.out.println("invalid command");
                }
            }
            if (Menu.menuHandler.getCurrentMenu() == Menu.mainMenu) {
                if (input.equalsIgnoreCase("play"))
                    Menu.menuHandler.setCurrentMenu(Menu.playMenu);
                else if (input.equalsIgnoreCase("Profiles"))
                    Menu.menuHandler.setCurrentMenu(Menu.profileMenu);
                else if (input.equalsIgnoreCase("Shop"))
                    Menu.menuHandler.setCurrentMenu(Menu.shopMenu);
                else if (input.equalsIgnoreCase("Exit"))
                    Menu.menuHandler.setCurrentMenu(Menu.loginMenu);
                else if (input.equalsIgnoreCase("help"))
                    Menu.help();
                else
                    System.out.println("invalid command");
            }
            if (Menu.menuHandler.getCurrentMenu() == Menu.profileMenu) {
                if (input.equalsIgnoreCase("help"))
                    Menu.help();
                else if (input.equalsIgnoreCase("Change")) {
                    //*****************************************************//
                }
            }

            if (Menu.menuHandler.getCurrentMenu() == Menu.playMenu) {
                if (input.equalsIgnoreCase("help"))
                    Menu.help();

                else if (input.equalsIgnoreCase("day")) {

                    //new kardan game mode
                } else if (input.equalsIgnoreCase("water")) {

                    //hmon
                } else if (input.equalsIgnoreCase("rail")) {
                    /////
                } else if (input.equalsIgnoreCase("zombie")) {
                    ////
                } else if (input.equalsIgnoreCase("pvp")) {
                    ////
                } else if (input.equalsIgnoreCase("exit")) {
                    Menu.menuHandler.setCurrentMenu(Menu.mainMenu);
                } else
                    System.out.println("invalid command");
            }
            if (Menu.menuHandler.getCurrentMenu() == Menu.collectionMenu) {

            }
        }
    }
}
