package model;

import java.util.LinkedList;

public class Products {
    private LinkedList<Product> products = new LinkedList<>(); //Список товаров

    public LinkedList<Product> getProducts() {
        return products;
    }
    public void add(Product product){
        products.add(product);
    }

    public void remove(Product product){
        products.remove(product);
    }

    public Product getById(int id){
        Product result = null;
        result = products.stream().filter(product->product.getId()==id).findFirst().get();
        return result;
    }
}
