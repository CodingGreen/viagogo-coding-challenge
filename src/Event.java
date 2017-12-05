
import java.util.List;

/**
 * A class to represent an event in the world.
 *
 * @author Adam
 */
public class Event {

    private final int id;
    private final Coordinate location;
    private final List<Ticket> tickets;

    /**
     * Creates a new event object
     *
     * @param id The unique ID of this event.
     * @param location Coordinates expressing the location of this event.
     * @param tickets A list of tickets for this event, which may be empty.
     */
    public Event(int id, Coordinate location, List<Ticket> tickets) {
        this.id = id;
        this.location = location;
        this.tickets = tickets;
    }

    /**
     * Given a location returns the Manhattan Distance to this event.
     *
     * @param location The location to compare distance to.
     * @return The Manhattan distance
     */
    public int manhattanDistanceFrom(Coordinate location) {
        return this.location.manhattanDistanceFrom(location);
    }

    /**
     * Checks if there are tickets avaliable for this event.
     *
     * @return True if there are tickets, False if there are no tickets.
     */
    public boolean hasTickets() {
        return !tickets.isEmpty();
    }

    /**
     * Returns the cheapest ticket
     *
     * @return The cheapest ticket, or null if there are no tickets.
     */
    public Ticket getCheapestTicket() {
        if (hasTickets()) {
            return tickets.stream().min((t1, t2) -> t1.compareTo(t2)).get();
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Event " + id;
    }

}
