package Clients;

import Orders.OrdersDAO;
import Orders.OrdersDAOclass;
import Products.Products;
import Products.ProductsDAO;
import Products.ProductsDAOclass;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/orders?serverTimezone=Europe/Kiev";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "Xeraxera1997";

    public static void main(String[] args) throws SQLException {
        ConnectionFactory f = new ConnectionFactory(
                DB_CONNECTION, DB_USER, DB_PASSWORD
        );

        Connection conn = f.getConnection();
        ClientDAO dao = new ClientDAOclass(conn);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name:");
        String name = sc.nextLine();
        dao.addClient(name);

        ProductsDAO daop = new ProductsDAOclass(conn);
        daop.getAll();
        System.out.println(daop.toString());
        System.out.println("\n" +
                "Choose product name :");
        String productName = sc.nextLine();
        System.out.println("How mach :?");
        int quantity = sc.nextInt();

        Products pr = getProduct(daop.getAll(), productName,quantity);
        OrdersDAO daoo = new OrdersDAOclass(conn);
        daoo.addOrder(dao.getClient().getClientId(),pr.getProductName(),pr.getQuantity(),pr.getPrice());

        int newQuantity = getQuantity(daop.getAll(),productName,quantity);
        daop.changeQuantity(newQuantity,productName);

        System.out.println("Your order id DONE!");
    }

    public static Products getProduct(List<Products> list,String pn, int quantity){
        Products product = new Products();
        for(Products p : list){
            if(p.getProductName().equals(pn)&&p.getQuantity()>=quantity){
                product = p;
                product.setQuantity(quantity);
                return product;
            }
        }System.out.println("There is no such product or is it missing"); return null;
    }

    public static int getQuantity(List<Products> list, String pn,int q){
        int quantity = 0;
        for(Products p : list){
            if(p.getProductName().equals(pn)){
                 quantity = p.getQuantity()-q;
            }
        }return quantity;
    }

}