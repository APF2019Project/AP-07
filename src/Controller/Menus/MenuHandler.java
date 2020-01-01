package Controller.Menus;

import Controller.GameMode.Day;
import Controller.GameMode.Rail;
import Controller.GameMode.Water;
import Controller.GameMode.ZombieGameMode;
import Model.Card.Plants.Plant;
import Model.Player.Player;
import Model.Player.Profile;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuHandler {
    private Menu currentMenu;

    public Day dayMode = null;
    public Rail railMode = null;
    public Water waterMode = null;
    public ZombieGameMode zombieMode = null;

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public void run() throws IOException {


        Player bot = new Player();
        Profile profile = null;
        Scanner scanner = new Scanner(System.in);
        Player player = null;
        Player player2 = null;
        Pattern selectCard = Pattern.compile("select \\w*");
        Pattern removeCard = Pattern.compile("remove \\w*");
        Pattern buyCard = Pattern.compile("buy \\w*");
        Pattern plantPlant = Pattern.compile("select \\w*");
        Pattern removePlant = Pattern.compile("remove \\d* \\d*");
        Menu.init();
        while (true) {
            String input = scanner.nextLine();
            String[] splitInput = input.split(" ");

            //loginMenu//
            //leaderboard//

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
                } else {
                    System.out.println("invalid command");
                }
            }

            //mainMenu//

            else if (Menu.menuHandler.getCurrentMenu() == Menu.mainMenu) {
                if (input.equalsIgnoreCase("play"))
                    Menu.menuHandler.setCurrentMenu(Menu.playMenu);
                else if (input.equalsIgnoreCase("Profiles"))
                    Menu.menuHandler.setCurrentMenu(Menu.profileMenu);
                else if (input.equalsIgnoreCase("Shop"))
                    Menu.menuHandler.setCurrentMenu(Menu.shopMenu);
                else if (input.equalsIgnoreCase("Exit"))
                    Menu.mainMenu.exit();
                else if (input.equalsIgnoreCase("help"))
                    Menu.help();
                else
                    System.out.println("invalid command");
            }

            //profileMenu//

            else if (Menu.menuHandler.getCurrentMenu() == Menu.profileMenu) {
                if (input.equalsIgnoreCase("help"))
                    Menu.help();
                else if (input.equalsIgnoreCase("Change")) {
                    String username = scanner.nextLine();
                    String password = scanner.nextLine();
                    Profile p = Profile.login(username, password);
                    if (p == null)
                        System.out.println("invalid account");
                    else {
                        profile = p;
                    }
                } else if (input.equalsIgnoreCase("rename")) {
                    String username = scanner.nextLine();
                    profile.change_username(username);
                } else if (input.equalsIgnoreCase("create")) {
                    String username = scanner.nextLine();
                    String password = scanner.nextLine();
                    Profile.addAccount(new Profile(username, password));
                } else if (input.equalsIgnoreCase("delete")) {
                    String username = scanner.nextLine();
                    String password = scanner.nextLine();
                    profile.delete_account(username, password);
                    profile = null;
                    Menu.menuHandler.setCurrentMenu(Menu.loginMenu);
                } else if (input.equalsIgnoreCase("exit")) {
                    Menu.profileMenu.exit();
                } else if (input.equalsIgnoreCase("show")) {
                    System.out.println(profile.getUsername());
                } else
                    System.out.println("invalid command");
            }

            //playMenu//

            else if (Menu.menuHandler.getCurrentMenu() == Menu.playMenu) {
                if (input.equalsIgnoreCase("help"))
                    Menu.help();

                else if (input.equalsIgnoreCase("day")) {
                    player = new Player();
                    Menu.playMenu.startDayGame(player, bot);
                    dayMode = new Day();
                    Menu.gameMenu.battle.setMap(dayMode.generateMap());
                    Menu.collectionMenu.zombieMode = false;
                } else if (input.equalsIgnoreCase("water")) {
                    player = new Player();
                    Menu.playMenu.startWaterGame(player, bot);
                    waterMode = new Water();
                    Menu.collectionMenu.zombieMode = false;
                } else if (input.equalsIgnoreCase("rail")) {
                    player = new Player();
                    Menu.playMenu.startRailGame(player, bot);
                    railMode = new Rail();
                    Menu.collectionMenu.zombieMode = false;
                } else if (input.equalsIgnoreCase("zombie")) {
                    player = new Player();
                    Menu.playMenu.startZombieGame(player, bot);
                    zombieMode = new ZombieGameMode();
                    Menu.collectionMenu.zombieMode = true;
                } else if (input.equalsIgnoreCase("pvp")) {
                    player = new Player();
                    player2 = new Player();
                    Menu.playMenu.startDayGame(player, player2);
                    dayMode = new Day();
                    Menu.collectionMenu.pvp = true;
                } else if (input.equalsIgnoreCase("exit")) {
                    Menu.playMenu.exit();
                } else
                    System.out.println("invalid command");
            }

            //collectionMenu//

            else if (Menu.menuHandler.getCurrentMenu() == Menu.collectionMenu) {
                if (input.equalsIgnoreCase("Show hand")) {
                    Menu.collectionMenu.showHand();
                } else if (input.equalsIgnoreCase("Show collection")) {
                    Menu.collectionMenu.showCollection(profile);
                } else if (selectCard.matcher(input).matches()) {
                    Menu.collectionMenu.selectCollection(splitInput[1], profile);
                } else if (input.equalsIgnoreCase("Play")) {
                    Menu.collectionMenu.play(player, bot);
                } else if (input.equalsIgnoreCase("help")) {
                    Menu.help();
                } else if (input.equalsIgnoreCase("Exit")) {
                    Menu.collectionMenu.exit();
                } else if (removeCard.matcher(input).matches()) {
                    Menu.collectionMenu.removeCard(splitInput[1]);
                } else
                    System.out.println("invalid command");
            }

            //shopMenu//

            else if (Menu.menuHandler.getCurrentMenu() == Menu.shopMenu) {
                if (input.equalsIgnoreCase("show shop")) {
                    Menu.shopMenu.showShop(profile);
                } else if (input.equalsIgnoreCase("show collection")) {
                    Menu.shopMenu.getCards(profile);
                } else if (input.equalsIgnoreCase("Money")) {
                    Menu.shopMenu.showMoney(profile);
                } else if (input.equalsIgnoreCase("Help")) {
                    Menu.help();
                } else if (input.equalsIgnoreCase("Exit")) {
                    Menu.shopMenu.exit();
                } else if (buyCard.matcher(input).matches()) {
                    Menu.shopMenu.buy(splitInput[1], profile);
                } else
                    System.out.println("invalid command");
            }

            //gameMenu//

            else if (Menu.menuHandler.getCurrentMenu() == Menu.gameMenu) {
                if (input.equalsIgnoreCase("show hand")) {
                    Menu.gameMenu.showHand();
                } else if (plantPlant.matcher(input).matches()) {
                    String name = splitInput[1];
                    Plant p = Plant.findPlant(name);
                    String[] planting = scanner.nextLine().split(" ");
                    int x = Integer.parseInt(planting[1]);
                    int y = Integer.parseInt(planting[2]);
                    /////clone the plant
                } else if (removePlant.matcher(input).matches()) {
                    int x = Integer.parseInt(splitInput[1]);
                    int y = Integer.parseInt(splitInput[2]);
                    Menu.gameMenu.remove(x, y);
                } else if (input.equalsIgnoreCase("End Turn")) {
                    Menu.gameMenu.endTurn();
                } else if (input.equalsIgnoreCase("show lawn")) {
                    Menu.gameMenu.showLawn();
                } else
                    System.out.println("invalid command");
            }

            else if (Menu.menuHandler.getCurrentMenu() == null)
                break;
        }

    }
}

