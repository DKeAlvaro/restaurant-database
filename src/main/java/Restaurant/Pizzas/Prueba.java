package Restaurant.Pizzas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Prueba {

    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "Cooper03");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from actor");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("actor_id"));

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
