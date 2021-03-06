package org.javacream.books.order.api;

import java.io.Serializable;

public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String isbn;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (amount != other.amount)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (status != other.status)
			return false;
		if (Double.doubleToLongBits(totalPrice) != Double.doubleToLongBits(other.totalPrice))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Order [isbn=" + isbn + ", totalPrice=" + totalPrice + ", status=" + status + ", amount=" + amount + "]";
	}



	public String getIsbn() {
		return isbn;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public int getAmount() {
		return amount;
	}


	public Order(String isbn, double totalPrice, OrderStatus status, int amount) {
		super();
		this.isbn = isbn;
		this.totalPrice = totalPrice;
		this.status = status;
		this.amount = amount;
	}


	private double totalPrice;
	private OrderStatus status;
	private int amount;
	
	
	public static enum OrderStatus{
		OK, PENDING, UNACCEPTABLE;
	}
}
