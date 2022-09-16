package Restaurant.Pizzas;

public class Diavola implements Pizza{

    private final double priece = 16.5;
    private final int ID=004;
    private final String name= "Diavola";
    private final String[] topings= {"Tomato", "Peperoni", "Cheese", "Salami"};
    private final Boolean vegetarian=false;
    @Override
    public double getPrice() { 
        return priece;
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