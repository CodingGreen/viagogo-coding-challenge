
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventMap {

    private final Coordinate topLeftBound;
    private final Coordinate bottomRightBound;
    private final Map<Coordinate, Event> eventMap;

    public EventMap(Coordinate topLeftBound, Coordinate bottomRightBound, Map<Coordinate, Event> eventMap) {
        this.topLeftBound = topLeftBound;
        this.bottomRightBound = bottomRightBound;
        this.eventMap = eventMap;
    }

    public Coordinate getTopLeftBound() {
        return topLeftBound;
    }

    public Coordinate getBottomRightBound() {
        return bottomRightBound;
    }

    /**
     * Given a location returns an ordered list of closest events (using
     * Manhattan distance). The length of this list is determined by the
     * Configuration class.
     *
     * @param location The coordinates of the location.
     * @return The list of closest events.
     */
    public List<Event> closestEvents(Coordinate location) {
        /* If there was a much larger world size then a Breadth First Search
         * radiating out from the given coordinates would be more effective.
         * However for this small world size we can just sort the entry list of
         * the map.
         */
        return eventMap.values().stream()
            .sorted((Event e1, Event e2)
                -> Integer.compare(e1.manhattanDistanceFrom(location), e2.manhattanDistanceFrom(location)))
            .limit(Configuration.numOfClosestEvents())
            .collect(Collectors.toList());
    }

}
