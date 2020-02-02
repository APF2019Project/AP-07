package Controller.Menus;

import Model.Card.ActionsOfAnEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;

public class HelpMenu extends Menu implements Initializable {
    public Button backButton;
    public MenuItem closeButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    Parent root = (FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
                    Menu.primaryStage.setScene(new Scene(root));
                    Menu.primaryStage.show();
                    Menu.primaryStage.setTitle("PvZ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        closeButton.setOnAction(ActionsOfAnEvent -> exit());
    }

}
