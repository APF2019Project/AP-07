package Model.Card.Zombies.ZombiesActions;

import Controller.GameMode.Battle;
import Controller.Menus.Menu;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static Controller.Menus.Menu.primaryStage;
import static javafx.fxml.FXMLLoader.load;

public class Walk extends Action {


    @Override
    public void doAction(Plant plant, Battle battle, int d, Pane root) {

    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d, Pane root) throws IOException {
        int i = 0;
        int x = zombie.getCell().x();
        int y = zombie.getCell().y();
        while (i < zombie.getSpeed()) {
            System.err.println("in while");
            if ((y > 0 && battle.getMap().getCell(x, y - 1).getPlant() == null)) {
                y--;
            }
            if (y > 0 && battle.getMap().getCell(x, y - 1).getPlant() != null && zombie.getActionsOfAnEvent().contains(new StealPlant())) {
                y--;
                battle.getMap().getCell(x, y).getPlant().setHealthPoint(0);
            }
            i++;
        }
        zombie.setCell(battle.getMap().getCell(x, y));
        battle.getMap().getCell(x, y).getZombies().add(zombie);

//        Image image = new Image(new FileInputStream("src/GameGifs/FootballZombie.gif"));
//        ImageView imageView = new ImageView(image);
//        root.getChildren().add(imageView);
//        Path path = new Path(new MoveTo(200, 100), new LineTo(100, 100));
////        path.setVisible(false);
//        PathTransition pathTransition = new PathTransition(Duration.millis(80000), path,imageView);
//        root.getChildren().add(path);
//        pathTransition.setAutoReverse(false);
//        pathTransition.play();

        System.err.println("walk graphic");
       // Scene scene = new Scene(root, 800, 800);
       // Menu.primaryStage.setScene(scene);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Image image = null;
                try {
                    image = new Image(new FileInputStream("C:\\Users\\asus\\IdeaProjects\\Test\\src\\sample\\FootballZombie.png"));

                }
                catch (Exception e){}
                ImageView imageView = new ImageView(image);

                System.err.println(root.toString());
                root.getChildren().add(imageView);
                Path path = new Path(new MoveTo(zombie.getCell().y()*50, 100), new LineTo((zombie.getCell().y()+1)*50, 100));
                path.setVisible(false);
                PathTransition pathTransition = new PathTransition(Duration.millis(1000), path,imageView);
                root.getChildren().add(path);
                pathTransition.setAutoReverse(false);
                pathTransition.play();
                Menu.primaryStage.show();
            }
        });
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                root.getChildren().add(path);
//                pathTransition.setAutoReverse(false);
//                pathTransition.play();
//
//                Menu.primaryStage.setScene(new Scene(new Pane(root)));
//                Menu.primaryStage.show();
//            }
//        });
        System.err.println("end while");
    }
}
