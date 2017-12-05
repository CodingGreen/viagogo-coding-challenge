
/**
 * A class to represent an x, y coordinate.
 *
 * @author Adam
 */
public class Coordinate {

    private final int x;
    private final int y;

    /**
     * Creates a coordinate object with given x and y coordinates.
     *
     * @param x
     * @param y
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    /**
     * Calculates the Manhattan distance from a given location.
     *
     * @param location The location to compare distance to.
     * @return The Manhattan distance
     */
    public int manhattanDistanceFrom(Coordinate location) {
        return Math.abs(x - location.x) + Math.abs(y - location.y);
    }

    /**
     * Checks if this location is with a given square.
     *
     * @param topLeft A coordinate which represents the top left of the square.
     * @param bottomRight A coordinate which represents the bottom right of the
     * square.
     * @return True if this location is within the square and False otherwise.
     */
    public boolean isWithinSquare(Coordinate topLeft, Coordinate bottomRight) {
        return (x >= topLeft.x && x <= bottomRight.x && y <= topLeft.y && y >= bottomRight.y);
    }

    /**
     * Static method to parse a coordinate from a string.
     *
     * @param coordinate A string in the format of "x,y" where x and y are
     * integers.
     * @return A coordinate object representing the parsed coordinates.
     */
    public static Coordinate parse(String coordinate) {
        String[] parts = coordinate.split(",");
        if (parts.length != 2) {
            throw new CoordinateFormatException("Coordinate must be in the format \"x,y\" where x and y are integers.");
        }
        try {
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            return new Coordinate(x, y);
        } catch (NumberFormatException e) {
            throw new CoordinateFormatException("Coordinate must be in the format \"x,y\" where x and y are integers.");
        }
    }

    public static class CoordinateFormatException extends IllegalArgumentException {

        public CoordinateFormatException(String s) {
            super(s);
        }

    }

}
