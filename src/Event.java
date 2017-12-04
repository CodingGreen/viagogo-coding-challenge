
import java.util.List;

public class Event {

    private final int ID;
    private final Coordinate location;
    private final List<Ticket> tickets;

    public Event(int ID, Coordinate location, List<Ticket> tickets) {
        this.ID = ID;
        this.location = location;
        this.tickets = tickets;
    }
    
    public int manhattanDistanceFrom(Coordinate location) {
        return this.location.manhattanDistanceFrom(location);
    }

}
