package Model.Map;

public class Map {

    private static final int HEIGHT = 6;
    private static final int WIDTH = 19;
    public LandCell[][] unknownCells = new LandCell[HEIGHT+4][WIDTH+4];

    public UnknownCell[][] getUnknownCells() {
        return unknownCells;
    }

    public UnknownCell getCell(int x ,int y)
    {
        return unknownCells[x][y];
    }

    public void setUnknownCell(int x, int y,LandCell unknownCell) {
        this.unknownCells[x][y] = unknownCell;
    }

    public void setLandCell(int x,int y, LandCell landCell){

    }

    void updateCells(){
        // zombie ha va plant haye cell ha ro tabe hashun ro ye dor seda kone
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }
}
