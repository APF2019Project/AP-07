package Controller.Menus;

import Model.Card.Card;
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
        ArrayList<Plant> plants = Card.getPlants();
        System.out.println("Plants");
        System.out.println("----------------------");
        for (Plant x : plants)
            if (!profile.getPurchasedPlants().contains(x))
                System.out.println(x.getName() + "\t" + x.getPrice());
        System.out.println("----------------------");
        System.out.println("Zombies");
        System.out.println("----------------------");
        for (Zombie x : Card.getZombies())
            if (!profile.getPurchasedZombies().contains(x))
                System.out.println(x.getName() + "\t" + x.getPrice());
        System.out.println("----------------------");
    }

    public void getCards(Profile profile) {
        for (String x : profile.getPurchasedPlants())
            System.out.println(x);
        for (String x : profile.getPurchasedZombies())
            System.out.println(x);
    }

    public void buy(String name, Profile profile) {
        Zombie z = Zombie.findZombie(name);
        Plant p = Plant.findPlant(name);
        if (z != null && !profile.getPurchasedZombies().contains(z.getName())&& z.getPrice() <= profile.getExternalCoins()){
            System.out.println("kharid");
            profile.addZombie(z);
            profile.setExternalCoins(-z.getPrice());
        }
        else if (p != null &&!profile.getPurchasedPlants().contains(p.getName()) && p.getPrice() <= profile.getExternalCoins()){
            System.out.println("kharid");
            profile.setExternalCoins(-p.getPrice());
            profile.addPlant(p);}
        else System.out.println("nakharid");

    }

    public void exit() {
        Menu.menuHandler.setCurrentMenu(Menu.mainMenu);
    }

    public void showMoney(Profile profile) {
        System.out.println(profile.getExternalCoins());
    }
}
