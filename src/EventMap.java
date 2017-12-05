
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A class to represent the world
 *
 * @author Adam
 */
public class EventMap {

    private final Coordinate topLeftBound;
    private final Coordinate bottomRightBound;
    private final Map<Coordinate, Event> eventMap;

    /**
     * Constructor which creates an EventMap object with given parameters.
     *
     * @param topLeftBound The top left coordinate of the square which bounds
     * the world.
     * @param bottomRightBound The bottom right coordinate of the square which
     * bounds the world.
     * @param eventMap A map of coordinates to events which contains all the
     * events in this world.
     */
    public EventMap(Coordinate topLeftBound, Coordinate bottomRightBound, Map<Coordinate, Event> eventMap) {
        this.topLeftBound = topLeftBound;
        this.bottomRightBound = bottomRightBound;
        this.eventMap = eventMap;
    }

    /**
     *
     * @return The top left coordinate of the square which bounds the world.
     */
    public Coordinate getTopLeftBound() {
        return topLeftBound;
    }

    /**
     *
     * @return The bottom right coordinate of the square which bounds the world.
     */
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
