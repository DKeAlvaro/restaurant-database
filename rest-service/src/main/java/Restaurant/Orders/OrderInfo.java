package Restaurant.Orders;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OrderInfo{
    private int order_id;
    private String date;
    private String deliveryTime;

    public OrderInfo(Order order){
        this.order_id = order.getOrderId();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        this.date = dateFormat.format(cal.getTime());
        cal.add(Calendar.MINUTE,30);
        this.deliveryTime = dateFormat.format(cal.getTime());
        

    }
    public String getDate() {
        return date;
    }
    public String getDeliveryTime() {
        return deliveryTime;
    }
    public int getOrder_id() {
        return order_id;
    }
}