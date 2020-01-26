package View;

import Controller.Menus.Menu;
import Controller.Menus.MenuHandler;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

import static javafx.application.Platform.exit;


public class Main extends Application {
    public final static int sceneHeight = 800;
    public final static int sceneWitdh = 800;

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Group root = new Group();
//        Scene scene = new Scene(root, sceneWitdh, sceneWitdh);
//        Image image = new Image(new FileInputStream("C:\\Users\\asus\\IdeaProjects\\AP-07\\AP-07-1\\src\\Images\\LoginMenu.png"));
//        ImageView imageView1 = new ImageView(image);
//        imageView1.setX(0);
//        imageView1.setY(0);
//        imageView1.setFitHeight(sceneHeight);
//        imageView1.setFitWidth(sceneWitdh);
//        root.getChildren().add(imageView1);
//
//        Button quitButton = new Button();
//        root.getChildren().add(quitButton);
//        quitButton.relocate(720, 680);
//        quitButton.setMinHeight(50);
//        quitButton.setMinWidth(50);
//        quitButton.setOpacity(0);
//        quitButton.setOnMouseClicked(event -> {
//            exit();
//        });
//
//        Button helpButton = new Button();
//        root.getChildren().add(helpButton);
//        helpButton.relocate(650, 680);
//        helpButton.setMinHeight(50);
//        helpButton.setMinWidth(50);
//        helpButton.setOpacity(0);
//        helpButton.setOnMouseClicked(event -> {
//
//        });
//
//        primaryStage.setScene(scene);
//        primaryStage.show();

        MenuHandler menuHandler=new MenuHandler();
        menuHandler.run();

    }

    public ImageView setBackGroundImage(FileInputStream fileInputStream) {
        Image image = new Image(fileInputStream);
        ImageView imageView = new ImageView(image);
        imageView.setX(0);
        imageView.setY(0);
        imageView.setFitHeight(sceneHeight);
        imageView.setFitWidth(sceneWitdh);
        return imageView;
    }
}
