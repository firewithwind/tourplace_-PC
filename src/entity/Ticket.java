package entity;

public class Ticket {
	private String Ticket_ID = "",
				Ticket_Time = "",
				Ticket_Price = "",
				User_ID2 = "",
				Scenic_Name = "",
				Ticket_Count;
	public Ticket(){}
	public Ticket(String[] args){
		Ticket_ID = args[0];
		Ticket_Time = args[1];
		Ticket_Price = args[2];
		User_ID2 = args[3];
		Ticket_Count = args[4];
	}
	public String getTicketCount(){
		return Ticket_Count;
	}
	public String getTicketID(){
		return Ticket_ID;
	}
	public String getTicketTime(){
		return Ticket_Time;
	}
	public String getTicketPrice(){
		return Ticket_Price;
	}
	public String getUser(){
		return User_ID2;
	}
	public void setScenicName(String name){
		Scenic_Name = name;
	}
	public String getScenicName(){
		return Scenic_Name;
	}
}
