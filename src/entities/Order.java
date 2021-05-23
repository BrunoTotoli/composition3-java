package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Order {
	private Date moment ;
	private OrderStatus status;
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	private Client client;
	public Order() {
	}

	public Order(OrderStatus status, Client client) {
		this.status = status;
		this.client = client;
		this.moment = new Date(System.currentTimeMillis());
	}

	public void addItem(OrderItem item) {
		orderItems.add(item);
	}

	public void removeItem(OrderItem item) {
		orderItems.remove(item);
	}

	public Double total() {
		double totalItems = 0;
		for (OrderItem orderItem : orderItems) {
			totalItems += orderItem.subTotal();
		}
		return totalItems;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	
	
	

}
