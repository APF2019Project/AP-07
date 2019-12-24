package Controller.Menus;

import Controller.GameMode.Day;
import Controller.GameMode.Rail;
import Controller.GameMode.Water;
import Model.Card.Plants.Plant;
import Model.Map.UnknownCell;
import Model.Player.Player;
import Model.Player.Profile;
import com.gilecode.yagson.YaGson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuHandler {
    private Menu currentMenu;

    public Day dayMode = null;
    public Rail railMode = null;
    public Water waterMode = null;

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public void run() throws IOException {

        YaGson yaGson = new YaGson();
        File file = new File("C:\\Users\\asus\\IdeaProjects\\untitled6\\Plants\\Cactus");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String string = new String();
        while (true) {
            String s=br.readLine();
            if(!s.equals(null)){
                string+=s;
            }
        }
        UnknownCell unknownCell=new UnknownCell();
        Plant plant=new Plant("Cactus",1,3,unknownCell,5,4);
//        Plant plant1 = yaGson.fromJson(string, Plant.class);
        String s = yaGson.toJson(plant);
        System.out.println("0 = " + s);
        System.out.println("1 = " + string);
        yaGson.fromJson(s,Plant.class);
//        System.out.println(s);
//        System.out.println(plant1.getCooldown());
//        System.out.println(plant1.getCooldown());

        Player bot = new Player();
        Profile profile = null;
        Scanner scanner = new Scanner(System.in);
        Player player = null;

        Pattern selectCard = Pattern.compile("select \\w*");
        Pattern removeCard = Pattern.compile("remove \\w*");
        Pattern buyCard = Pattern.compile("buy \\w*");
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

            //profileMenu//

            if (Menu.menuHandler.getCurrentMenu() == Menu.profileMenu) {
                if (input.equalsIgnoreCase("help"))
                    Menu.help();
                else if (input.equalsIgnoreCase("Change")) {
                    String username = scanner.nextLine();
                    String password = scanner.nextLine();
                    profile.change_username(username);
                    profile.change_Password(password);
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
                } else
                    System.out.println("invalid command");
            }

            //playMenu//

            if (Menu.menuHandler.getCurrentMenu() == Menu.playMenu) {
                if (input.equalsIgnoreCase("help"))
                    Menu.help();

                else if (input.equalsIgnoreCase("day")) {
                    Menu.playMenu.startDayGame(player, bot);
                    dayMode = new Day();
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

            //cpllectionMenu//

            if (Menu.menuHandler.getCurrentMenu() == Menu.collectionMenu) {
                if (input.equalsIgnoreCase("Show hand")) {
                    Menu.collectionMenu.showHand();
                } else if (input.equalsIgnoreCase("Show collection")) {
                    Menu.collectionMenu.showCollection(profile);
                } else if (selectCard.matcher(input).matches()) {
                    Menu.collectionMenu.selectCollection(splitInput[1], profile);
                } else if (input.equalsIgnoreCase("Play")) {
                    Menu.collectionMenu.play(player);
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

            if (Menu.menuHandler.getCurrentMenu() == Menu.shopMenu) {
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
            if (Menu.menuHandler.getCurrentMenu() == null)
                break;
        }

    }
}

