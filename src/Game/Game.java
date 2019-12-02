package Game;

import Menus.Menu;
import Player.Player;

public class Game {
    private int waveCounter=0;
    private int turn;
    private Menu menu;
    private Player player;
    private boolean isOver=false;

    public Player getPlayer() {
        return player;
    }

    public int getWaveCounter() {
        return waveCounter;
    }

    public int isTurn() {
        return turn;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setPlayer(Player player){

    }

    public void PlayTurn(boolean turn){

    }

    public boolean IsOver(){
        return isOver;
    }

    public void checkIsOver(){
        //baste be type e har bazi dar har classe farzand overwrite mishe
    }

    public void showWinner(){
        if(isOver){

        }
    }

    public void changeTurn(){

    }

    public void gotoMenu(){

    }

    public void checkTypeOfGame(){
        //booleane morede nazar ra dar nazar gerefte va methode dorosto farakhani mikone
        //az oon type game new mikone
    }

}
