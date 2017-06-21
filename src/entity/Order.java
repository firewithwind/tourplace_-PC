package entity;

public class Order {
	private String order_ID = "",
			scenic_Name = "",
			order_Time = "",
			order_Count = "",
			order_Price = "",
			ticket_Time = "";
	public Order shift = null;
	public Order(){}
	public Order(String[] args){
		order_ID = args[0];
		scenic_Name = args[1];
		order_Time = args[2];
		order_Count = args[3];
		order_Price = args[4];
		ticket_Time = args[5];
	}
	public String getOrderID(){
		return order_ID;
	}
	public String getScenicName(){
		return scenic_Name;
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
	public String getTicketTime(){
		return ticket_Time;
	}
}
