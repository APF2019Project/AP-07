package View;

import Controller.Menus.Menu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class Main extends Application {
    public final static int sceneHeight = 800;
    public final static int sceneWitdh = 800;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Menu.mainMenu.load();
        primaryStage.setScene(new Scene(Menu.mainMenu.root));
        primaryStage.show();
    }
}
