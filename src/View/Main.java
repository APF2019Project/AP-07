package View;

import Controller.Menus.LoginMenu;
import Model.Player.Player;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LoginMenu loginMenu = new LoginMenu();
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        loginMenu.createAccount(username, password);
        //String order=scanner.nextLine();
        //preprocess();
        while (true) {
            //battleMenu.nextTurn();
            //scanner.nextLine();



        }
    }
}
