package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    public void addHexagon(TETile[][] world, Point origin, int size, TETile teTile) {

    }

    /**
     * Get the points which are needed to filled for the row
     * @param origin the origin point of the Hexagon (The left and bottom point)
     * @param size the size of the Hexagon
     * @param row the row of the Hexagon which between 0 and 2 * size - 1
     * @return the points which are needed to filled
     */
    private ArrayList<Point> getPointsForRow(Point origin, int size, int row) {
        if (row < 0 || row > 2 * size - 1) {
            return null;
        }
        ArrayList<Point> res = new ArrayList<>();

        return res;
    }

    @Test
    public void addHexagonTest() {
        final int WIDTH = 50;
        final int HEIGHT = 50;

        final long SEED = 2873123;
        final Random RANDOM = new Random(SEED);

        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] randomTiles = new TETile[WIDTH][HEIGHT];
        addHexagon(randomTiles, new Point(0, 0), 2, Tileset.FLOWER);
    }
}
