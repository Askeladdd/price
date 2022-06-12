package model;

import java.util.LinkedList;

public class Discounts {
    private LinkedList<Discount> discounts = new LinkedList<>(); //Список скидок

    public LinkedList<Discount> getDiscounts() {
        return discounts;
    }
    public void add(Discount discount){
        discounts.add(discount);
    }

    public void remove(Discount discount){
        discounts.remove(discount);
    }

    public Discount getById(int id){
        Discount result = null;
        result = discounts.stream().filter(margin->margin.getId()==id).findFirst().get();
        return result;
    }
}
