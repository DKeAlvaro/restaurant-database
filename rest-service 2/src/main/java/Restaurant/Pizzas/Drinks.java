package Restaurant.Pizzas;

public class Drinks {
    private final double price;
    private final int id;
    private final String name;

    public Drinks(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return "id:"+getId()  + " "+getName()+ " price:"+ getPrice();
    }
}
