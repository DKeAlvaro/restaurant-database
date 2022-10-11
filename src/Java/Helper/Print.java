package Java.Helper;

import Java.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public static int printTableSize() throws SQLException {
        ResultSet resultSet = Controller.statement.executeQuery("select count(*) from orders");
        resultSet.next();
        int count = resultSet.getInt(1);
        return count;
    }
}
