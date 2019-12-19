package Controller.Menus;

import Model.Card.Card;
import Model.Player.Player;

public class CollectionMenu extends Menu {
    //    uses account.getCollection()
    //show nadarim
    // ya get  ya set
    public void showHand() {
        //liste carthaye entakhab shode ra mide
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
    }

    public void play(){
        //marhaleye baad
    }
}
