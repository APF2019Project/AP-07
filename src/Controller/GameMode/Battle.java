package Controller.GameMode;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Player;

import java.util.ArrayList;


public class Battle {

    GameMode gameMode;
    private int currentTurn = 0;
    private int previousTurn;
    private Player player1;
    private Player player2;
    private Map map;
    private ArrayList<Zombie> zombies;
    private Map newMap;

    public Map getNewMap() {
        return newMap;
    }

    public void setNewMap(Map newMap) {
        this.newMap = newMap;
    }

    public Battle(Player player1, Player player2, GameMode gameMode) {
        this.player2 = player2;
        this.player1 = player1;
        this.gameMode = gameMode;
    }

    public void actAllMembers() {

        for (int i = 0; i < Map.getHEIGHT() + 4; i++) {
            for (int j = 0; j < Map.getWIDTH() + 4; j++) {
                if (map.getCell(i, j).getPlant() != null) {
                    //todo
                    System.out.println(map.getCell(i, j).getPlant().getName()+ "///////////////");
                    //map.getCell(i, j).getPlant().act(this);
                }
                //todo
                try{
                    for (Zombie z : map.getCell(i, j).getZombies()) {
                        System.out.println(z.getName() + "/////////////////");
                        z.act(this);
                    }
                }
                catch (Exception e){
                    System.out.println("exeption");
                }

                map.getCell(i, j).setZombies(new ArrayList<Zombie>());
//                System.out.println( "size" + map.getCell(i, j).getZombies().size());
//                //todo
            }
        }
        for (Plant p : this.player1.getPlants()) {
            if (p.getLoading() != 0) {
                p.setLoading(p.getLoading() - 1);
            }
        }

//        for (int i = 0; i < Map.getHEIGHT() + 4; i++) {
//            for (int j = 0; j < Map.getWIDTH() + 4; j++) {
//                map.setCell(i, j, newMap.getCell(i, j));
//            }
//        }
//        newMap = gameMode.generateMap();
    }


    public Player getPlayer(int i) {
        if (i == 1)
            return player1;
        if (i == 2)
            return player2;
        return null;
    }

    public void setPlayer(Player player, int i) {
        if (i == 1)
            player1 = player;
        if (i == 2)
            player2 = player;
    }

    public Battle(Player player1, Player player2, Day day) {
        this.player1 = player1;
        this.player2 = player2;
        this.gameMode = day;
        this.map = day.generateMap();
        this.newMap=day.generateMap();
    }

    public Battle(Player player1, Player player2, String zom) {
        this.player1 = player1;
        this.player2 = player2;
        if (zom.equalsIgnoreCase("zombie"))
            gameMode = new ZombieGameMode();
        map = gameMode.generateMap();
    }

    public void setCurrentTurn(int currentTurn) {
        this.currentTurn += currentTurn;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void init() {
        this.map = gameMode.generateMap();
    }

    public void PlayTurn() {
        gameMode.checkState();
    }

    public void plant(Plant plant, Cell cell) {
        cell.setPlant(plant);
    }

    //bilche
    public void dig(Cell cell) {
        //if player 1 is gardener
        if (player1.getPlants() != null) {
            cell.setPlant(null);
        }
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public int getPreviousTurn() {
        return previousTurn;
    }

    public void setPreviousTurn(int previousTurn) {
        this.previousTurn = previousTurn;
    }


}
