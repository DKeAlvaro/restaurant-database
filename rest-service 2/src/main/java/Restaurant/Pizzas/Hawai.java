package Restaurant.Pizzas;

public class Hawai implements Pizza{

private final double price = 11;
private final int ID=7;
private final String name= "Hawai";
private final String[] toppings= {"Tomato", "Annanais", "Cheese", "Ham"};
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
