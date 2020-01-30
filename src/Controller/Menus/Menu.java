package Controller.Menus;

import Model.Card.Action;
import Model.Card.ActionsOfAnEvent;
import Model.Card.Event.*;
import Model.Card.Plants.Plant;
import Model.Card.Plants.PlantsActions.Burst;
import Model.Card.Plants.PlantsActions.Magnet;
import Model.Card.Plants.PlantsActions.ProduceSun;
import Model.Card.Plants.PlantsActions.Shoot;
import Model.Card.Zombies.Zombie;
import Model.Player.Player;
import Model.Player.Profile;
import com.gilecode.yagson.YaGson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Menu {
    public static LoginMenu loginMenu = new LoginMenu();
    public static CollectionMenu collectionMenu = new CollectionMenu();
    public static PlayMenu playMenu;

    static {
        try {
            playMenu = new PlayMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LeaderBoard leaderBoard = new LeaderBoard();
    public static MainMenu mainMenu = new MainMenu();
    public static ProfileMenu profileMenu = new ProfileMenu();
    public static ShopMenu shopMenu = new ShopMenu();
    public static MenuHandler menuHandler = new MenuHandler();
    public static GameMenu gameMenu = new GameMenu();
    public static RailMenu railMenu = new RailMenu();
    public static WaterModeMenu waterModeMenu = new WaterModeMenu();
    public static ZombieMenu zombieMenu = new ZombieMenu();
    public static PvPMenu pvPMenu = new PvPMenu();

    public String[] getOrders() {
        return orders;
    }

    protected String[] orders;

    public static void help() {
        for (String x : menuHandler.getCurrentMenu().getOrders()) {
            System.out.println(x);
        }
    }

    public static void init() throws IOException {
        menuHandler.setCurrentMenu(loginMenu);
        YaGson yaGson = new YaGson();
        File file = new File("Accounts//accounts");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String string = new String();
        String s = new String();
        while (true) {
            s = br.readLine();
            if (s != null)
                string += (s);
            else
                break;
        }
        ArrayList<Profile> profiles = yaGson.fromJson(string, ArrayList.class);
        Profile.setProfiles(profiles);

        String[] plants = new String[]{"CabbagePult", "Cactus", "Cattail", "CherryBomb", "ExplodeONut", "GatlingPea", "KernelPult", "LilyPad","Jalapeno", "MagnetShroom", "Melon-pult", "PeaShooter", "PotatoMine", "Repeater", "ScaredyShroom", "SnowPea", "SplitPea", "SunFlower", "Tall-nut", "TangleKelp", "ThreePeater", "TwinSunFlower", "Wall-nut", "WinterMelon"};
        String[] zombies = new String[]{"BalloonZombie",
                "BucketheadZombie",
                "BungeeZombie",
                "CatapultZomboni",
                "ConeheadZombie",
                "DolphinRiderZombie",
                "FootballZombie",
                "GigaGargantuar",
                "NewspaperZombie", "PogoZombie", "ScreenDoorZombie", "SnorkelZombie", "TargetZombie", "Zombie", "Zomboni"};
        for (String x : plants) {
            Plant p = new Plant(x);
                p = Plant.makePlant(x);
        }
//        Event inTheSameRow = new NearRows();
//        Event OnSpawn = new OnSpawn();
//        Event nearest = new NearestCell();
//        Event proximityInRadiausDistance = new ProximityInRadiousDistance();
//        Event nearRows = new NearRows();
//        Event valid=new Valid();
//
//        Action burst = new Burst();
//        Action produceSun = new ProduceSun();
//        Action shoot = new Shoot();
//        Action magnet = new Magnet();
//
//        ArrayList<Action> actions = new ArrayList<>();
//
//        Plant peaShooter = Plant.makePlant("PeaShooter");
//        actions.add(shoot);
//        peaShooter.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, actions) {
//        });
//
//        Plant snowPea = Plant.makePlant("SnowPea");
//        actions.clear();
//        actions.add(shoot);
//        snowPea.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });
//
//        Plant cabbagePult = Plant.makePlant("CabbagePult");
//        actions.clear();
//        actions.add(shoot);
//        cabbagePult.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });
//
//        Plant repeater = Plant.makePlant("Repeater");
//        actions.clear();
//        actions.add(shoot);
//        repeater.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });
//
//        Plant threepeater = Plant.makePlant("Threepeater");
//        actions.clear();
//        actions.add(shoot);
//        threepeater.setActionsOfAnEvent(new ActionsOfAnEvent(nearRows, actions) {
//        });
//
//        Plant cactus = Plant.makePlant("Cactus");
//        actions.clear();
//        actions.add(shoot);
//        cactus.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });
//
//        Plant gatlingPea = Plant.makePlant("GatlingPea");
//        actions.clear();
//        actions.add(shoot);
//        gatlingPea.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });
//
//        Plant scaredyShroom = Plant.makePlant("ScaredyShroom");
//        actions.clear();
//        actions.add(shoot);
//        scaredyShroom.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });
//
//        Plant kernelPult = Plant.makePlant("KernelPult)");
//        actions.clear();
//        actions.add(shoot);
//        kernelPult.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });
//
//        Plant explodeONut = Plant.makePlant("ExplodeONut");
//        actions.clear();
//        actions.add(shoot);
//        explodeONut.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, actions) {
//        });
//
//        Plant melonPult = Plant.makePlant("MelonPult");
//        actions.clear();
//        actions.add(shoot);
//        melonPult.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });
//
//        Plant lilyPad = Plant.makePlant("LilyPad");
//        actions.clear();
//        lilyPad.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, actions) {
//        });
//
//        Plant winterMelon = Plant.makePlant("WinterMelon");
//        actions.clear();
//        actions.add(shoot);
//        winterMelon.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });

        for (String x : zombies)
            Zombie.makeZombie(x);

    }
}