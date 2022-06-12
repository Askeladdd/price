package csv;

import model.Margin;
import model.Margins;
import model.Product;
import model.Products;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class MarginCsv {
    private Margins margins; //Список скидок
    String[] Headers = { "id", "category", "margin"};
    private String fileName = "src/main/java/data/margin.csv";

    public MarginCsv(Margins margins) {
        this.margins = margins;
    }

    public Margins getMargins() {
        return margins;
    }

    public void write() throws IOException {
        FileWriter out = new FileWriter(fileName);
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(Headers))) {
            margins.getMargins().stream()
                    .forEach(margin ->
                    {
                        try {
                            printer.printRecord(margin.getId(), margin.getCategory(),margin.getMargin());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    public void read() throws IOException {
        Reader in = new FileReader(fileName);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader(Headers).withSkipHeaderRecord(true).parse(in);
        margins.getMargins().clear();
        for (CSVRecord record : records) {
            margins.add(new Margin(Integer.parseInt(record.get(0)), record.get(1), Double.parseDouble(record.get(2))));
        }

       // margins.getMargins().stream().forEach(System.out::println);
    }
}
