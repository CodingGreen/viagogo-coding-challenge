
/**
 * This class could be easily modified to source it's values from a proper
 * configuration file.
 *
 * @author Adam
 */
public class Configuration {

    /**
     * 
     * @return The minimum range of the Y axis of the world.
     */
    public static int getYAxisMinRange() {
        return -10;
    }

    /**
     *
     * @return The maximum range of the Y axis of the world.
     */
    public static int getYAxisMaxRange() {
        return 10;
    }

    /**
     *
     * @return The minimum range of the X axis of the world.
     */
    public static int getXAxisMinRange() {
        return -10;
    }

    /**
     *
     * @return The maximum range of the X axis of the world.
     */
    public static int getXAxisMaxRange() {
        return 10;
    }

    /**
     * Made a presumption that 20 would suffice.
     *
     * @return The maximum number of tickets that will be randomly generated.
     */
    public static int maxTicketNumbers() {
        return 20;
    }

    /**
     * Made a presumption that at least 20 would be need to sufficiently
     * populate world
     *
     * @return The minimum number of events that will be randomly generated.
     */
    public static int minEventNumbers() {
        return 20;
    }

    /**
     * Made a presumption that 20 would suffice.
     *
     * @return The maximum number of events that will be randomly generated.
     */
    public static int maxEventNumbers() {
        return 50;
    }

    /**
     * Made a presumption that 150 would suffice.
     *
     * @return The maximum price of a generated ticket.
     */
    public static float maxTicketPrice() {
        return 150f;
    }

    /**
     *
     * @return The default currency symbol.
     */
    public static char defaultCurrency() {
        return '$';
    }

    /**
     *
     * @return The number of events given when looking for closest events.
     */
    public static int numOfClosestEvents() {
        return 5;
    }

}
