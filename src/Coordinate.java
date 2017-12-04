
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
    
    public int manhattanDistanceFrom(Coordinate location) {
        return Math.abs(x - location.x) + Math.abs(y - location.y);
    }
    
}
