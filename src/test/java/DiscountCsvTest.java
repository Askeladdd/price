import csv.DiscountCsv;
import csv.MarginCsv;
import model.Discounts;
import model.Margins;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class DiscountCsvTest {

    @Test
    void read() {
        Discounts discounts = new Discounts();
        DiscountCsv discountCsv = new DiscountCsv(discounts);
        try {
            discountCsv.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        discounts.getDiscounts().stream().forEach(System.out::println);
    }
}