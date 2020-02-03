package Controller.Menus;

import Model.Player.Profile;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Platform.exit;

public class LoginMenu extends Menu implements Initializable {

    public Button quitButton;
    public Button CreateAccountButton;
    public Button LoginButton;
    public Button LeaderBoardButton;

    public LoginMenu() {
        this.orders = new String[]{"Create account", "Login", "Leaderboard", "Help", "Exit"};
    }

    public void createAccount(String username, String password) {
        if (Profile.validUsername(username)) {
            Profile profile = new Profile(username, password);
            Profile.addAccount(profile);
            menuHandler.setCurrentMenu(loginMenu);
            System.out.println("Account created");
        } else {
            System.out.println("invalid username");
        }
    }

    public Profile Login(String username, String password) {
        Profile p = Profile.login(username, password);
        if (p != null) {
            System.out.println("logged in");
            menuHandler.setCurrentMenu(mainMenu);
        } else
            System.out.println("wrong username or password");
        return p;
    }

    public void Exit() {
        menuHandler.setCurrentMenu(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        quitButton.setOnAction(ActionsOfAnEvent -> exit());
        //todo
        LeaderBoardButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    Parent root = (FXMLLoader.load(getClass().getResource("LeaderBoard.fxml")));
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