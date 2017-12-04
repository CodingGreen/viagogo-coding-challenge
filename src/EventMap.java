
public class EventMap {
    
    private final int Xrange;
    private final int Yrange;
    private final int[][] worldMap;

    public EventMap() {
        Xrange = Configuration.getXAxisMaxRange() - Configuration.getXAxisMinRange();
        Yrange = Configuration.getYAxisMaxRange() - Configuration.getYAxisMinRange();
        worldMap = new int[Xrange][Yrange];
    }
    
}
