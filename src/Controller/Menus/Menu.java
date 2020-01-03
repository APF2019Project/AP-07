package Controller.Menus;

import Controller.GameMode.WaterModeMenu;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
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
    public static PlayMenu playMenu = new PlayMenu();
    public static LeaderBoard leaderBoard = new LeaderBoard();
    public static MainMenu mainMenu = new MainMenu();
    public static ProfileMenu profileMenu = new ProfileMenu();
    public static ShopMenu shopMenu = new ShopMenu();
    public static MenuHandler menuHandler = new MenuHandler();
    public static GameMenu gameMenu = new GameMenu();
    public static RailMenu railMenu = new RailMenu();
    public static WaterModeMenu waterModeMenu = new WaterModeMenu();
    public static ZombieMenu zombieMenu = new ZombieMenu();

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

        String[] plants = new String[]{"Cabbage-pult", "Cactus", "Cattail", "CherryBomb", "Explode-o-nut", "GatlingPea", "Kernel-pult", "LilyPad", "Magnet-shroom", "Melon-pult", "PeaShooter", "PotatoMine", "Repeater", "Scaredy-shroom", "SnowPea", "SplitPea", "SunFlower", "Tall-nut", "TangleKelp", "ThreePeater", "TwinSunFlower", "Wall-nut", "WinterMelon"};
        String[] zombies = new String[]{"BalloonZombie",
                "BucketheadZombie",
                "BungeeZombie",
                "CatapultZomboni",
                "ConeheadZombie",
                "DolphinRiderZombie",
                "FootballZombie",
                "Giga-gargantuar",
                "NewspaperZombie", "PogoZombie", "ScreenDoorZombie", "SnorkelZombie", "TargetZombie", "Zombie", "Zomboni"};
        for (String x : plants)
            Plant.makePlant(x);
        for (String x : zombies)
            Zombie.makeZombie(x);

    }
}