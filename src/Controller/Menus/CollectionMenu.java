package Controller.Menus;
import Model.Player.Player;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Shop.Collection;

import java.util.ArrayList;

public class CollectionMenu extends Menu {
    private Collection collection;
    public void showHand() {
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

    public void showCollection(){
        //liste carthaye entakhab nashode ra mide
    }

    public void selectCollection(String name){

        //card select

    }

    public void removeCollection(String name, Player player){
        //hazfe cart
        for(int i=0;i< player.getCollection().getPlants().size();i++) {
            if(player.getCollection().getPlants().get(i).getName().equals(name)){
                //1 deletion in the loop is ok
                player.getCollection().getPlants().remove(i);
                break;
            }
        }
        for(int i=0;i< player.getCollection().getZombies().size();i++) {
            if(player.getCollection().getZombies().get(i).getName().equals(name)){
                //1 deletion in the loop is ok
                player.getCollection().getZombies().remove(i);
                break;
            }
        }
        Zombie z = Zombie.findZombie(name);
        Plant p = Plant.findPlant(name);
        if (p != null)
            this.collection.addPlant(p);
        if (z != null)
            this.collection.addZombie(z);
    }

    public void removeCollection(String name){
        this.collection.removePlant(name);
        this.collection.removeZombie(name);
    }

    public void play(){
        //marhaleye baad
    }
}
