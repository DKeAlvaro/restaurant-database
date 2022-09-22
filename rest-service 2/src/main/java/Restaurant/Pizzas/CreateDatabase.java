package Restaurant.Pizzas;

import java.sql.*;

public class CreateDatabase{

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
        showTable("ingredients", "name");
        addIngredient(2, "caca de pajaro", 4);
        addIngredient(1, "comida para perros", 6);
        addIngredient(4, "vomito de abuela", 9);

        addPizza();
    }
    public static void addIngredient(int ID, String name, double price)throws SQLException{
        statement.execute("INSERT ingredients(id, name, price) values("+ID+", "+"'"+name+"'"+", "+price+")");
    }

    public static void showTable(String name, String field) throws SQLException {

        ResultSet res = statement.executeQuery("SELECT *  FROM "+ name);
        while (res.next()) {
            System.out.println(res.getString(field));
        }

    }



}

