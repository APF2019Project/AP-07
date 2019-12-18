package Controller.Menus;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Player.Player;
import Model.Shop.Shop;

public class ShopMenu extends Menu {

    public void showShop(Player player) {
        for (Plant x : Plant.getPlants())
            if (!player.getPlayerPlants().contains(x))
                System.out.println(x.getName());
        for (Zombie x : Zombie.getZombies())
            if (!player.getPlayerZombies().contains(x))
                System.out.println(x.getName());
    }

    public void getCollection(Player player) {
        for (Plant x : player.getPlayerPlants())
            System.out.println(x.getName());
        for (Zombie x : player.getPlayerZombies())
            System.out.println(x.getName());
    }

    public void buy(String name, Player player) {
        Zombie z = Zombie.findZombie(name);
        Plant p = Plant.findPlant(name);
        if (z != null && z.getCoin() <= player.getExternalCoins())
            player.addPlayerZombies(z);
        if (p != null && p.getCoin() <= player.getExternalCoins())
            player.addPlayerPlants(p);
    }

    public void showMoney(Player player) {
        System.out.println(player.getExternalCoins());
    }
}
