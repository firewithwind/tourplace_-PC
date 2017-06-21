package entity;

public class Scenic {
	private String scenic_ID = "",
				scenic_Name = "",
				scenic_Picture = "",
				scenic_Intro = "",
				scenic_Adress = "",
				scenic_Level = "",
				scenic_Type = "",
				scenic_Video = "",
				scenic_Phone = "";
	public Scenic next = null;
	public Scenic(String id,String name){
		scenic_ID = id;
		scenic_Name = name;
		
	}
	public Scenic(String id,String name,String picture){
		scenic_ID = id;
		scenic_Name = name;
		scenic_Picture = picture;
		
	}
	public Scenic(String id,String name,String picture, String video){
		scenic_ID = id;
		scenic_Name = name;
		scenic_Picture = picture;
		scenic_Video = video;
		
	}
	public Scenic(String[] args){
		scenic_ID = args[0];
		scenic_Name = args[1];
		scenic_Picture = args[2];
		scenic_Intro = args[3];
		scenic_Adress = args[4];
		scenic_Level = args[5];
		scenic_Type = args[6];
		scenic_Video = args[7];
		scenic_Phone = args[8];
	}
	public String getName(){
		return scenic_Name;
	}
	public String getID(){
		return scenic_ID;
	}
	public String getPicture(){
		return scenic_Picture;
	}
	public String getIntro(){
		return scenic_Intro;
	}
	public String getAdress(){
		return scenic_Adress;
	}
	public String getLevel(){
		return scenic_Level;
	}
	public String getType(){
		return scenic_Type;
	}
	public String getVideo(){
		return scenic_Video;
	}
	public String getPhone(){
		return scenic_Phone;
	}
	public String[] getall(){
		String[] args = {scenic_ID,
				scenic_Name,
				scenic_Picture,
				scenic_Intro,
				scenic_Adress,
				scenic_Level,
				scenic_Type,
				scenic_Video,
				scenic_Phone};
		return args;
	}
}
