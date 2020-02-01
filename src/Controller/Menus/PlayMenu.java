package Controller.Menus;

import Controller.GameMode.*;
import Model.Card.ActionsOfAnEvent;
import Model.Player.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Platform.exit;

public class PlayMenu extends Menu implements Initializable {


    public PlayMenu() throws IOException {
        this.orders = new String[]{"Day", "Water", "Rail", "ZombieGameMode", "PvP"};
    }

    public void startDayGame(Player player1, Player player2) {
        Day day = new Day();
        Battle battle = new Battle(player1, player2, day);
        Menu.menuHandler.setCurrentMenu(Menu.collectionMenu);
    }

    public void startWaterGame(Player player1, Player player2) {
        Water water = new Water();
        Battle battle = new Battle(player1, player2, water);
        Menu.menuHandler.setCurrentMenu(Menu.collectionMenu);
    }

    public void startRailGame(Player player1, Player player2) {
        Rail rail = new Rail();
        Battle battle = new Battle(player1, player2, rail);
        Menu.menuHandler.setCurrentMenu(Menu.railMenu);
        Menu.railMenu.player1 = player1;
        Menu.railMenu.player2 = player2;
        Menu.railMenu.rail = rail;
        Menu.railMenu.battle = battle;
    }

    public void startZombieGame(Player player1, Player player2) {
        ZombieGameMode zombieGameMode = new ZombieGameMode();
        Battle battle = new Battle(player1, player2, zombieGameMode);
        Menu.menuHandler.setCurrentMenu(Menu.collectionMenu);
    }

    public void jhajCJUK() {
        Menu.menuHandler.setCurrentMenu(Menu.mainMenu);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //exiit.setOnAction(ActionsOfAnEvent -> exit());
    }
}
