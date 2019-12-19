package Model.Card;

import Model.Map.Cell;
import Model.Shop.Collection;

import java.util.ArrayList;

public class Card {
    protected String name;
    int id;
    private static int uniqueId = 0;
    int AP;//attack point
    int HP;//hosseinpur

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    Cell cell;
    Collection collection;
    int coin;

    private static ArrayList<Card> cards;

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
