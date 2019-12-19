package Controller.Menus;

import java.util.ArrayList;

public class Menu {
    public static LoginMenu loginMenu = new LoginMenu();
    public static CollectionMenu collectionMenu = new CollectionMenu();
    public static GameMenu gameMenu = new GameMenu();
    public static LeaderBoard leaderBoard = new LeaderBoard();
    public static MainMenu mainMenu = new MainMenu();
    public static ProfileMenu profileMenu = new ProfileMenu();
    public static ShopMenu shopMenu = new ShopMenu();
    public static MenuHandler menuHandler = new MenuHandler();
    //Account account = new Account()
    Menu parentMenu =null;
    Menu currentMenu=null;
    ArrayList<String> orders=new ArrayList<>();

    public Menu(){
        currentMenu=this;
    }

    //namayeshe tamame dastoorate menu
    public void help(){
        for(int i=0;i<orders.size();i++){
            System.out.println(orders.get(i));
        }
    }

    public void init(){
        //enter
        // kar haye avaliye mesl set kardan e account o ina
    }

    public void exit(){
        currentMenu=parentMenu;
        //bazgasht be safheye qabl
    }

    public void enter(Menu menu){
        //inito seda kon
        currentMenu=this;
    }
}
