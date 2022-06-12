package model;

import java.util.concurrent.atomic.AtomicInteger;

public class Discount {
    private long id; //Идентификатор
    private static final AtomicInteger count = new AtomicInteger(0); //Счетчик
    private long product_id; //Продукт
    private double discount; //Скидка, % или руб.
    private boolean isPercent; //В %

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", discount=" + discount +
                ", isPercent=" + isPercent +
                '}';
    }

    public long getId() {
        return id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public double getDiscount() {
        return discount;
    }

    public boolean isPercent() {
        return isPercent;
    }

    public Discount(long product_id, double discount, boolean isPercent) {
        this.product_id = product_id;
        this.discount = discount;
        this.isPercent = isPercent;
    }

    public Discount(long id, long product_id, double discount, boolean isPercent) {
        this.id = id;
        this.product_id = product_id;
        this.discount = discount;
        this.isPercent = isPercent;
    }
}
