package Restaurant.Pizzas;

public class Barbeque implements Pizza{
    private final double price = 11;
    private final int ID= 1;
    private final String name= "Diavola";
    private final String[] toppings= {"Tomato", "Barbeque Sauce", "Chicken", "Cheese"};
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
