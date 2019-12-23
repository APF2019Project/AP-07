package Controller.GameMode;

import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Card.Plants.Plant;
import Model.Player.Player;

import java.util.ArrayList;


public class Battle {

    GameMode gameMode;
    private int waveCounter = 0;
    private int turn = 0;
    private Player player1;
    private Player player2;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    private Map map;
    private ArrayList<Zombie> zombies;

    public Battle(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void init(){
        this.map=gameMode.generateMap();
    }

    public void PlayTurn() {
        gameMode.checkState();
    }

    public void plant(Plant plant, Cell cell) {
        cell.plant(plant);
    }

    public void dig(Cell cell) {

    }

    public void setWaveZombies(ArrayList<Zombie> zombies) {

    }

    public Player getPlayer(int i) {
        if(i ==1)
            return player1;
        if (i==2)
            return player2;
        return null;
    }

    public void setPlayer(Player player, int i) {
        if(i ==1)
            player1 = player;
        if (i==2)
            player2 = player;
    }

    public int getWaveCounter() {
        return waveCounter;
    }

    public int getTurn() {
        return turn;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

}
