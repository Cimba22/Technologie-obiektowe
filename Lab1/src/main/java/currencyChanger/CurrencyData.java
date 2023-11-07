package currencyChanger;

public class CurrencyData {
    private String CurrencyCode;
    private double exchangeRate;
    private int ConversionRate;

    public CurrencyData(String currencyCode, double exchangeRate, int conversionRate) {
        CurrencyCode = currencyCode;
        this.exchangeRate = exchangeRate;
        ConversionRate = conversionRate;
    }

    public String getCurrencyCode() {
        return CurrencyCode;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public int getConversionRate() {
        return ConversionRate;
    }

}
