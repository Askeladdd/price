package decorator;

import csv.ProductCsv;
import model.Products;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Decorator {
    protected Products products = new Products(); //Товары
    protected List<String> categories = null; //Категории

    //Прочитать базовую стоимость товаров
    public void read(){
        ProductCsv productsCsv = new ProductCsv(products);
        try {
            productsCsv.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        categories = products.getProducts().stream()
                .map(product -> product.getCategory())
                .distinct()
                .collect(Collectors.toList());

        //categories.forEach(System.out::println);
    }

    public void print(){
        String header = "Название\t Категория\t Цена";
        System.out.println(header);
        products.getProducts().stream().forEach(product ->
                System.out.printf("%s\t\t %s\t %.2f%n",product.getName(),product.getCategory(),product.getPrice()));
    }
}
