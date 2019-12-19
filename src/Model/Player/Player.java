package Model.Player;

import Model.Card.Card;
import Model.Card.Plants.Plant;
import Model.Shop.Collection;
import Model.Card.Zombies.Zombie;
import java.util.ArrayList;

public class Player {
    //data haye dar hale bazi ee
    private ArrayList<Plant> PlayerPlants;
    private ArrayList<Zombie> PlayerZombies;
    //collection carta ee ast ke player ba khod be bazi mibarad
    private Collection collection;
    private int externalCoins;
    private int internalCoins;

    public void addToCollection(Card card)
    {
        for(int i=0; i<card.getPlants().size();i++){
            if(card.getPlants().get(i).getName().equals(card.getName())){
                this.collection.addPlant((Plant)card);
                break;
            }
        }
        for(int i=0; i<card.getZombies().size();i++){
            if(card.getZombies().get(i).getName().equals(card.getName())){
                this.collection.addZombie((Zombie)card);
                break;
            }
        }
    }

    public ArrayList<Plant> getPlayerPlants() {
        return PlayerPlants;
    }

    public void addPlayerPlants(Plant plant) {
        PlayerPlants.add(plant);
    }

    public ArrayList<Zombie> getPlayerZombies() {
        return PlayerZombies;
    }

    public void addPlayerZombies(Zombie zombie) {
        PlayerZombies.add(zombie);
    }

    public int getExternalCoins() {
        return externalCoins;
    }

    public void setExternalCoins(int externalCoins) {
        this.externalCoins += externalCoins;
    }

    public int getInternalCoins() {
        return internalCoins;
    }

    public void setInternalCoins(int internalCoins) {
        this.internalCoins += internalCoins;
    }

    public Collection getCollection() {
        return collection;
    }
}
