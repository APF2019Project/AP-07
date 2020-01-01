package Controller.Menus;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Player.Player;
import Model.Player.Profile;
import Model.Shop.Shop;

import java.util.ArrayList;

public class ShopMenu extends Menu {

    public ShopMenu() {
        this.orders = new String[]{"Show shop", "Show collection", "Buy", "Money", "Help", "Exit"};
    }

    public void showShop(Profile profile) {
        ArrayList<Plant> plants = Plant.getPlants();
        System.out.println("Plants");
        System.out.println("----------------------");
        for (Plant x : plants)
            if (!profile.getPurchasedPlants().contains(x))
                System.out.println(x.getName() + "\t" + x.getCoin());
        System.out.println("----------------------");
        System.out.println("Zombies");
        System.out.println("----------------------");
        for (Zombie x : Zombie.getZombies())
            if (!profile.getPurchasedZombies().contains(x))
                System.out.println(x.getName() + "\t" + x.getCoin());
        System.out.println("----------------------");
    }

    public void getCards(Profile profile) {
        for (Plant x : profile.getPurchasedPlants())
            System.out.println(x.getName());
        for (Zombie x : profile.getPurchasedZombies())
            System.out.println(x.getName());
    }

    public void buy(String name, Profile profile) {
        Zombie z = Zombie.findZombie(name);
        Plant p = Plant.findPlant(name);
        if (z != null && z.getCoin() <= profile.getExternalCoins())
            profile.addZombie(z);
        if (p != null && p.getCoin() <= profile.getExternalCoins())
            profile.addPlant(p);
    }

    public void exit() {
        Menu.menuHandler.setCurrentMenu(Menu.mainMenu);
    }

    public void showMoney(Profile profile) {
        System.out.println(profile.getExternalCoins());
    }
}
