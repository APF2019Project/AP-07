package View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.FileInputStream;

import static Controller.Menus.Menu.menuHandler;
import static javafx.application.Platform.exit;


public class Main extends Application {
    public final static int sceneHeight = 800;
    public final static int sceneWitdh = 800;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, sceneWitdh, sceneWitdh);
        root.getChildren().add(setBackGroundImage(new FileInputStream("C:\\Users\\asus\\IdeaProjects\\AP-07\\AP-07-1\\src\\Images\\LoginMenu.png")));

        Button quitButton = new Button();
        root.getChildren().add(quitButton);
        quitButton.relocate(720, 680);
        quitButton.setMinHeight(50);
        quitButton.setMinWidth(50);
        quitButton.setOpacity(0);
        quitButton.setOnMouseClicked(event -> {
            exit();
        });

        Button helpButton = new Button();
        root.getChildren().add(helpButton);
        helpButton.relocate(650, 680);
        helpButton.setMinHeight(50);
        helpButton.setMinWidth(50);
        helpButton.setOpacity(0);
        helpButton.setOnMouseClicked(event -> {

        });

        Button startAdventureButton = new Button();
        root.getChildren().add(startAdventureButton);
        startAdventureButton.relocate(410, 150);
        startAdventureButton.setMinHeight(100);
        startAdventureButton.setMinWidth(310);
        startAdventureButton.setOpacity(100);
        double degree = 9.6 * 180/Math.PI;
        startAdventureButton.setRotate(degree);
        startAdventureButton.setOnMouseClicked(event -> {

        });
        Button startAdventureButton1 = new Button();
        root.getChildren().add(startAdventureButton1);
        startAdventureButton1.relocate(485, 100);
        startAdventureButton1.setMinHeight(50);
        startAdventureButton1.setMinWidth(140);
        startAdventureButton1.setOpacity(100);
        double degree1 = 2 * 180/Math.PI;
        startAdventureButton1.setRotate(degree);
        startAdventureButton1.setOnMouseClicked(event -> {

        });

        TextField textField=new TextField("Enter Username");
        root.getChildren().add(textField);
        textField.setAlignment(Pos.BASELINE_CENTER);
        textField.setStyle("");


        primaryStage.setScene(scene);
        primaryStage.show();

       try {
           //MenuHandler menuHandler=new MenuHandler();
            menuHandler.run();
       }
       catch (Exception e) {

       }

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
