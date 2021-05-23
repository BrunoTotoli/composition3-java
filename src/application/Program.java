package application;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.OrderStatus;
import entities.Product;

public class Program {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Scanner in = new Scanner(System.in);
		System.out.println("Enter client data: ");
		System.out.println("Name: ");
		String name = in.next();
		System.out.println("Email: ");
		String email = in.next();
		System.out.println("Birth Date (DD/MM/YYYY): ");
		String date = in.next();
		Client client = new Client(name,email, date);
		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		String status = in.next();
		Order order = new Order(OrderStatus.valueOf(status),client);
		System.out.println("How many items to this order? ");
		int items = in.nextInt();
		for(int i = 0; i<items;i++) {
			System.out.println("Enter #"+(i+1)+" item data:");
			System.out.println("Product name: ");
			String itemName = in.next();
			System.out.println("Product price: ");
			double itemPrice = in.nextDouble();
			System.out.println("Quantity: ");
			int quantity = in.nextInt();
			Product product = new Product(itemName,itemPrice);
			OrderItem orderItem = new OrderItem(quantity, itemPrice, product);
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMMARY: ");
		System.out.println("Order moment: "+sdf.format(order.getMoment()));
		System.out.println("Order Status: "+order.getStatus());
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Client: "+order.getClient().getName()+" ("+sdf.format(order.getClient().getBirthDate())+") - "
		+order.getClient().getEmail());
		System.out.println("Order items: ");
		for(int i = 0; i < order.getOrderItems().size();i++) {
			OrderItem orderItem = order.getOrderItems().get(i);
			System.out.println(orderItem.getProduct().getName()+", $"+orderItem.getPrice()+ ", Quantity: "+orderItem.getQuantity(
					)+", Subtotal: "+orderItem.subTotal());
		}
		System.out.println("Total price: $"+order.total());
	}
}
