package currencyChanger;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        CurrencyDataLoader dataLoader = XmlCurrencyDataLoader.getInstance("https://www.nbp.pl/kursy/xml/lasta.xml");
        List<CurrencyData> currencyDataList = dataLoader.loadExchangeRates();
        CurrencyConverter converter = new SimpleCurrencyConverter();
        converter.convertCurrency(currencyDataList);
    }
}
