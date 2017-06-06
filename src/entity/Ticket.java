package entity;

public class Ticket {
	private String Ticket_ID = "",
				Scenic_ID = "",
				Ticket_Time = "";
	public Ticket(){}
	public Ticket(String[] args){
		Ticket_ID = args[0];
		Scenic_ID = args[1];
		Ticket_Time = args[2];
	}
	public String getTicketID(){
		return Ticket_ID;
	}
	public String getScenicID(){
		return Scenic_ID;
	}
	public String getTicketTime(){
		return Ticket_Time;
	}
}
