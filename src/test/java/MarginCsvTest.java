import csv.MarginCsv;
import csv.ProductCsv;
import model.Margins;
import model.Products;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class MarginCsvTest {

    @Test
    void read() {
        Margins margins = new Margins();
        MarginCsv marginCsv = new MarginCsv(margins);
        try {
            marginCsv.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        margins.getMargins().stream().forEach(System.out::println);
    }
}