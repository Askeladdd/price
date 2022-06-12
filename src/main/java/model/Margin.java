package model;

import java.util.concurrent.atomic.AtomicInteger;

public class Margin {
    private long id; //Идентификатор
    private static final AtomicInteger count = new AtomicInteger(0); //Счетчик
    private String category; //Категория товара
    private double margin; //Наценка, %

    @Override
    public String toString() {
        return "Margin{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", margin=" + margin +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public double getMargin() {
        return margin;
    }

    public Margin(String category, double margin) {
        this.category = category;
        this.margin = margin;
    }

    public Margin(long id, String category, double margin) {
        this.id = id;
        this.category = category;
        this.margin = margin;
    }
}
