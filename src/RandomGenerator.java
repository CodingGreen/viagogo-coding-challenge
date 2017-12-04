
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

    Random randomnessGenerator = new Random();

    public int generateEventsNumber() {
        return generateIntBetween(Configuration.minEventNumbers(), Configuration.maxEventNumbers());
    }
    
    public Event generateEvent(int id) {
        return new Event(id, generateTickets());
    }
    
    public int generateXCoordinate() {
        return generateIntBetween(Configuration.getXAxisMinRange(), Configuration.getXAxisMaxRange());
    }
    
    public int generateYCoordinate() {
        return generateIntBetween(Configuration.getYAxisMinRange(), Configuration.getYAxisMaxRange());
    }

    private List<Ticket> generateTickets() {
        List<Ticket> generatedList = new ArrayList<>();
        int numOfTickets = generateIntBetween(0, Configuration.maxTicketNumbers());
        for (int i = 0; i < numOfTickets; i++) {
            generatedList.add(new Ticket(generatePrice()));
        }
        return generatedList;
    }

    private Price generatePrice() {
        return new Price(new BigDecimal(generateFloatBetween(0.01f, Configuration.maxTicketPrice())), Configuration.defaultCurrency());
    }

    private int generateIntBetween(int lowerBound, int upperBound) {
        return (randomnessGenerator.nextInt(upperBound - lowerBound + 1)) + lowerBound;
    }

    private float generateFloatBetween(float lowerBound, float upperBound) {
        return (randomnessGenerator.nextFloat() * (upperBound - lowerBound)) + lowerBound;
    }

}
