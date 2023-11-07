package currencyChanger;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;


public class XmlCurrencyDataLoader implements CurrencyDataLoader {
    private static XmlCurrencyDataLoader instance;
    private final String xmlUrl;

    protected XmlCurrencyDataLoader(String xmlUrl) {
        this.xmlUrl = xmlUrl;
    }

    public static XmlCurrencyDataLoader getInstance(String xmlUrl) {
        if (instance == null) {
            instance = new XmlCurrencyDataLoader(xmlUrl);
        }
        return instance;
    }

    @Override
    public List<CurrencyData> loadExchangeRates() {
        List<CurrencyData> currencyDataList = new ArrayList<>();

        try {
            URL url = new URL(xmlUrl);
            InputStream inputStream = url.openStream();

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("pozycja");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String currencyCode = element.getElementsByTagName("kod_waluty").item(0).getTextContent();
                int conversionRate = Integer.parseInt(element.getElementsByTagName("przelicznik").item(0).getTextContent());
                double exchangeRate = Double.parseDouble(element.getElementsByTagName("kurs_sredni").item(0).getTextContent().replace(",", "."));
                currencyDataList.add(new CurrencyData(currencyCode, exchangeRate, conversionRate));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return currencyDataList;
    }
}

