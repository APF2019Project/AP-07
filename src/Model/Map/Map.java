package Model.Map;

public class Map {
    public static final int HEIGHT = 6;
    public static final int WIDTH = 19;

    public UnknownCell[][] getUnknownCells() {
        return unknownCells;
    }

    public UnknownCell[][] unknownCells = new UnknownCell[HEIGHT+3][WIDTH+3];

    public static UnknownCell getCell(int x ,int y)
    {
        return unknownCells[x][y];
    }
    public void setLandCell(int x, int y, LandCell landCell) {
        unknownCells[x][y] = landCell;
    }


    void updateCells(){
        // zombie ha va plant haye cell ha ro tabe hashun ro ye dor seda kone
    }
}
