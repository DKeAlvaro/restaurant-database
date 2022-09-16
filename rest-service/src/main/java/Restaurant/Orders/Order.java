package Restaurant.Orders;


public class Order {
    private int order_id;
    private int[] pizzas;
    private boolean takeaway;

    public int getOrderId() {
        return order_id;
    }
    public void setOrderId(int order_id) {
        this.order_id = order_id;
    }
    public void setPizzas(int[] pizzas) {
        this.pizzas = pizzas;
    }
    public int[] getPizzas() {
        return pizzas;
    }
    public void setTakeaway(boolean takeaway) {
        this.takeaway = takeaway;
    }
    public boolean isTakeaway() {
        return takeaway;
    }
}
