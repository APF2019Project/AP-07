package Model.Card.Plants.PlantsActions;
import Model.Card.Plants.Plant;
import Model.Player.Player;

public class ProduceSun extends PlantsAction {
    public void giveSun(Player player,Plant plant,int suns){
        if(player.getPlants().contains(plant)){
            player.setSun(suns);
            plant.setTurn(plant.getTurn());
        }
    }
}
