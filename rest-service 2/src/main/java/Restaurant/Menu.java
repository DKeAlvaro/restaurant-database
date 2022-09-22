package Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Restaurant.Pizzas.Diavola;
import Restaurant.Pizzas.Hawai;
import Restaurant.Pizzas.Margherita;
import Restaurant.Pizzas.Pizza;
import Restaurant.Pizzas.ProsciutoFunghi;

public class Menu {
    public static HashMap<Integer, Pizza> pizzas = new HashMap<Integer, Pizza>();

    public static List<Pizza> setPizzas() {
        List<Pizza> Pizzas = new ArrayList<Pizza>();
        Pizzas.add(new Hawai());
        pizzas.put(001, new Margherita());

        Pizzas.add(new Margherita());
        pizzas.put(002, new Hawai());

        Pizzas.add(new ProsciutoFunghi());
        pizzas.put(003, new ProsciutoFunghi());

        Pizzas.add(new Diavola());
        pizzas.put(004, new Diavola());

        return Pizzas;
    }

    

    public static List<Pizza> getPizzas() {
        return setPizzas();
    }
    public static Pizza getPizza(int ID){
        return pizzas.get(ID);
    }
}
