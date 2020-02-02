package Controller.Menus;

import Controller.GameMode.GameMode;
import Model.Card.Plants.Plant;
import Model.Player.Player;
import Model.Player.Profile;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Shop.Collection;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class CollectionMenu extends Menu implements Initializable {
    public boolean zombieMode;
    public boolean pvp = false;
    public boolean water;

    public ImageView sunflower;
    public ImageView peashooter;
    public Button back;
    public Button play;


    public CollectionMenu() {
        this.orders = new String[]{"Show hand", "Show collection", "Select", "Remove", "Play", "Help", "Exit"};
        this.pvp = false;
    }

    private Collection collection = new Collection();

    public void showHand() {
        // in bayad bar asas gamemode chap kone

        ArrayList<Plant> p = this.collection.getPlants();
        if (!zombieMode) {
            for (Plant x : p) {
                System.out.println(x.getName());

            }
        }
    }

    public void showCollection(Profile profile) {
        if (!zombieMode) {
            for (String p : profile.getPurchasedPlants()) {
                if (!collection.getPlants().contains(p))
                    System.out.println(p);
            }
        }
    }


    public void selectCollection(String name, Profile profile) {
        Plant p = Plant.findPlant(name);
        if (collection.getPlants().size() == 7)
            System.out.println("your collection is full");
        else if (p != null) {
//                System.out.println(name);
            if (profile.havePlant(name)) {
//                    System.out.println("2");
                if (!collection.getPlants().contains(p)) {
                    collection.addPlant(p);
//                        System.out.println("3d");
                }
            }
        }
    }

    public void removeCard(String name) {
        collection.removeZombie(name);
        collection.removePlant(name);
    }

    public void play(Player player1, Player player2) throws IOException {
        if (!pvp) {
            player1.setCollection(collection);
            if (!zombieMode) {
                if (water) {
                    Menu.menuHandler.setCurrentMenu(Menu.waterModeMenu);
                    waterModeMenu.player1 = player1;
                    waterModeMenu.player2 = player2;
                    waterModeMenu.battle.setPlayer(player1, 1);
                    waterModeMenu.battle.setPlayer(player2, 2);
                    waterModeMenu.battle.setMap(GameMode.generateMap(waterModeMenu.waterMode));
                    waterModeMenu.player1.setSun(2);
                } else {
                    Menu.menuHandler.setCurrentMenu(Menu.gameMenu);
                    gameMenu.player1 = player1;
                    gameMenu.player2 = player2;
                    gameMenu.battle.setPlayer(player1, 1);
                    gameMenu.battle.setPlayer(player2, 2);
                    gameMenu.battle.setMap(GameMode.generateMap(gameMenu.day));
                    gameMenu.player1.setSun(2);
                }
            } else {
                Menu.menuHandler.setCurrentMenu(Menu.zombieMenu);
                zombieMenu.player2 = player2;
                zombieMenu.player1 = player1;
                zombieMenu.secondStart();
                zombieMenu.battle.setMap(GameMode.generateMap(zombieMenu.zombieGameMode));
            }
        } else {
            if (player1.getPlants().size() == 0)
                player1.setCollection(collection);
            else {
                player2.setCollection(collection);
                Menu.menuHandler.setCurrentMenu(Menu.pvPMenu);
            }
        }
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public void exit() {
        Menu.menuHandler.setCurrentMenu(Menu.playMenu);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sunflower.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("sunflower"));
                }
                catch (Exception e){}


            }
        });
        peashooter.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("peashooter"));
                }
                catch (Exception e){}


            }
        });
        play.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Parent root = (FXMLLoader.load(getClass().getResource("DayModeGround.fxml")));
                    Menu.primaryStage.setScene(new Scene(root));
                    Menu.primaryStage.show();
                    Menu.primaryStage.setTitle("PvZ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for (Plant p :collection.getPlants()){
                    System.out.println(p.getName());
                }
            }
        });
        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Parent root = (FXMLLoader.load(getClass().getResource("PlayMenu.fxml")));
                    Menu.primaryStage.setScene(new Scene(root));
                    Menu.primaryStage.show();
                    Menu.primaryStage.setTitle("PvZ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
