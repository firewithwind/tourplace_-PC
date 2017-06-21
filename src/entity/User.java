package entity;

public class User {
	private String name = "",
					id = "",
					birthday = "",
					province = "",
					intro = "",
					avatar = "",
					sex = "";
	public User(String userID, String userName){
		this.id = userID;
		this.name = userName;
	}
	public User(String[] args){
		this.id = args[0];
		this.name = args[1];
		this.birthday = args[2];
		this.province = args[3];
		this.intro = args[4];
		this.avatar = args[5];
		this.sex = args[6];
	}
	public void setID(String ID){
		this.id = ID; 
	}
	public void setName(String Name){
		this.name = Name;
	}
	public void setBirthday(String date){
		this.birthday = date;
	}
	public void setProvince(String pro){
		this.province = pro;
	}
	public void setIntro(String Intro){
		this.intro = Intro;
	}
	public void setAvatar(String Avatar){
		this.avatar = Avatar;
	}
	public String getID(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getIntro(){
		return this.intro;
	}
	public String getBirth(){
		return this.birthday;
	}
	public String getSex(){
		return this.sex;
	}
}
