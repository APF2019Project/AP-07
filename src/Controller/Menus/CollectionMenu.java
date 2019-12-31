package Controller.Menus;

import Model.Player.Player;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Player.Profile;
import Model.Shop.Collection;

import java.util.ArrayList;

public class CollectionMenu extends Menu {
    public boolean zombieMode;
    public boolean pvp;

    public CollectionMenu() {
        this.orders = new String[]{"Show hand", "Show collection", "Select", "Remove", "Play", "Help", "Exit"};
        this.pvp = false;
    }

    private Collection collection = new Collection();

    public void showHand() {
        // in bayad bar asas gamemode chap kone

        ArrayList<Plant> p = this.collection.getPlants();
        ArrayList<Zombie> z = this.collection.getZombies();
        if (!zombieMode) {
            for (Plant x : p) {
                System.out.println(x.getName());
            }
        } else {
            for (Zombie x : z)
                System.out.println(x.getName());
        }
    }

    public void showCollection(Profile profile) {
        if (!zombieMode) {
            for (Plant p : profile.getPurchasedPlants()) {
                if (!collection.getPlants().contains(p))
                    System.out.println(p.getName());
            }
        }

        ///baraie halate zombie
        else {
            for (Zombie z : profile.getPurchasedZombies()) {
                if (!collection.getZombies().contains(z))
                    System.out.println(z.getName());
            }
        }
    }


    public void selectCollection(String name, Profile profile) {
        if (zombieMode) {
            Zombie z = Zombie.findZombie(name);
            if (collection.getZombies().size() == 7)
                System.out.println("your collection is full");
            else if (profile.getPurchasedZombies().contains(z) && !collection.getZombies().contains(z))
                collection.addZombie(z);
        } else {
            Plant p = Plant.findPlant(name);
            if (collection.getPlants().size() == 7)
                System.out.println("your collection is full");
            else if (profile.getPurchasedPlants().contains(p) && !collection.getPlants().contains(p))
                collection.addPlant(p);
        }

    }

    public void removeCard(String name) {
        collection.removeZombie(name);
        collection.removePlant(name);
    }

    public void play(Player player, Player player2) {
        if (player.getPlants() != null && player.getZombies() != null) {
            player.setCollection(collection);
            if (!pvp)
                Menu.menuHandler.setCurrentMenu(gameMenu);
        } else {
            player2.setCollection(collection);
            menuHandler.setCurrentMenu(gameMenu);
        }

    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public void exit() {
        Menu.menuHandler.setCurrentMenu(Menu.playMenu);
    }
}
