package Restaurant.Pizzas;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.restservice.Controller;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class CreatePizzas {
    static int Id;
    //static ArrayList order = new ArrayList();
    static Connection con;
    static Statement statement;
    static Order order = new Order();
    public static ArrayList discount = new ArrayList();
    static boolean test = false;

    public static ArrayList <Integer>products = new ArrayList();

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PizzaAPI", "root", "Cooper03");
            statement = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        //printField("Pizzas", "id");
        controller();
//        printPizzas();
//        printDesserts();
//        printDrinks();
       // System.out.println(order);
    }

    public static void addIngredient(int ID, String name, double price) throws SQLException {
        statement.execute("INSERT ingredients(id, name, price) values(" + ID + ", " + "'" + name + "'" + ", " + price + ")");
    }

    public static void printField(String name, String field) throws SQLException {

        ResultSet res = statement.executeQuery("SELECT *  FROM " + name);
        while (res.next()) {
            System.out.println(res.getString(field));
        }
    }
    public static void printPizzas() throws SQLException {
        ResultSet res = statement.executeQuery("select * from  pizzas");
        HashMap hm = new HashMap<>();
        List pizzas = new ArrayList<Pizzas>();
        while(res.next()){
            pizzas.add(new Pizzas(res.getInt("id"),res.getString("name"),res.getDouble("price"), res.getBoolean("vegan")));
        }
        for(int i = 0 ; i<pizzas.size();i++){
            System.out.println(pizzas.get(i).toString());
        }

    }
    public static void printDesserts() throws SQLException {
        ResultSet res = statement.executeQuery("select * from desserts");
        List desserts = new ArrayList<Desserts>();
        while(res.next()){
            desserts.add(new Desserts(res.getInt("id"),res.getString("name"),res.getDouble("price")));
        }
        for(int i = 0; i<desserts.size();i++){
            System.out.println(desserts.get(i).toString());
        }

    }
    public static void printDrinks() throws SQLException {
        ResultSet res = statement.executeQuery("select * from drinks");
        List drinks = new ArrayList<Drinks>();
        while(res.next()){
            drinks.add(new Drinks(res.getInt("id"),res.getString("name"),res.getDouble("price")));
        }
        for (int i = 0; i<drinks.size(); i++){
            System.out.println(drinks.get(i).toString());
        }

    }
    public static int printTableSize() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select count(*) from orders");
        resultSet.next();
        int count = resultSet.getInt(1);
        return count;
    }
    public static void insertOrders(int id, int size, long date) throws SQLException {
        String statuss = "in progress";
        int taman = size;
        int sizes = printTableSize()+1;
        statement.execute("insert into orders values("+sizes+","+"'" + getDelTime() + "'"+" ,'in progress',"+"'"+id+"'"+","+taman+", "+ date+")");
        //statement.execute("insert into orders values("+sizes+","+ getDelTime() +" ,'in progress',"+"'"+id+"'"+","+taman+")");
        //statement.execute("insert into orders values(1,'hoy' ,'in progress',1,4)");
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
        System.out.println("Enter your customer id");
        Scanner id = new Scanner(System.in);
        Id = id.nextInt();
        if (Id < 0 || Id > 4)
            System.out.println("Enter a valid id");
        else
        System.out.println("Welcome to our Menu");
        System.out.println("Pizzas:");
            printPizzas();
        System.out.println("\n");
        System.out.println("Desserts:");
        printDesserts();
        System.out.println("\n");
        System.out.println("Drinks:");
        printDrinks();
        System.out.println("\n");
        System.out.println(
                "If you want to order type 'order'\n "
        );
        System.out.println( "If you want to exit type 'get me out'\n");
        System.out.println("if you want to cancel an order please type 'cancel'\n");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
            //name = scanner.nextLine();
            if (name.equals("get me out")) {
                System.out.println("Thanks for visitting ");
                return;
            }
                else if (name.equals("order")) {
                    int prods;
                    do {

                        System.out.println("Enter the id's of the products you desire"
                                + "\n" +
                                "type '999' whenever you are done with your order");
                        Scanner prod = new Scanner(System.in);
                        prods = prod.nextInt();
                        if(prods>=21 && prods<=30)
                            discount.add(prods);
                        products.add(prods);
                    } while (prods != 999);
                    //order.insertOrders(getId(), products.size()-1);
                    insertOrders(getId(),discount.size(), getIntTime());
                    insertCustOrder(getId());
                    for(int i = 1; i<=5; i++){
                        assignOrders(i,printTableSize(),getIntTime());
                        if(test)
                            break;
                }
                    System.out.println("Your order has been created\n" +
                            "Your order will be delivered at "+ getDelTime()+ "\n"+
                    "Your order id is: "+ printTableSize());
                    System.out.println("You ordered: ");
                    for(int i = 0; i<products.size()-1;i++){
                        orderedProd(products.get(i));
                    }
                    checkDiscounts(getId());

                } else if (name.equals("cancel")) {
                    System.out.println("enter your order id to cancel your order");
                    Scanner cancel = new Scanner(System.in);
                    int cancelId = cancel.nextInt();
                    deleteOrders(cancelId);
                    //System.out.println("Your order has been cancelled succesfully");
            } else {
                System.out.println("Enter a valid command");
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



