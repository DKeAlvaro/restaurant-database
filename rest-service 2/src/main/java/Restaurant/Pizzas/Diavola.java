package Restaurant.Pizzas;

public class Diavola implements Pizza{

    private final double price = 14;
    private final int ID=3;
    private final String name= "Diavola";
    private final String[] toppings= {"Tomato", "Peperoni", "Cheese", "Salami"};
    int a ;
    private final Boolean vegetarian=false;
    @Override
    public double getPrice() { 
        return price;
    }
    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }
    @Override
    public int getID() {
        return ID;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String[] getToppings() {
        return toppings;
    }
}