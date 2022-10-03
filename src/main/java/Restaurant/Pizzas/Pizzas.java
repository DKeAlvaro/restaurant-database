package Restaurant.Pizzas;

import java.util.ArrayList;

public class Pizzas {

    private final double price;
    private final int id;
    private final String name;

    private boolean vegan;

    public Pizzas(int id, String name, double price, boolean vegan) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.vegan = vegan;
    }


    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    public boolean getVegan(){
        return vegan;
    }
    @Override
    public String toString(){
        return "id:"+ getId()  + " "+getName()+ " price:"+ getPrice() + " vegan:"+ getVegan() ;
    }
}