package Restaurant.Pizzas;

public class Ham implements Pizza{
    private final double price = 12;
    private final int ID=11;
    private final String name= "Ham";
    private final String[] topings= {"Ham", "Onions", "Cheese", "Tomato Sauce"};
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
        return topings;
    }
}
