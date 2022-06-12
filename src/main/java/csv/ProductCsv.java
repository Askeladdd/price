package csv;

import model.Product;
import model.Products;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class ProductCsv {
    private Products products; //Список товаров
    String[] Headers = { "id", "category", "name",  "price"};
    private String fileName = "src/main/java/data/product.csv";

    public ProductCsv(Products products) {
        this.products = products;
    }

    public Products getProducts() {
        return products;
    }

    public void write() throws IOException {
        FileWriter out = new FileWriter(fileName);
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(Headers))) {
            products.getProducts().stream()
                    .forEach(product ->
                    {
                        try {
                            printer.printRecord(product.getId(), product.getCategory(),product.getName(), product.getPrice());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    public void read() throws IOException {
        Reader in = new FileReader(fileName);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader(Headers).withSkipHeaderRecord(true).parse(in);
        products.getProducts().clear();
        for (CSVRecord record : records) {
            products.add(new Product(Integer.parseInt(record.get(0)), record.get(1), record.get(2), Double.parseDouble(record.get(3))));
        }

        //products.getProducts().stream().forEach(System.out::println);
    }
}
