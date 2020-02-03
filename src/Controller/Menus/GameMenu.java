package Controller.Menus;

import Controller.GameMode.Battle;
import Controller.GameMode.Day;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Player;
import Model.Player.Profile;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import Model.Shop.Collection;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.util.ArrayList;


public class GameMenu extends Menu implements Initializable {

    public Day day = new Day();

    public Player player1;
    public Player player2;

    public Battle battle = new Battle(player1, player2, day);

//    public ImageView imageView;
    public Label sunL;
    public static ArrayList<ImageView> plantsImages = new ArrayList<>();

    public void showHand() {
        for (Plant x : player1.getPlants()) {
            System.out.println(x.getName() + "\t" + x.getSun() + "\t" + x.getCooldown());
        }
    }

    public void remove(int x, int y) {
        Map map = battle.getMap();
        Cell cell = map.getCell(x, y);
        cell.removePlant();
    }

    public void plant(String name, int x, int y) throws IOException {
        Plant p1 = Plant.makePlant(name);
        if (battle.getMap().getCell(x, y).canBePlanted()) {
            for (Plant p : player1.getPlants()) {
                if (p.getName().equalsIgnoreCase(name)) {
                    if (p.getLoading() == 0 && p.getSun() <= player1.getSun()) {
                        if (!name.equalsIgnoreCase("lilypad") && !name.equalsIgnoreCase("tanglekelp") && !name.equalsIgnoreCase("cattail") ){
                        battle.getMap().getCell(x, y).setPlant(p1);
                        p1.setCell(battle.getMap().getCell(x, y));
                        p.setLoading(p.getCooldown());
                        System.out.println("plant planted:)");
                        player1.setSun(player1.getSun() - p.getSun());
                    }
                } else {
                    System.out.println("plant is not ready");
                }

                break;
            }
        }
    }

}

    public void endTurn(Profile profile) throws IOException {

        if (battle.getGameMode() instanceof Day) {
            day.wave(battle);
            day.setLastTurnGivingSuns(1);
            battle.actAllMembers();
            day.generateSun(battle);
            if (!day.handleWin(profile, battle)) {
                //Menu.menuHandler.setCurrentMenu(Menu.mainMenu);
            }
            day.setLastTurnWaved(1);
            day.updateCollection(battle);
            battle.setCurrentTurn(1);
        }


//        for (Plant p:player1.getPlants()) {
//            if (p.getLoading()!=0) {
//                p.setLoading(p.getLoading()-1);
//            }
//        }
////        System.out.println(player1.getSun());
        System.out.println(battle.getCurrentTurn());
    }


    public void showLawn() {
        System.out.println("Zombies And Plants");
        for (Cell[] cells : battle.getMap().getCells()) {
            for (Cell cell : cells) {
                if (cell.getZombies().size() != 0) {
                    for (Zombie z : cell.getZombies()) {
                        System.out.println(z.getName() + "\t" + cell.x() + "," + cell.y() + "\t" + z.getHP() + z.showIronHat());
                    }
                }
                if (cell.getPlant() != null) {
                    Plant z = cell.getPlant();
                    System.out.println(z.getName() + "\t" + cell.x() + "," + cell.y() + "\t" + z.getHP());
                }
            }
        }
        System.out.println("Map");
        int p;
        for (Cell[] cells : battle.getMap().getCells()) {
            System.out.println(cells[0].x() + "\t");
            for (Cell cell : cells) {
                if (cell.getPlant() != null)
                    p = 1;
                else p = 0;
                System.out.print(cell.getZombies().size() + "" + p + "" + cell.getPeas().size() + "\t");
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sunL.setText("sun");

//        System.out.println("before"+GameMenu.plantsImages.size());
        plantsImages.addAll(CollectionMenu.imageViews);
//        System.out.println("after"+GameMenu.plantsImages.size());
        for (ImageView x : plantsImages) {
//            System.out.println("number");
            x.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    System.out.println("sjveuagf");
                }
            });
        }
    }
}
