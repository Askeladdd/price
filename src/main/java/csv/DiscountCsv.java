package csv;

import model.Discount;
import model.Discounts;
import model.Margin;
import model.Margins;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class DiscountCsv {
    private Discounts discounts; //Список скидок
    String[] Headers = { "id", "product_id", "discount","isPercent"};
    private String fileName = "src/main/java/data/discount.csv";

    public DiscountCsv(Discounts discounts) {
        this.discounts = discounts;
    }

    public Discounts getDiscounts() {
        return discounts;
    }

    public void write() throws IOException {
        FileWriter out = new FileWriter(fileName);
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(Headers))) {
            discounts.getDiscounts().stream()
                    .forEach(discount ->
                    {
                        try {
                            printer.printRecord(discount.getId(), discount.getProduct_id(),discount.getDiscount(),discount.isPercent());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    public void read() throws IOException {
        Reader in = new FileReader(fileName);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader(Headers).withSkipHeaderRecord(true).parse(in);
        discounts.getDiscounts().clear();
        for (CSVRecord record : records) {
            discounts.add(new Discount(Integer.parseInt(record.get(0)), Integer.parseInt(record.get(1)),
                    Double.parseDouble(record.get(2)),Boolean.parseBoolean(record.get(3))));
        }

       // discounts.getDiscounts().stream().forEach(System.out::println);
    }
}
