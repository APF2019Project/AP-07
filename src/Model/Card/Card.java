package Model.Card;

import Model.Map.Cell;
import Model.Shop.Collection;

import java.util.ArrayList;

public class Card {
    protected String name;
    int id;
    private static int uniqueId = 0;
    int AP;//attack point
    int HP;//hosseinpour
    Cell location;
    Collection collection;
    int coin;


    public int getCoin() {
        return this.coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
