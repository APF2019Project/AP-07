package Controller.Menus;

public class MainMenu extends Menu {

    public MainMenu(){
        parentMenu =null;
    }

    public void Play(){

    }

    public void Profile(){
        ProfileMenu profileMenu=new ProfileMenu();
        currentMenu=profileMenu;
    }

    public void Shop(){
        ShopMenu shopMenu=new ShopMenu();
        currentMenu=shopMenu;
    }
}
