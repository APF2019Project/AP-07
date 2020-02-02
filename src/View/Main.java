package View;

import Controller.Menus.Menu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.*;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;

public class Main extends Application {
    public final static int sceneHeight = 800;
    public final static int sceneWitdh = 800;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("../Controller/Menus/MainMenu.fxml"));
        // todo //ba loginMenu shoro beshe bazi
        primaryStage.setTitle("Plants vs Zombies");

        String path = "src/View/MainMenu.mp3";
        Media media = new Media(new File(path).toURI().toString());

        //Instantiating MediaPlayer class
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        //by setting this property to true, the audio will be played
        mediaPlayer.setAutoPlay(true);

        Controller.Menus.Menu.primaryStage.setScene(new Scene(root));
        Menu.primaryStage.show();
        Menu.primaryStage.setTitle("PvZ");

//        Button quitButton = new Button();
//        root.getChildren().add(quitButton);
//        quitButton.relocate(720, 680);
//        quitButton.setMinHeight(50);
//        quitButton.setMinWidth(50);
//        quitButton.setOpacity(0);
//        quitButton.setOnMouseClicked(event -> {
//            jhajCJUK();
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
//        Button startAdventureButton = new Button();
//        root.getChildren().add(startAdventureButton);
//        startAdventureButton.relocate(410, 150);
//        startAdventureButton.setMinHeight(100);
//        startAdventureButton.setMinWidth(310);
//        startAdventureButton.setOpacity(100);
//        double degree = 9.6 * 180/Math.PI;
//        startAdventureButton.setRotate(degree);
//        startAdventureButton.setOnMouseClicked(event -> {
//
//        });
//        Button startAdventureButton1 = new Button();
//        root.getChildren().add(startAdventureButton1);
//        startAdventureButton1.relocate(485, 100);
//        startAdventureButton1.setMinHeight(50);
//        startAdventureButton1.setMinWidth(140);
//        startAdventureButton1.setOpacity(100);
//        double degree1 = 2 * 180/Math.PI;
//        startAdventureButton1.setRotate(degree);
//        startAdventureButton1.setOnMouseClicked(event -> {
//
//        });
//
//        TextField textField=new TextField("Enter Username");
//        root.getChildren().add(textField);
//        textField.setAlignment(Pos.BASELINE_CENTER);
//        textField.setStyle("");
//

    }
    public static void main(String[] args){
        launch(args);
    }


}
