package Controller.Menus;

import Model.Player.Player;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Player.Profile;
import Model.Shop.Collection;

import java.util.ArrayList;

public class CollectionMenu extends Menu {

    public CollectionMenu() {
        this.orders = new String[]{"Show hand", "Show collection", "Select", "Remove", "Play", "Help", "Exit"};
    }

    private Collection collection = new Collection();

    public void showHand() {
        // in bayad bar asas gamemode chap kone

        ArrayList<Plant> p = this.collection.getPlants();
        ArrayList<Zombie> z = this.collection.getZombies();
        if (p != null) {
            for (Plant x : p) {
                System.out.println(x.getName());
            }
        }
        else {
            for (Zombie x : z)
                System.out.println(x.getName());
        }
    }

    public void showCollection(Profile profile) {
        for (Plant p : profile.getPurchasedPlants()) {
            if (!collection.getPlants().contains(p))
                System.out.println(p.getName());
        }

        ///baraie halate zombie
        for (Zombie z : profile.getPurchasedZombies()) {
            if (!collection.getZombies().contains(z))
                System.out.println(z.getName());
        }
    }


    public void selectCollection(String name, Profile profile) {
        Zombie z = Zombie.findZombie(name);
        if (profile.getPurchasedZombies().contains(z) && !collection.getZombies().contains(z))
            collection.addZombie(z);

        Plant p = Plant.findPlant(name);
        if(profile.getPurchasedPlants().contains(p) && !collection.getPlants().contains(p))
            collection.addPlant(p);

        //bishtar az 7 ta ro hm bayad check konim
    }

    public void removeCard (String name) {
        collection.removeZombie(name);
        collection.removePlant(name);
    }

    public void play(Player player) {
        //marhaleye baad
        player.setCollection(collection);
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public void exit() {
        Menu.menuHandler.setCurrentMenu(Menu.playMenu);
    }
}
