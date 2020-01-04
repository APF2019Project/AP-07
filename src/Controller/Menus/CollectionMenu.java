package Controller.Menus;

import Model.Card.Plants.Plant;
import Model.Player.Player;
import Model.Player.Profile;
import Model.Shop.Collection;

import java.util.ArrayList;

public class CollectionMenu extends Menu {
    public boolean zombieMode;
    public boolean pvp = false;
    public boolean water;

    public CollectionMenu() {
        this.orders = new String[]{"Show hand", "Show collection", "Select", "Remove", "Play", "Help", "Exit"};
        this.pvp = false;
    }

    private Collection collection = new Collection();

    public void showHand() {
        // in bayad bar asas gamemode chap kone

        ArrayList<Plant> p = this.collection.getPlants();
        if (!zombieMode) {
            for (Plant x : p) {
                System.out.println(x.getName());

            }
        }
    }

    public void showCollection(Profile profile) {
        if (!zombieMode) {
            for (String p : profile.getPurchasedPlants()) {
                if (!collection.getPlants().contains(p))
                    System.out.println(p);
            }
        }
    }


    public void selectCollection(String name, Profile profile) {

            Plant p = Plant.findPlant(name);
            if (collection.getPlants().size() == 7)
                System.out.println("your collection is full");
            else if (p != null ) {
//                System.out.println("dfvkjvbzjdkfbg");
                if (profile.havePlant(name)) {
//                    System.out.println("2");
                    if (!collection.getPlants().contains(p)){
                        collection.addPlant(p);
//                        System.out.println("3d");
                    }
                }

            }

    }

    public void removeCard(String name) {
        collection.removeZombie(name);
        collection.removePlant(name);
    }

    public void play(Player player, Player player2) {
        if (!pvp) {
            player.setCollection(collection);
            if (!zombieMode) {
                if (water){
                    Menu.menuHandler.setCurrentMenu(Menu.waterModeMenu);
                }
                else {
                    Menu.menuHandler.setCurrentMenu(Menu.gameMenu);
                }
            }
            else {
                Menu.menuHandler.setCurrentMenu(Menu.zombieMenu);
            }
        }
        else {
            if(player.getPlants().size() ==0)
                player.setCollection(collection);
            else {
                player2.setCollection(collection);
                Menu.menuHandler.setCurrentMenu(Menu.pvPMenu);
            }
        }
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public void exit() {
        Menu.menuHandler.setCurrentMenu(Menu.playMenu);
    }
}
