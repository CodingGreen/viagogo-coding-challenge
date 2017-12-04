
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

public class ClosestEventsProgram {

    private EventMap eventMap;

    public void run() {
        createWorld();
        userInterface();
    }

    private void createWorld() {
        RandomGenerator random = new RandomGenerator();
        Coordinate topLeftBound = new Coordinate(Configuration.getXAxisMinRange(), Configuration.getYAxisMaxRange());
        Coordinate bottomRightBound = new Coordinate(Configuration.getXAxisMaxRange(), Configuration.getYAxisMinRange());
        eventMap = new EventMap(topLeftBound, bottomRightBound, random.generateEvents());
    }

    private void userInterface() {
        PrintStream output = System.out;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean retry = false;
        Coordinate location = null;
        do {
            try {
                output.println("Please Input Coordinates:");
                String coordinates = input.readLine();
                location = Coordinate.parse(coordinates);
                if (!location.isWithinSquare(eventMap.getTopLeftBound(), eventMap.getBottomRightBound())) {
                    output.println("The size of this world is "
                        + eventMap.getTopLeftBound()
                        + " to "
                        + eventMap.getBottomRightBound());
                    retry = true;
                }
            } catch (IOException ex) {
                output.println("There was an error please try again.");
                retry = true;
            }
        } while (retry);
        List<Event> events = eventMap.closestEvents(location);
        output.println("Closest Events to " + location + ":");
        for (Event event : events) {
            output.println(event + " - " + event.getCheapestTicket().getPrice()
                + ", Distance " + event.manhattanDistanceFrom(location));
        }
    }

}
