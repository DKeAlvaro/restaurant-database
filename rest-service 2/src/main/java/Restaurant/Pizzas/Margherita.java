package Restaurant.Pizzas;

public class Margherita implements Pizza {

private final double price = 12;
private final int ID=8;
private final String name= "Margherita";
private final String[] toppings= {"Tomato", "Cheese", "Herbs"};
private final Boolean vegetarian=true;

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
