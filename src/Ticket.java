

/**
 * A class to represent a Ticket for an Event
 * @author Adam
 */
public class Ticket implements Comparable<Ticket> {
    
    private final Price price;
    
    /**
     * Creates a ticket with a given price.
     * @param price A price object which represents the price of this ticket.
     */
    public Ticket(Price price) {
        this.price = price;
    }
    
    /**
     *
     * @return The price of this ticket
     */
    public Price getPrice() {
        return price;
    }

    @Override
    public int compareTo(Ticket t) {
        return price.compareTo(t.getPrice());
    }
    
}
