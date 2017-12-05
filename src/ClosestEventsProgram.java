
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

/**
 * Class which represents a program which can returns closest events in a world.
 *
 * @author Adam
 */
public class ClosestEventsProgram {

    private EventMap eventMap;

    /**
     * Call this method to start the program.
     */
    public void run() {
        createWorld();
        userInterface();
    }

    private void createWorld() {
        RandomGenerator random = new RandomGenerator();

        //Stores the world bounds as coordinates
        Coordinate topLeftBound = new Coordinate(Configuration.getXAxisMinRange(), Configuration.getYAxisMaxRange());
        Coordinate bottomRightBound = new Coordinate(Configuration.getXAxisMaxRange(), Configuration.getYAxisMinRange());

        //Populates the event map with random events
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

                //Parses user input as coordinates
                location = Coordinate.parse(coordinates);

                //Checks given location is within the world
                if (!location.isWithinSquare(eventMap.getTopLeftBound(), eventMap.getBottomRightBound())) {
                    //Prints out error message
                    output.println("The size of this world is "
                        + eventMap.getTopLeftBound()
                        + " to "
                        + eventMap.getBottomRightBound());
                    //Set the input loop to run again
                    retry = true;
                }

            } catch (IOException ex) {
                output.println("There was an error please try again.");
                retry = true;
            }
        } while (retry);

        //Fetches the list of closest events
        List<Event> events = eventMap.closestEvents(location);

        //Prints output
        output.println("Closest Events to " + location + ":");
        String ticketInfo;

        for (Event event : events) {

            //Checks if event has any tickets
            if (event.hasTickets()) {
                ticketInfo = event.getCheapestTicket().getPrice().toString();
            } else {
                ticketInfo = "No tickets";
            }

            output.println(event + " - " + ticketInfo
                + ", Distance " + event.manhattanDistanceFrom(location));
        }
    }

}
