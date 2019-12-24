//package View;
//
//import Controller.Menus.Menu;
//
//
//public class Main {
//
//
//    public static void main(String[] args) {
//        Menu.menuHandler.run();
//    }
//}
package View;

import com.gilecode.yagson.YaGson;
import com.gilecode.yagson.com.google.gson.JsonObject;
import com.gilecode.yagson.com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        JsonParser parser = new JsonParser();
        try {
            Object object = parser.parse(new FileReader("zz.json"));
            YaGson yaGson = (YaGson) object;
            JsonObject jsonObject = yaGson.;
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        catch (ParseException e) {e.printStackTrace();}
        catch (Exception e) {e.printStackTrace();}

    }
}