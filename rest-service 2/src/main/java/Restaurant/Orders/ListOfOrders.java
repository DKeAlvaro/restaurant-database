package Restaurant.Orders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListOfOrders {
    public static List<Order> orders;
    public static List<CancelledOrder> cancelledOrders;
    public static HashMap<Integer, OrderInfo> ordersInfo = new HashMap<Integer, OrderInfo>();
    public static HashMap<Integer, Order> ordersMap = new HashMap<Integer, Order>();

    public static int currentOrder; 

    public static List<Order> getOrders() {
        return orders;
    }

    public static Order getOrder(int orderID){
        return ordersMap.get(orderID);
    }

    public static void add(Order order){
        if(orders == null){
            currentOrder = 0;
            orders = new ArrayList<Order>();
        }
        order.setOrderId(currentOrder);
        orders.add(order);
        ordersInfo.put(currentOrder, new OrderInfo(order));
        ordersMap.put(currentOrder, order);
        currentOrder++;
    }

    public static void addCancelledOrder(Order order){
        
    }
}
