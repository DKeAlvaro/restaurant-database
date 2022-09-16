package Restaurant.Pizzas;

public class Margherita implements Pizza {

private final double priece = 12;
private final int ID=001;
private final String name= "Margherita";
private final String[] topings= {"Tomato", "Cheese"};
private final Boolean vegetarian=true;

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
