package Controller.Menus;

import Model.Card.Card;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Player.Player;
import Model.Player.Profile;
import Model.Shop.Shop;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShopMenu extends Menu implements Initializable {

    public ImageView SunFlower;
    public ImageView PeaShooter;
    public ImageView Cattail;
    public ImageView Jalapeno;
    public ImageView SnowPea;
    public ImageView CherryBomb;
    public ImageView ExplodeONut;
    public ImageView PotatoMine;
    public ImageView CabbagePult;
    public ImageView TangleKelp;
    public ImageView WinterMelon;
    public ImageView Kernelpult;
    public ImageView ThreePeater;
    public ImageView SplitPea;
    public ImageView TwinSunFlower;
    public ImageView WallNut;
    public ImageView Cactus;
    public ImageView GatlingPea;
    public ImageView MelonPult;
    public ImageView Repeater;
    public ImageView MagnetShroom;
    public ImageView LilyPad;




    public ShopMenu() {
        this.orders = new String[]{"Show shop", "Show collection", "Buy", "Money", "Help", "Exit"};
    }

    public void showShop(Profile profile) {
        ArrayList<Plant> plants = Card.getPlants();
        System.out.println("Plants");
        System.out.println("----------------------");
        for (Plant x : plants)
            if (!profile.getPurchasedPlants().contains(x))
                System.out.println(x.getName() + "\t" + x.getPrice());
        System.out.println("----------------------");
        System.out.println("Zombies");
        System.out.println("----------------------");
        for (Zombie x : Card.getZombies())
            if (!profile.getPurchasedZombies().contains(x))
                System.out.println(x.getName() + "\t" + x.getPrice());
        System.out.println("----------------------");
    }

    public void getCards(Profile profile) {
        for (String x : profile.getPurchasedPlants())
            System.out.println(x);
        for (String x : profile.getPurchasedZombies())
            System.out.println(x);
    }

    public void buy(String name, Profile profile) {
        Zombie z = Zombie.findZombie(name);
        Plant p = Plant.findPlant(name);
        if (z != null && !profile.getPurchasedZombies().contains(z.getName())&& z.getPrice() <= profile.getExternalCoins()){
            System.out.println("kharid");
            profile.addZombie(z);
            profile.setExternalCoins(-z.getPrice());
        }
        else if (p != null &&!profile.getPurchasedPlants().contains(p.getName()) && p.getPrice() <= profile.getExternalCoins()){
            System.out.println("kharid");
            profile.setExternalCoins(-p.getPrice());
            profile.addPlant(p);}
        else System.out.println("nakharid");

    }

    public void Exit() {
        Menu.menuHandler.setCurrentMenu(Menu.mainMenu);
    }

    public void showMoney(Profile profile) {
        System.out.println(profile.getExternalCoins());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            if(Menu.profile.getPurchasedPlants().contains("SunFlower"))
                SunFlower.setVisible(false);
            else {
                SunFlower.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Tooltip tooltip = new Tooltip("SunFlower  " + Plant.findPlant("sunflower").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(SunFlower, tooltip);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if(Menu.profile.getPurchasedPlants().contains("PeaShooter"))
                PeaShooter.setVisible(false);
            else {
                PeaShooter.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Tooltip tooltip = new Tooltip("PeaShooter  " + Plant.findPlant("PeaShooter").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(PeaShooter, tooltip);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(Menu.profile.getPurchasedPlants().contains("Cattail"))
                Cattail.setVisible(false);
            else {
                Cattail.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Tooltip tooltip = new Tooltip("Cattail  " + Plant.findPlant("Cattail").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(Cattail, tooltip);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(Menu.profile.getPurchasedPlants().contains("Jalapeno"))
                Jalapeno.setVisible(false);
            else {
                Jalapeno.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Tooltip tooltip = new Tooltip("Jalapeno  " + Plant.findPlant("Jalapeno").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(Jalapeno, tooltip);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(Menu.profile.getPurchasedPlants().contains("SnowPea"))
                SnowPea.setVisible(false);
            else {
                SnowPea.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Tooltip tooltip = new Tooltip("SnowPea  " + Plant.findPlant("SnowPea").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(SnowPea, tooltip);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(Menu.profile.getPurchasedPlants().contains("CherryBomb"))
                CherryBomb.setVisible(false);
            else {
                CherryBomb.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Tooltip tooltip = new Tooltip("CherryBomb  " + Plant.findPlant("CherryBomb").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(CherryBomb, tooltip);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(Menu.profile.getPurchasedPlants().contains("ExplodeONut"))
                ExplodeONut.setVisible(false);
            else {
                ExplodeONut.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Tooltip tooltip = new Tooltip("ExplodeONut  " + Plant.findPlant("ExplodeONut").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(ExplodeONut, tooltip);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(Menu.profile.getPurchasedPlants().contains("PotatoMine"))
                PotatoMine.setVisible(false);
            else {
                PotatoMine.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Tooltip tooltip = new Tooltip("PotatoMine  " + Plant.findPlant("PotatoMine").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(PotatoMine, tooltip);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(Menu.profile.getPurchasedPlants().contains("CabbagePult"))
                CabbagePult.setVisible(false);
            else {
                CabbagePult.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Tooltip tooltip = new Tooltip("CabbagePult  " + Plant.findPlant("CabbagePult").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(CabbagePult, tooltip);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(Menu.profile.getPurchasedPlants().contains("TangleKelp"))
                TangleKelp.setVisible(false);
            else {
                TangleKelp.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Tooltip tooltip = new Tooltip("TangleKelp  " + Plant.findPlant("TangleKelp").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(TangleKelp, tooltip);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(Menu.profile.getPurchasedPlants().contains("WinterMelon"))
                WinterMelon.setVisible(false);
            else {
                WinterMelon.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Tooltip tooltip = new Tooltip("WinterMelon  " + Plant.findPlant("WinterMelon").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(WinterMelon, tooltip);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(Menu.profile.getPurchasedPlants().contains("Kernelpult"))
                Kernelpult.setVisible(false);
            else {
                Kernelpult.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Tooltip tooltip = new Tooltip("Kernelpult  " + Plant.findPlant("Kernelpult").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(Kernelpult, tooltip);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(Menu.profile.getPurchasedPlants().contains("ThreePeater"))
                ThreePeater.setVisible(false);
            else {
                ThreePeater.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Tooltip tooltip = new Tooltip("ThreePeater  " + Plant.findPlant("ThreePeater").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(ThreePeater, tooltip);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(Menu.profile.getPurchasedPlants().contains("SplitPea"))
                SplitPea.setVisible(false);
            else {
                SplitPea.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Tooltip tooltip = new Tooltip("SplitPea  " + Plant.findPlant("SplitPea").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(SplitPea, tooltip);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(Menu.profile.getPurchasedPlants().contains("TwinSunFlower"))
                TwinSunFlower.setVisible(false);
            else {
                TwinSunFlower.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Tooltip tooltip = new Tooltip("TwinSunFlower  " + Plant.findPlant("TwinSunFlower").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(TwinSunFlower, tooltip);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(Menu.profile.getPurchasedPlants().contains("WallNut"))
            WallNut.setVisible(false);
        else {
            WallNut.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    Tooltip tooltip = new Tooltip("WallNut  " + Plant.findPlant("WallNut").getPrice());
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(WallNut, tooltip);
                }
            });
        }
        try {
            if(Menu.profile.getPurchasedPlants().contains("Cactus"))
                Cactus.setVisible(false);
            else {
                Cactus.setOnMouseEntered(mouseEvent -> {
                    Tooltip tooltip = new Tooltip("Cactus  " + Plant.findPlant("Cactus").getPrice());
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(Cactus, tooltip);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(Menu.profile.getPurchasedPlants().contains("GatlingPea"))
                GatlingPea.setVisible(false);
            else {
                GatlingPea.setOnMouseEntered(mouseEvent -> {
                    Tooltip tooltip = new Tooltip("GatlingPea  " + Plant.findPlant("GatlingPea").getPrice());
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(GatlingPea, tooltip);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(Menu.profile.getPurchasedPlants().contains("MelonPult"))
                MelonPult.setVisible(false);
            else {
                MelonPult.setOnMouseEntered(mouseEvent -> {
                    Tooltip tooltip = new Tooltip("MelonPult  " + Plant.findPlant("MelonPult").getPrice());
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(MelonPult, tooltip);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(Menu.profile.getPurchasedPlants().contains("Repeater"))
                Repeater.setVisible(false);
            else {
                Repeater.setOnMouseEntered(mouseEvent -> {
                    Tooltip tooltip = new Tooltip("Repeater  " + Plant.findPlant("Repeater").getPrice());
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(Repeater, tooltip);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(Menu.profile.getPurchasedPlants().contains("MagnetShroom"))
                MagnetShroom.setVisible(false);
            else {
                MagnetShroom.setOnMouseEntered(mouseEvent -> {
                    Tooltip tooltip = new Tooltip("MagnetShroom  " + Plant.findPlant("MagnetShroom").getPrice());
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(MagnetShroom, tooltip);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(Menu.profile.getPurchasedPlants().contains("LilyPad"))
                LilyPad.setVisible(false);
            else {
                LilyPad.setOnMouseEntered(mouseEvent -> {
                    Tooltip tooltip = new Tooltip("LilyPad  " + Plant.findPlant("LilyPad").getPrice());
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(LilyPad, tooltip);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
