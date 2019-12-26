package Model.Card.Plants.PlantsActions;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Map.Map;

public class ProduceSun extends Action {
    @Override
    public void doAction(Plant plant, Map map, int d) {

        for(int i=0;i<map.getUnknownCells().length;i++){
            if(map.getUnknownCells(plant.getCell().x,plant.getCell().y))
        }
        if(player.getPlants().contains(plant)){
            player.setSun(suns);
            plant.setTurn(plant.getTurn());
        }
    }
}
