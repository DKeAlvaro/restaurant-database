package Java;

import Java.Helper.Print;

import java.security.PublicKey;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.stream.Collectors;

import static Java.Helper.Print.*;

public class Controller {
    static int Id;
    public static Connection con;
    public static Statement statement;
    public static ArrayList<Integer> discount = new ArrayList<Integer>();
    static boolean test = false;
    public static int GdelTime = 300000; //5 minutes
    public static boolean finished = false;

    public static ArrayList <Integer>products = new ArrayList<Integer>();

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzaapi", "root", "Otramas2022");
            statement = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        controller();
    }


    public static void insertOrders(int id, int size, long date) throws SQLException {
        String statuss = "in progress";
        int taman = size;
        int sizes = Print.printTableSize()+1;
        statement.execute("insert into orders values("+sizes+","+"'" + getDelTime() + "'"+" ,'in progress',"+"'"+id+"'"+","+taman+", "+ date+")");
    }

    public static void deleteOrders(int id) throws SQLException {
        //statement.executeQuery("DELETE FROM Orders WHERE id = "+id);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders WHERE id ="+ id);
        while (resultSet.next()) {
            //long date = resultSet.getLong("date");
            if (resultSet.getLong("date") + 300000 >= getIntTime()) {
                PreparedStatement statement1 = con.prepareStatement("DELETE FROM Orders WHERE id = " + id);
                statement1.executeUpdate();
                PreparedStatement statement2 = con.prepareStatement("DELETE FROM OrdersCust WHERE orderid = " + id);
                statement2.executeUpdate();
                PreparedStatement statement3 = con.prepareStatement("DELETE FROM OrderItems WHERE id = " + id);
                statement3.executeUpdate();
                PreparedStatement statement4 = con.prepareStatement("UPDATE Staff set orde="+0+", date = "+0+" WHERE orde = "+id+";");
                statement4.execute();
                System.out.println("Your order has been cancelled");
            }
            else{
                System.out.println("\nYour order cannot be cancelled because more than five minutes have elapsed");
            }

        }

    }
    public static void orderedProd(int id) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Menu WHERE id ="+id);
        String name = null;
        while (resultSet.next()){
            name = resultSet.getString("name");
            System.out.println(name);
        }
    }
    public static void checkDiscounts(int id ) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders WHERE custid = "+id);
        int count = 0;
        while (resultSet.next()){
            count += resultSet.getInt("pizzas");
           // System.out.println(count);
        }
        if (count >= 10){
            System.out.println("You have a 10% discount code");
            System.out.println("Your code is : Givemea10");
        }
    }
    public static void assignOrders(int id, int order, long date) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Staff WHERE id= "+id);
        while(resultSet.next()){
                //statement.execute("INSERT INTO Staff (orde, date) VALUES ("+order+","+date+")");
                PreparedStatement statement1 = con.prepareStatement("UPDATE Staff set orde = "+order+", date = "+date+" WHERE id = "+id+";");
                statement1.execute();
                test = true;
                break;
//            else
//                System.out.println("All of our deliverers are occupied\n" +
//                        "Wait a little more to place an order");
//            return;
        }
    }
    public static boolean availability(int i) throws SQLException {

        long currDate = getIntTime();
        long deliveryTime = GdelTime; //time to deliver an order
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Staff WHERE id= " + i);
        while (resultSet.next()) {
            if (resultSet.getInt("orde") == 0) {
                return true;
            } else {
                if(currDate - resultSet.getLong("date") > deliveryTime){
                    PreparedStatement st = con.prepareStatement("UPDATE stafF set orde = 0 where id = " + i+";");
                    st.execute();
                    return true;
                }
            }
        }

        return false;
    }

    public static void controller() throws SQLException {
        do {
            System.out.println("Enter your customer id");
            Scanner id = new Scanner(System.in);
            Id = id.nextInt();
            if (Id <= 0 || Id >= 4)
                System.out.println("Enter a valid id");

        } while ((Id <= 0 || Id >= 4));

        System.out.println("Welcome to our Menu");
        System.out.println("Pizzas:");
        Print.printPizzas();
        System.out.println();
        System.out.println("Desserts:");
        Print.printDesserts();
        System.out.println();
        System.out.println("Drinks:");
        Print.printDrinks();
        System.out.println();
        printOptions();
        String name;

        do {
            Scanner scanner = new Scanner(System.in);
            name = scanner.nextLine();
            if(!(name.equals("order")  || name.equals("get me out") ||  name.equals("cancel") || name.equals("status") || name.equals("info")))
                System.out.println("enter a valid command");
        } while (!(name.equals("order")  || name.equals("get me out") ||  name.equals("cancel") || name.equals("status") || name.equals("info")));

        do {
            if (name.equals("get me out")) {
                System.out.println("Thanks for visiting ");
                return;
            } else if (name.equals("order")) {
                int prods;
                List<Integer> productIDs = new ArrayList<>();
                do {

                    System.out.println("Enter the id's of the products you desire"
                            + "\n" +
                            "type '999' whenever you are done with your order");

                    Scanner prod = new Scanner(System.in);
                    prods = prod.nextInt();
                    if (prods >= 21 && prods <= 30) {
                        discount.add(prods);
                    }
                    if (14 < prods && prods < 31) {
                        productIDs.add(prods);
                        products.add(prods);

                    }
                } while (prods != 999);
                //order.insertOrders(getId(), products.size()-1);
                //insertCustOrder(Print.printTableSize(),getId());
                for (int i = 1; i <= 3; i++) {
                    if (availability(i)) {
                        assignOrders(i, Print.printTableSize()+1, getIntTime());
                        insertOrders(getId(), discount.size(), getIntTime());
                        if (test)
                            break;
                    } else if (i == 3) {
                        System.out.println("All of our deliverers are occupied\n" +
                                "Wait a little longer");
                        return;
                    }
                }
                System.out.println("Your order has been created\n" +
                        "Your order will be delivered at " + getDelTime() + "\n" +
                        "Your order id is: " + Print.printTableSize());

                System.out.println("You ordered: ");
                for (int i = 0; i < products.size(); i++) {
                    orderedProd(products.get(i));
                }
                checkDiscounts(getId());

                System.out.println();
                Controller.statement.executeUpdate("Insert into orderitems (id, date, " + Print.printItemsInOrder(productIDs) + ") values (" + Print.printTableSize() + "," + "'" + getDelTime() + "'" + ", " + Print.orderItems(productIDs) + ");");
                finished = true;

            } else if (name.equals("cancel")) {
                System.out.println("enter your order id to cancel your order");
                Scanner cancel = new Scanner(System.in);
                int cancelId = cancel.nextInt();
                deleteOrders(cancelId);
                finished = true;

            } else if (name.equals("info")) {
                System.out.println("enter the id of the pizza to check the info");
                Scanner scan = new Scanner(System.in);
                int pizzaId = scan.nextInt();
                Print.printPizza(pizzaId);
                printOptions();
                System.out.println();
                do {
                    Scanner scanner = new Scanner(System.in);
                    name = scanner.nextLine();
                    if(!(name.equals("order")  || name.equals("get me out") ||  name.equals("cancel") || name.equals("status") || name.equals("info")))
                        System.out.println("enter a valid command");
                } while (!(name.equals("order")  || name.equals("get me out") ||  name.equals("cancel") || name.equals("status") || name.equals("info")));

            } else {
                System.out.println("enter your order id");
                Scanner scan = new Scanner(System.in);
                int orderid = scan.nextInt();
                Print.printStatus(orderid, Id);
                finished = true;

            }
        }while(!finished);
    }

    public static int getId(){
        return Id;
    }

}