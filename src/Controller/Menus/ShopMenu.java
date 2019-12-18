package Controller.Menus;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Player.Player;
import Model.Shop.Shop;

public class ShopMenu extends Menu {

    public void getCollection(Player player) {
        for (Plant x : player.getPlayerPlants())
            System.out.println(x.getName());
        for (Zombie x : player.getPlayerZombies())
            System.out.println(x.getName());
    }

    public void buy(String name) {
        //kharide cart
//        shop.buy()
    }

    public void Money(Player player) {
        //asami tavabe bayad fe'l bashand
        //namayeshe tedad sekke haye bazikon
    }
}
