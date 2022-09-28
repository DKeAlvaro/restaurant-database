package Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Restaurant.Pizzas.Pizza;

public class Menu {
    public static HashMap<Integer, Pizza> pizzas = new HashMap<Integer, Pizza>();



    
    public static Pizza getPizza(int ID){
        return pizzas.get(ID);
    }
}
