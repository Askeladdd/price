package model;

import java.util.LinkedList;

public class Margins {
    private LinkedList<Margin> margins = new LinkedList<>(); //Список товаров

    public LinkedList<Margin> getMargins() {
        return margins;
    }
    public void add(Margin margin){
        margins.add(margin);
    }

    public void remove(Margin margin){
        margins.remove(margin);
    }

    public Margin getById(int id){
        Margin result = null;
        result = margins.stream().filter(margin->margin.getId()==id).findFirst().get();
        return result;
    }
}
