
public class ViagogoCodingChallange {

    public static void main(String[] args) {

    }

    public static void createWorld() {
        RandomGenerator random = new RandomGenerator();
        EventMap eventMap = new EventMap();
        int numberOfEvents = random.generateEventsNumber();
        for (int i = 0; i < numberOfEvents; i++) {
            eventMap.AddEvent(random.generateEvent(i), random.generateXCoordinate(), random.generateYCoordinate());
        }
    }

}
