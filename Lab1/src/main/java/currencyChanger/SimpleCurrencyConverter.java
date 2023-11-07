package currencyChanger;

import java.util.List;
import java.util.Scanner;

public class SimpleCurrencyConverter implements CurrencyConverter {
    @Override
    public void convertCurrency(List<CurrencyData> currencyDataList) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Proszę wprowadzić kod waluty do przeliczenia (GBP, EUR, USD itp.): ");
            String sourceCurrencyCode = scanner.nextLine().toUpperCase(); //меняемый
            boolean sourceCurrencyValid = false;

            for (CurrencyData currencyData : currencyDataList) {
                if (currencyData.getCurrencyCode().equals(sourceCurrencyCode)){
                    sourceCurrencyValid = true;
                    break;
                }
            }
            if (!sourceCurrencyValid) {
                System.out.println("Nieprawidłowy kod waluty. Proszę podać ponownie.");
                continue;
            }


            System.out.print("Proszę wprowadzić kod waluty, na którą chcesz wymienić: ");
            String targetCurrencyCode = scanner.nextLine().toUpperCase();

            boolean targetCurrencyValid = false;
            for (CurrencyData currencyData : currencyDataList) {
                if (currencyData.getCurrencyCode().equals(targetCurrencyCode)) {
                    targetCurrencyValid = true;
                    break;
                }
            }

            if (!targetCurrencyValid) {
                System.out.println("Nieprawidłowy kod waluty. Proszę podać ponownie.");
                continue;
            }

            System.out.print("Wprowadź kwotę do przeliczenia: ");
            double amount = scanner.nextDouble();


            double sourceExchangeRate = 0.0, targetExchangeRate = 0.0;
            int sourceConversionRate = 0, targetConversionRate = 0;

            for (CurrencyData currencyData : currencyDataList) {
                if (currencyData.getCurrencyCode().equals(sourceCurrencyCode)) {
                    sourceExchangeRate = currencyData.getExchangeRate();
                    sourceConversionRate = currencyData.getConversionRate();
                }
                if(currencyData.getCurrencyCode().equals(targetCurrencyCode)) {
                    targetExchangeRate = currencyData.getExchangeRate();
                    targetConversionRate = currencyData.getConversionRate();
                }
            }

            double result = amount * ((sourceExchangeRate * targetConversionRate) / (targetExchangeRate * sourceConversionRate));
            System.out.println("Nazwa waluty 1: " + sourceCurrencyCode);
            System.out.println("Nazwa waluty 2: " + targetCurrencyCode);
            System.out.format("Wynik: %,.2f %s", result, targetCurrencyCode);

            break;
        }
    }
}

