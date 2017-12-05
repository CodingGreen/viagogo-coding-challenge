
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomGenerator {

    Random randomnessGenerator = new Random();

    public Map<Coordinate, Event> generateEvents() {
        int numberOfEvents = generateIntBetween(Configuration.minEventNumbers(), Configuration.maxEventNumbers());
        Map<Coordinate, Event> events = new HashMap<>(numberOfEvents);
        Coordinate location;
        for (int i = 0; i < numberOfEvents; i++) {
            location = new Coordinate(generateXCoordinate(), generateYCoordinate());
            events.put(location, generateEvent(i, location));
        }
        return events;
    }

    private Event generateEvent(int id, Coordinate location) {
        return new Event(id, location, generateTickets());
    }

    private int generateXCoordinate() {
        return generateIntBetween(Configuration.getXAxisMinRange(), Configuration.getXAxisMaxRange());
    }

    private int generateYCoordinate() {
        return generateIntBetween(Configuration.getYAxisMinRange(), Configuration.getYAxisMaxRange());
    }

    private List<Ticket> generateTickets() {
        List<Ticket> generatedList = new ArrayList<>();
        int numOfTickets = generateIntBetween(0, Configuration.maxTicketNumbers());
        for (int i = 1; i <= numOfTickets; i++) {
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
