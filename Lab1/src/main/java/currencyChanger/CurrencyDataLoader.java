package currencyChanger;

import java.util.List;

public interface CurrencyDataLoader {
    List <CurrencyData> loadExchangeRates();
}
