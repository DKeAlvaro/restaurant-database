package Restaurant.Pizzas;

import java.util.ArrayList;

public class Pizza {

    private final int price;
    private final int id;
    private final String name;

    public Pizza(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}
