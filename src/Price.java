
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * A class to represent a Price
 *
 * @author Adam
 */
public final class Price implements Comparable<Price> {

    //Used BigDecimal to represent currency due to float and double precision issues.
    //See: stackoverflow.com/questions/3730019
    private BigDecimal ammount;
    private final char currencySymbol;

    /**
     * Creates a Price object with the given parameters.
     *
     * @param ammount The value of this price.
     * @param currencySymbol The symbol of the currency this price is expressed
     * in.
     */
    public Price(BigDecimal ammount, char currencySymbol) {
        setAmmount(ammount);
        this.currencySymbol = currencySymbol;
    }

    /**
     *
     * @return The value of this price.
     */
    public BigDecimal getAmmount() {
        return ammount;
    }

    /**
     * Sets the value of this price.
     *
     * @param ammount A BigDecimal object which represents the value of this
     * price which must be positive and non-zero.
     */
    public void setAmmount(BigDecimal ammount) {
        if (ammount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price ammount must be positive and non-zero.");
        }
        //Rounds to 2dp represent currency.
        this.ammount = ammount.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return Character.toString(currencySymbol) + ammount;
    }

    @Override
    public int compareTo(Price p) {
        return ammount.compareTo(p.getAmmount());
    }

}
