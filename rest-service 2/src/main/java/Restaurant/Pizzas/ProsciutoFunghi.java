package Restaurant.Pizzas;
public class ProsciutoFunghi implements Pizza{

private final double price = 15;
private final int ID=10;
private final String name= "Prosciuto Funghi";
private final String[] toppings= {"Tomato", "Mushrooms", "Cheese", "Ham", "Olives"};
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
