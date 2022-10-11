package Java;

import Java.Helper.Print;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Controller {
    static int Id;
    static Connection con;
    public static Statement statement;
    public static ArrayList<Integer> discount = new ArrayList<Integer>();
    static boolean test = false;

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

    public static void insertCustOrder(int id) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Customer WHERE  id = "+id);
        String name = null;
        int phone = 0;
        String adress = null;
        while (resultSet.next()) {
            name = resultSet.getString("name");
            phone = resultSet.getInt("phonenum");
            adress = resultSet.getString("adress");

        }
        statement.execute("INSERT INTO OrdersCust VALUES ("+id+","+"'"+ name+"'"+","+phone+","+"'"+adress+"'"+")");

    }
    public static void deleteOrders(int id) throws SQLException {
        //statement.executeQuery("DELETE FROM Orders WHERE id = "+id);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders WHERE id ="+ id);
        while (resultSet.next()) {
            //long date = resultSet.getLong("date");
            if (resultSet.getLong("date") + 300000 >= getIntTime()) {
                PreparedStatement statement1 = con.prepareStatement("DELETE FROM Orders WHERE id = " + id);
                statement1.executeUpdate();
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
        }
        if (count>=10){
            System.out.println("You have a 10% discount code");
            System.out.println("Your code is : Givemea10");
        }
    }
    public static void assignOrders(int id, int order, long date) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Staff WHERE id= "+id);
        while(resultSet.next()){
            if (resultSet.getInt("orde")==0){
                //statement.execute("INSERT INTO Staff (orde, date) VALUES ("+order+","+date+")");
                PreparedStatement statement1 = con.prepareStatement("UPDATE Staff set orde = "+order+", date = "+date+" WHERE id = "+id+"");
                statement1.execute();
                test = true;
                break;
            }
            else
                System.out.println("All of our deliverers are occupied\n" +
                        "Wait a little more to place an order");
            break;
        }
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
        System.out.println(
                "If you want to order type 'order'\n "
        );
        System.out.println("If you want to exit type 'get me out'\n");
        System.out.println("if you want to cancel an order please type 'cancel'\n");
        String name;

        do {
            Scanner scanner = new Scanner(System.in);
            name = scanner.nextLine();
            if(!(name.equals("order")  || name.equals("get me out") ||  name.equals("cancel") || name.equals("status")))
                System.out.println("enter a valid command");
        } while (!(name.equals("order")  || name.equals("get me out") ||  name.equals("cancel") || name.equals("status")));

        if (name.equals("get me out")) {
            System.out.println("Thanks for visiting ");
            return;
        } else if (name.equals("order")) {
            int prods;
            do {

                System.out.println("Enter the id's of the products you desire"
                        + "\n" +
                        "type '999' whenever you are done with your order");
                Scanner prod = new Scanner(System.in);
                prods = prod.nextInt();
                if (prods >= 21 && prods <= 30)
                    discount.add(prods);
                products.add(prods);
            } while (prods != 999);
            //order.insertOrders(getId(), products.size()-1);
            insertOrders(getId(), discount.size(), getIntTime());
            insertCustOrder(getId());
            for (int i = 1; i <= 5; i++) {
                assignOrders(i, Print.printTableSize(), getIntTime());
                if (test)
                    break;
            }
            System.out.println("Your order has been created\n" +
                    "Your order will be delivered at " + getDelTime() + "\n" +
                    "Your order id is: " + Print.printTableSize());
            System.out.println("You ordered: ");
            for (int i = 0; i < products.size() - 1; i++) {
                orderedProd(products.get(i));
            }
            checkDiscounts(getId());

        } else if (name.equals("cancel")) {
            System.out.println("enter your order id to cancel your order");
            Scanner cancel = new Scanner(System.in);
            int cancelId = cancel.nextInt();
            deleteOrders(cancelId);
            //System.out.println("Your order has been cancelled succesfully");
        }
    }

    public static int getId(){
       return Id;
    }
    public static String getDelTime(){
        String deliveryTime;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE,30);
        deliveryTime = dateFormat.format(cal.getTime());
        return deliveryTime;
    }
    public static long getIntTime(){

        Date date = new Date();
        return date.getTime();

    }
}