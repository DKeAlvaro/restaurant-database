package Restaurant.Pizzas;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Order {
    private int order_id;
    private int custId;
    private String date;
    private static String status = "in progress";
    private String deliveryTime;

    static Connection con;
    static Statement statement;
    public static ArrayList products = new ArrayList();

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PizzaAPI", "root", "Cooper03");
            statement = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int printTableSize() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select count(*) from orders");
        resultSet.next();
        int count = resultSet.getInt(1);
        return count;
    }

    public void insertOrders(int id, int size) throws SQLException {
        String times = getDelTime();
        statement.execute("insert into orders values(printTableSize()+1,times ,status,id,size)");
    }
    public static String getDelTime(){
        String deliveryTime;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE,30);
        deliveryTime = dateFormat.format(cal.getTime());
        return deliveryTime;
    }




//    public Order(){
//        this.order_id = getOrder_id();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Calendar cal = Calendar.getInstance();
//
//        this.date = dateFormat.format(cal.getTime());
//        cal.add(Calendar.MINUTE,30);
//        this.deliveryTime = dateFormat.format(cal.getTime());
//
//
//    }
    public String getDate() {
        return date;
    }
    public String getDeliveryTime() {
        return deliveryTime;
    }
    public int getOrder_id() {
        return order_id;
    }
    public void setCustId(int custId ){
        this.custId = custId;
    }
}
