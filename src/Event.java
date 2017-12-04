
import java.util.ArrayList;
import java.util.List;

public class Event {

    private final int ID;
    private final List<Ticket> tickets;

    public Event(int ID) {
        this.ID = ID;
        tickets = new ArrayList<>();
    }

    public Event(int ID, List<Ticket> tickets) {
        this.ID = ID;
        this.tickets = tickets;
    }
    
}
