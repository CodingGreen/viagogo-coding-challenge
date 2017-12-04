
public class EventMap {
    
    private final int Xrange;
    private final int Yrange;
    private final Event[][] worldMap;

    public EventMap() {
        Xrange = Configuration.getXAxisMaxRange() - Configuration.getXAxisMinRange() + 1;
        Yrange = Configuration.getYAxisMaxRange() - Configuration.getYAxisMinRange() + 1;
        worldMap = new Event[Xrange][Yrange];
    }
    
    public void AddEvent(Event event, int x, int y) {
        worldMap[xCoordinateToArrayIndex(x)][yCoordinateToArrayIndex(y)] = event;
    }
    
    private int xCoordinateToArrayIndex(int coordinate) {
        return coordinate - Configuration.getXAxisMinRange();
    }
    
    private int yCoordinateToArrayIndex(int coordinate) {
        return coordinate - Configuration.getYAxisMinRange();
    }
    
}
