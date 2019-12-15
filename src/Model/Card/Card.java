package Model.Card;

import Model.Map.Cell;
import Model.Shop.Collection;

import java.util.ArrayList;

public class Card {
    String name;
    int id;
    private static int uniqueId=0;
    int AP;//attack point
    int HP;//hosseinpur
    Cell location;
    Collection collection;


    private static ArrayList<Card> cards;

}
