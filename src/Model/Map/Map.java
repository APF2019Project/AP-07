package Model.Map;

public class Map {

    private static final int HEIGHT = 6;
    private static final int WIDTH = 19;
    public Cell[][] Cells = new Cell[HEIGHT+4][WIDTH+4];

    public Cell[][] getUnknownCells() {
        return Cells;
    }

    public Cell getCell(int x , int y)
    {
        return Cells[x][y];
    }

    public void setUnknownCell(int x, int y, Cell cell) {
        this.Cells[x][y] = cell;
    }

    public void setLandCell(int x,int y, Cell landCell){

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
