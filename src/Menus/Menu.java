package Menus;

public class Menu {

    private String command;
    private boolean commandValidity;
    private Menu currentMenu;

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public String getCommand() {
        return command;
    }

    public void help(){
        //namayeshe tamame dastoorate menu
    }

    public void exit(){
        //bazgasht be safheye qabl
    }

    public void checkCommandValidity(String command){

    }

}
