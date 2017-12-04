
import java.util.Currency;



/**
 * This class could be easily modified to source it's values from a proper
 * configuration file.
 */
public class Configuration {

    public static int getYAxisMinRange() {
        return -10;
    }

    public static int getYAxisMaxRange() {
        return 10;
    }

    public static int getXAxisMinRange() {
        return -10;
    }

    public static int getXAxisMaxRange() {
        return 10;
    }
    
    /**
     * Made a presumption that 20 would suffice.
     * @return The maximum number of tickets that will be randomly generated.
     */
    public static int maxTicketNumbers() {
        return 20;
    }
    
    /**
     * Made a presumption that 20 would suffice.
     * @return The maximum number of events that will be randomly generated.
     */
    public static int maxEventNumbers() {
        return 20;
    }

    /**
     * Made a presumption that 150 would suffice.
     * @return The maximum price of a generated ticket.
     */
    public static float maxTicketPrice() {
        return 150f;
    }
    
    public static Currency defaultCurrency() {
        return Currency.getInstance("USD");
    }
    
}
