package Restaurant.Pizzas;

public class FourCheese implements Pizza {
    private final double price = 15;
    private final int ID=4;
    private final String name= "FourCheese";
    private final String[] toppings= {"Cheddar", "Gouda", "Blue cheese", "Dutch Cheese", "Tomato Sauce"};
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
