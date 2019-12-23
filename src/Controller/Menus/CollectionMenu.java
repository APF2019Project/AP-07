package Controller.Menus;

import Model.Player.Player;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Player.Profile;

import java.util.ArrayList;

public class CollectionMenu extends Menu {

    public CollectionMenu() {
        this.orders = new String[]{"Show hand", "Show collection", "Select", "Remove", "Play", "Help", "Exit"};
    }

    public void showHand(Profile profile) {
        // in bayad bar asas game_mode chap kone

        ArrayList<Plant> plants = profile.getPurchasedPlants();
        ArrayList<Zombie> zombies = profile.getPurchasedZombies();

        if (plants != null) {
            for (Plant x : plants) {
                System.out.println(x.getName());
            }
        } else {
            for (Zombie x : zombies)
                System.out.println(x.getName());
        }
    }

    public void showCollection(Profile profile) {
        for (Plant p : profile.getPurchasedPlants()) {
            if (!profile.getPurchasedPlants().contains(p))
                System.out.println(p.getName());
        }

        ///baraie halate zombie
        for (Zombie z : profile.getPurchasedZombies()) {
            if (!profile.getPurchasedZombies().contains(z))
                System.out.println(z.getName());
        }
    }


    public void selectCollection(String name, Profile profile) {
        Zombie z = Zombie.findZombie(name);
        if (profile.getPurchasedZombies().contains(z) && !profile.getPurchasedZombies().contains(z))
            profile.addToPurchasedZombies(z);

        Plant p = Plant.findPlant(name);
        if(profile.getPurchasedPlants().contains(p) && !profile.getPurchasedPlants().contains(p))
            profile.addToPurchasedPlants(p);

        //bishtar az 7 ta ro hm bayad check konim
    }

    public void removeCard (String name,Profile profile) {
        profile.getCollection().
        collection.removePlant(name);
    }

    public void play(Player player) {
        //marhaleye baad
        player.setCollection();
    }

    public void exit() {
        Menu.menuHandler.setCurrentMenu(Menu.playMenu);
    }
}
