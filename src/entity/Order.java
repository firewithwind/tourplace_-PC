package entity;

public class Order {
	private String order_ID = "",
			ticket_ID = "",
			order_Time = "",
			order_Count = "",
			order_Price = "";
	public Order(){}
	public Order(String[] args){
		order_ID = args[0];
		ticket_ID = args[1];
		order_Time = args[2];
		order_Count = args[3];
		order_Price = args[4];
	}
	public String getOrderID(){
		return order_ID;
	}
	public String getTicketID(){
		return ticket_ID;
	}
	public String getOrderTime(){
		return order_Time;
	}
	public String getOrderCount(){
		return order_Count;
	}
	public String getOrderPrice(){
		return order_Price;
	}
}
