package Restaurant.Pizzas;

public class Hawai implements Pizza{

private final double priece = 17;
private final int ID=002;
private final String name= "Hawai";
private final String[] topings= {"Tomato", "Ananas", "Cheese", "Ham"};
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
