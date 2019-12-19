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
    private Player[] player;
    private Map map;
    private ArrayList<Zombie> zombies;

    public Battle(Player player1, Player player2) {
        this.player[0] = player1;
        this.player[1] = player2;
    }

    public void init(){
        this.map=gameMode.generateMap();
    }

    public void PlayTurn() {
        gameMode.checkState();
    }

    public void plant(Plant plant, Cell cell) {
        //this.map.getCell(cell).plant(plant);
    }

    public void dig(Cell cell) {

    }

    public void setWaveZombies(ArrayList<Zombie> zombies) {

    }

    public Player getPlayer(int i) {
        return player[i];
    }

    public void setPlayer(Player player, int i) {
        this.player[i] = player;
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
