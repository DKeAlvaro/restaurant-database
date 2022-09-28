package Restaurant.Pizzas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC{

    static Connection con;
    static Statement statement;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzaapi", "root", "Otramas2022");
            statement = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        printField("pizzas", "name");
        addIngredient(15, "", 10);

    }
    public static void addIngredient(int ID, String name, double price)throws SQLException{
        statement.execute("INSERT ingredients(id, name, price) values("+ID+", "+"'"+name+"'"+", "+price+")");
    }

    public static List<Pizza> getPizzas() throws SQLException {
        List<Pizza> pizzas = new ArrayList<>();
        ResultSet res = statement.executeQuery("SELECT *  FROM pizzas");
        while (res.next()) {
            pizzas.add(new Pizza(res.getInt("id"), res.getString("name"), res.getInt("price")));
        }
        return pizzas;

    }

    public static void printField(String name, String field) throws SQLException {

        ResultSet res = statement.executeQuery("SELECT *  FROM "+ name);
        while (res.next()) {
            System.out.println(res.getString(field));
        }

    }



}

