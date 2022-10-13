package Java.Helper;

import Java.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import static Java.Controller.con;

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

    public static void printPizza(int id) throws  SQLException{
        ArrayList<String> ingredients = new ArrayList<>();
        ResultSet resultSet = Controller.statement.executeQuery("SELECT COLUMN_NAME\n" +
                "FROM INFORMATION_SCHEMA.COLUMNS\n" +
                "WHERE TABLE_NAME = 'PizzaIngredients';");
        while(resultSet.next()){
            ingredients.add(resultSet.getString("COLUMN_NAME"));
        }
        ResultSet resultSet3 = Controller.statement.executeQuery("SELECT * from pizzas where id = "+id);
        while (resultSet3.next()) {
            System.out.println("Pizza name: "+resultSet3.getString(2));
        }
        System.out.println("Ingredients: ");



                ResultSet resultSet2 = Controller.statement.executeQuery("SELECT * FROM PizzaIngredients where id = "+id+";");
        while(resultSet2.next()){
            for(String ingredient : ingredients){
                if(resultSet2.getInt(ingredient) == 1){
                    System.out.println(ingredient);
                }
            }
        }
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
        System.out.println(Print.printItemsInOrder((a)));
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

    public static void printStatus(int id) throws SQLException {
        ArrayList<String> items = new ArrayList<>();
        ResultSet resultSet = Controller.statement.executeQuery("SELECT COLUMN_NAME\n" +
                "FROM INFORMATION_SCHEMA.COLUMNS\n" +
                "WHERE TABLE_NAME = 'orderitems';");
        while(resultSet.next()){
            items.add(resultSet.getString("COLUMN_NAME"));
        }
        System.out.println("You ordered: ");
        ResultSet resultSet2 = Controller.statement.executeQuery("SELECT * FROM orderitems where id = "+id+";");
        while(resultSet2.next()){
            for(String item : items){
                if(resultSet2.getInt(item) >= 1 && !item.equals("id")){
                    Statement statement = con.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT name FROM menu where id ="+ item+";");
                    while (rs.next()){
                        System.out.println(+resultSet2.getInt(item) +" "+ rs.getString("name"));
                    }
                }
            }
        }
    }
}
