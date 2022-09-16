package Restaurant.Pizzas;
public class ProsciutoFunghi implements Pizza{

private final double priece = 15;
private final int ID=003;
private final String name= "Prosciuto Funghi";
private final String[] topings= {"Tomato", "Mushrooms", "Cheese", "Ham", "Olives"};
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
