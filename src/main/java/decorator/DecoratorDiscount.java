package decorator;

import csv.DiscountCsv;
import csv.MarginCsv;
import model.*;

import java.io.IOException;

public class DecoratorDiscount extends DecoratorMargin {
    protected Discounts discounts = new Discounts(); //Скидки

    @Override
    public void read(){
        super.read(); //С учетом наценок

        //Скидки
        DiscountCsv discountCsv = new DiscountCsv(discounts);
        try {
            discountCsv.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Товары с учетом наценок
        products.getProducts().stream().forEach(product -> subDiscount(product));
    }

    private void subDiscount(Product product){
        //Найти скидку для этого продукта
        long product_id = product.getId();
        double sum; //Сумма скидки
        Discount discount = discounts.getDiscounts().stream().filter(d->d.getProduct_id()==product_id).findFirst().orElse(null);
        if (discount==null);
        else if (discount.isPercent())
            product.setPrice(product.getPrice()*(1-discount.getDiscount()/100));
        else
            product.setPrice(product.getPrice()-discount.getDiscount());
    }
}
