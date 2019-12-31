package Model.Map;

public class Map {

    private static final int HEIGHT = 6;
    private static final int WIDTH = 19;

    public UnknownCell[][] getUnknownCells() {
        return unknownCells;
    }

    public static UnknownCell[][] unknownCells = new UnknownCell[HEIGHT + 3][WIDTH + 3];

    public UnknownCell getCell(int x, int y) {
        return unknownCells[x][y];
    }

    public void setLandCell(int x, int y, LandCell landCell) {
        unknownCells[x][y] = landCell;
    }


    void updateCells() {
        // zombie ha va plant haye cell ha ro tabe hashun ro ye dor seda kone
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }
}
