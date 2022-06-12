import csv.ProductCsv;
import model.Products;
import org.junit.jupiter.api.Test;
import java.io.IOException;

class ProductCsvTest {

    @Test
    void read() {
        Products products = new Products();
        ProductCsv productsCsv = new ProductCsv(products);
        try {
            productsCsv.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        products.getProducts().stream().forEach(System.out::println);
    }


}