package View;

import Controller.Menus.LoginMenu;
import Controller.Menus.MenuHandler;

import java.util.Scanner;

public class Main {
   public static void main(String[] args){
      LoginMenu loginMenu=new LoginMenu();
      Scanner scanner=new Scanner(System.in);
      String username=scanner.nextLine();
      String password=scanner.nextLine();
      loginMenu.createAccount(username,password);
      //preprocess();
      while(true){
         //battleMenu.nextTurn();
         //scanner.nextLine();

      }
   }
}
