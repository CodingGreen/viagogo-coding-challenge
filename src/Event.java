
import java.util.List;

public class Event {

    private final int id;
    private final Coordinate location;
    private final List<Ticket> tickets;

    public Event(int id, Coordinate location, List<Ticket> tickets) {
        this.id = id;
        this.location = location;
        this.tickets = tickets;
    }
    
    public int manhattanDistanceFrom(Coordinate location) {
        return this.location.manhattanDistanceFrom(location);
    }
    
    public Ticket getCheapestTicket() {
        return tickets.stream().min((t1, t2) -> t1.compareTo(t2)).get();
    }

    @Override
    public String toString() {
        return "Event " + id;
    }

}
