package Controller.Menus;

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
    public void setCollection(Collection collection) {
        this.collection = collection;
    }
}
