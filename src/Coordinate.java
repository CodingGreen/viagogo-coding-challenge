
public class Coordinate {

    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public int manhattanDistanceFrom(Coordinate location) {
        return Math.abs(x - location.x) + Math.abs(y - location.y);
    }
    
    public boolean isWithinSquare(Coordinate topLeft, Coordinate bottomRight) {
        return (x >= topLeft.x && x <= bottomRight.x && y <= topLeft.y && y >= bottomRight.y);
    }

    public static Coordinate parse(String coordinates) {
        String[] parts = coordinates.split(",");
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

    private static class CoordinateFormatException extends IllegalArgumentException {

        public CoordinateFormatException(String s) {
            super(s);
        }

    }

}
