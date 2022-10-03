package Restaurant.Pizzas;

public class Chicken implements Pizza{

    private final double price = 9;
    private final int ID=2;
    private final String name= "Chicken";
    private final String[] toppings= {"Chicken", "Tomato", "Cheese"};

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