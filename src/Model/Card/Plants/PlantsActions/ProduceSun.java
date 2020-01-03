package Model.Card.Plants.PlantsActions;
import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

public class ProduceSun extends Action {
    @Override
    public void doAction(Plant plant, Battle battle, int d) {
        if (battle.getCurrentTurn()%plant.getTurn() ==0) {
            battle.getPlayer(1).setSun(battle.getPlayer(1).getSun() + plant.getProducedSun());
        }
    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d) {

    }
}
