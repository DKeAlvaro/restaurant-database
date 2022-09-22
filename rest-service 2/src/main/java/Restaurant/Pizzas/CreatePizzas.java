package Restaurant.Pizzas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreatePizzas {
    public static void main(String[] args) {
        try {
            //statement.execute("INSERT people (ID, firstname) values (4, \"Boris el cagon\" )");



             //statement.execute(" insert people(id, firstName) values(7, \"elpajarorojo\")");
            while (res.next()) {
                System.out.println(res.getString("firstname"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void showTable(){
        Statement statement = con.createStatement();
        
        ResultSet res = statement.executeQuery("SELECT *  FROM people");


    }
}

