package Restaurant.Pizzas;

public class Funghi implements Pizza {
    private final double price = 12;
    private final int ID=5;
    private final String name= "Funghi";
    private final String[] toppings= {"Funghi", "Onions", "Tomato sauce", "Cheese"};
    int a ;
    private final Boolean vegetarian= true;
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
