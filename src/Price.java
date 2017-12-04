
import java.math.BigDecimal;
import java.util.Currency;


public final class Price {

    private BigDecimal ammount;
    private Currency currencyType;

    public Price(BigDecimal ammount, Currency currencyType) {
        setAmmount(ammount);
        this.currencyType = currencyType;
    }

    public BigDecimal getAmmount() {
        return ammount;
    }

    public void setAmmount(BigDecimal ammount) {
        if (ammount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price ammount must be positive and non-zero.");
        }
        this.ammount = ammount;
    }

    public Currency getCurrencyType() {
        return currencyType;
    }

    public void changeCurrencyType(Currency currencyType, BigDecimal newAmmount) {
        this.currencyType = currencyType;
        setAmmount(newAmmount);
    }
    
}
