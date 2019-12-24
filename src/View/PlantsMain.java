package View;

import com.gilecode.yagson.YaGson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class PlantsMain {
    Scanner scanner=new Scanner(System.in);
    public static <DataObject> void main(String[] args) throws FileNotFoundException {
        YaGson gson = new YaGson();
        BufferedReader br = new BufferedReader(
                new FileReader("D:\\Programming\\Java\\AP-07\\Zombies\\PogoZombie.json"));

        Object obj = gson.fromJson(br, Object.class);

        System.out.println(obj);
    }
}
