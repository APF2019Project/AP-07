package Model.Map;

public class Map {
    public static final int HEIGHT = 6;
    public static final int WIDTH = 19;

    public static UnknownCell[][] unknowncells = new UnknownCell[HEIGHT][WIDTH];

    public static UnknownCell getCell(int x ,int y)
    {
        return unknowncells[x][y];
    }
    public void setLandCell(int x, int y, LandCell landCell) {
        unknowncells[x][y] = landCell;
    }


    void updateCells(){
        // zombie ha va plant haye cell ha ro tabe hashun ro ye dor seda kone
    }
}
