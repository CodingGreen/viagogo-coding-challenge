
public class Ticket implements Comparable<Ticket> {
    
    private final Price price;
    
    public Ticket(Price price) {
        this.price = price;
    }
    
    public Price getPrice() {
        return price;
    }

    @Override
    public int compareTo(Ticket t) {
        return price.compareTo(t.getPrice());
    }
    
}
