package decorator;

import csv.MarginCsv;
import model.Margin;
import model.Margins;
import model.Product;
import model.Products;

import java.io.IOException;
import java.util.List;

public class DecoratorMargin extends Decorator {
    protected Margins margins = new Margins(); //Наценки

    @Override
    public void read(){
        super.read(); //Базовые цены

        //Наценки
        MarginCsv marginCsv = new MarginCsv(margins);
        try {
            marginCsv.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Товары с учетом наценок
        products.getProducts().stream().forEach(product -> addMargin(product));
    }

    private void addMargin(Product product){
        //Найти наценку для категории этого продукта
        String category = product.getCategory();
        Margin margin = margins.getMargins().stream().filter(m->m.getCategory().equals(category)).findFirst().orElse(null);
        if (margin==null)
            margin = margins.getMargins().stream().filter(m->m.getCategory().equals("default")).findFirst().orElse(null);
        product.setPrice(product.getPrice()*(1+margin.getMargin()/100));
    }
}
