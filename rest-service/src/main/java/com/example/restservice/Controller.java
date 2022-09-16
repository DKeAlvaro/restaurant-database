package com.example.restservice;

import Restaurant.Menu;
import Restaurant.Orders.CancelledOrder;
import Restaurant.Orders.ListOfOrders;
import Restaurant.Orders.Order;
import Restaurant.Orders.OrderInfo;
import Restaurant.Pizzas.Pizza;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {


    @RequestMapping
    public String welcome(){
        return "Welcome to our restaurant";
    }
    @RequestMapping("/pizza")
    public List<Pizza> getPizzas(){
        return Menu.getPizzas();
    }
    @RequestMapping("/pizza/id")
    public Pizza getPizza(@RequestParam int ID){
        return Menu.getPizza(ID);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/order")
    public OrderInfo addOrder(@RequestBody Order order){
        ListOfOrders.add(order);
        return ListOfOrders.ordersInfo.get(order.getOrderId());
    }

    @RequestMapping("/order/id")
    public Order getOrder(@RequestParam int ID){
        return ListOfOrders.getOrder(ID);
    }

    @PutMapping("/order/cancel")
    public CancelledOrder cancel(@RequestParam int ID){
        return new CancelledOrder(ListOfOrders.getOrder(ID));
    }
    
}
