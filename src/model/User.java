package model;
enum Category{
	NEWBIE, LITTLE_CONTRIBUTOR, MILD_CONTRIBUTOR,STAR_CONTRIBUTOR
}

public class User{
//constants
	public static int MAX_USERS=10;
//atributes
	private String userName;
	private String password;
	private int age;
	private Category category;
//consructor
	public User(String userName, String password, int age, Category category){
		this.userName=userName;
		this.password=password;
		this.age=age;
		this.category=category;
	}

//getters
	public String getUsername(){
		return userName;
	}
	public String getPassword(){
		return password;
	}
	public int getAge(){
		return age;
	}
	public Category getCategory(){
		return category;
	}
//setters
	public void setUsername(String userName){
		this.userName=userName;

	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setAge(int age){
		this.age=age;

	}
	public void setCategory(Category category){
		this.category=category;
	}
//show Info
	public String showInfo(){
		String message;
		message="********************* User ***********************"+
		"\n**  UserName: "+getUsername()+
		"\n**  Age: "+getAge()+
		"\n**  Category: "+getCategory()+
		"\n**************************************************";

		return message;
	}
}//END CLASS