package Java.Helper;

import Java.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static Java.Controller.*;

public class Print {
    public static void printPizzas() throws SQLException {
        ResultSet res = Controller.statement.executeQuery("select * from  pizzas");
        List<Pizza> pizzas = new ArrayList<Pizza>();
        while(res.next()){
            pizzas.add(new Pizza(res.getInt("id"),res.getString("name"),res.getDouble("price"), res.getBoolean("vegan")));
        }
        for(int i = 0 ; i<pizzas.size();i++){
            System.out.println(pizzas.get(i).toString());
        }
    }

    public static void printDesserts() throws SQLException {
        ResultSet res = Controller.statement.executeQuery("select * from desserts");
        List<Dessert> desserts = new ArrayList<Dessert>();
        while(res.next()){
            desserts.add(new Dessert(res.getInt("id"),res.getString("name"),res.getDouble("price")));
        }
        for(int i = 0; i<desserts.size();i++){
            System.out.println(desserts.get(i).toString());
        }

    }
    public static void printDrinks() throws SQLException {
        ResultSet res = Controller.statement.executeQuery("select * from drinks");
        List drinks = new ArrayList<Drink>();
        while(res.next()){
            drinks.add(new Drink(res.getInt("id"),res.getString("name"),res.getDouble("price")));
        }
        for (int i = 0; i<drinks.size(); i++){
            System.out.println(drinks.get(i).toString());
        }

    }
    public static void printOptions(){
        System.out.println(
                "If you want to order type 'order'\n "
        );
        System.out.println("If you want to exit type 'get me out'\n");
        System.out.println("if you want to cancel an order please type 'cancel'\n");
        System.out.println("If you want to get the info of a pizza type 'info'\n");
        System.out.println("If you want to see the status of your order type 'status'\n");

    }
    public static int printTableSize() throws SQLException {
        ResultSet resultSet = Controller.statement.executeQuery("select count(*) from orders");
        resultSet.next();
        int count = resultSet.getInt(1);
        return count;
    }

    public static void printPizza(int id) throws  SQLException{
        ResultSet resultSet3 = Controller.statement.executeQuery("SELECT * from pizzas where id = "+id);
        while (resultSet3.next()) {
            System.out.println("Pizza name: "+resultSet3.getString(2));
        }
        System.out.println("Ingredients: ");
        int price = 0;
        List<Integer> ingredientsID = new ArrayList<>();

                ResultSet resultSet2 = Controller.statement.executeQuery("SELECT * FROM PizzaIngredients where id = "+id+";");
        while(resultSet2.next()){
            for(int i = 1; i < 15; i++){
                if(resultSet2.getInt("" + i+ "") == 1){
                    ingredientsID.add(i);
                }
            }
            price = resultSet2.getInt("price");
        }
        for(int i : ingredientsID){
            ResultSet resultSet = Controller.statement.executeQuery("SELECT * FROM Ingredients where id = "+i+";");
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
        }
        System.out.println("Price: "+price);
        System.out.println();
    }

    /**
     * This method receives a list of items and returns the number of times an iten has been picked
     */
    public static String orderItems(List<Integer> itemsOrdered){
        List<Integer> numOfItems = new ArrayList<>();
        Collections.sort(itemsOrdered);
        int counter;
        for(int i = 0; i< itemsOrdered.size(); i++){
            if(i==itemsOrdered.size()-1){
                numOfItems.add(1);
            }else if(itemsOrdered.get(i) != itemsOrdered.get(i+1)){
                numOfItems.add(1);
            }else{
                counter = 1;
                while(i < itemsOrdered.size()-1 && itemsOrdered.get(i) ==itemsOrdered.get(i+1)){
                    counter++;
                    i++;
                }
                numOfItems.add(counter);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numOfItems.size();i++){
            sb.append(numOfItems.get(i));
            if(i < numOfItems.size()-1){
                sb.append(", ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);
        a.add(3);
        a.add(4);
        System.out.println(Print.orderItems((a)));
    }


    public static String printItemsInOrder(List<Integer> itemsOrdered){
        Collections.sort(itemsOrdered);

        List<Integer> uniqueItems = new ArrayList<>(new LinkedHashSet<>(itemsOrdered));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < uniqueItems.size(); i++){
            sb.append("`");
            sb.append(uniqueItems.get(i));
            sb.append("`");
            if(i < uniqueItems.size()-1){
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static void printStatus(int id, int custId) throws SQLException {
        boolean matchingIds = false;
        ResultSet rs2 = statement.executeQuery("select custid from orders where id = "+id);
        while (rs2.next()){
            if(rs2.getInt("custid") == custId){
                matchingIds = true;
            }
        }
        if (matchingIds) {
            ArrayList<String> items = new ArrayList<>();
            ResultSet resultSet = Controller.statement.executeQuery("SELECT COLUMN_NAME\n" +
                    "FROM INFORMATION_SCHEMA.COLUMNS\n" +
                    "WHERE TABLE_NAME = 'orderitems';");
            while (resultSet.next()) {
                items.add(resultSet.getString("COLUMN_NAME"));
            }
            System.out.println("You ordered: ");
            ResultSet resultSet2 = Controller.statement.executeQuery("SELECT * FROM orderitems where id = " + id + ";");
            String date = null;
            while (resultSet2.next()) {
                for (String item : items) {
                    if (!item.equals("date") && resultSet2.getInt(item) >= 1 && !item.equals("id")) {
                        Statement statement = con.createStatement();
                        ResultSet rs = statement.executeQuery("SELECT name FROM menu where id =" + item + ";");
                        while (rs.next()) {
                            System.out.println(+resultSet2.getInt(item) + " " + rs.getString("name"));
                        }
                    }
                    if (item.equals("date")) {
                        date = resultSet2.getString("date");
                    }
                }
            }
            resultSet = statement.executeQuery("select * from orders where id ="+id+";");
            long currDate = getIntTime();
            long orderDate = 0;
            while (resultSet.next()){
                orderDate = resultSet.getLong("date");
            }
            if(currDate < orderDate+GdelTime) {
                System.out.println("Your order will be delivered at: " + date);
            }else{
                System.out.println("Your order was delivered at: "+ date);
            }
        }else{
            System.out.println("Sorry, you didn't make that order");
        }


    }
    public static long getIntTime(){

        Date date = new Date();
        return date.getTime();

    }
    public static String getDelTime(){
        String deliveryTime;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MILLISECOND,GdelTime);
        deliveryTime = dateFormat.format(cal.getTime());
        return deliveryTime;
    }

}
