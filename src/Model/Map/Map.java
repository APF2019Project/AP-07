package Model.Map;

public class Map {
    private static final int HEIGHT = 6;
    private static final int WIDTH = 19;

    public static UnknownCell[][] unknowncells = new UnknownCell[HEIGHT][WIDTH];

    public static UnknownCell getCell(int x ,int y)
    {
        return Map.unknowncells[x][y];
    }

    public static Cell getCell(Cell cell) {
        return null;
    }

    void updateCells(){
        // zombie ha va plant haye cell ha ro tabe hashun ro ye dor seda kone
    }
}
