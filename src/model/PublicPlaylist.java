package model;
public class PublicPlaylist extends Playlist{
	//constants
	public static int MAX_PUBLIC_USERS=10;
	//atributes
	private int grade;
	//relations
	public User[] users;
//constructor
	public PublicPlaylist(String name, int duration, String genres, int grade){
		super(name, duration, genres);
		this.grade=grade;
		users= new User[MAX_PUBLIC_USERS];
	}
//setters
	public int getGrade(){
		return grade;
	}
//getters
	public void setGrade(int grade){
		this.grade=grade;
	}
//Add a new song
	public String addSong(Song song){
		String message="La cancion ha sido añadida a la playlist";
		boolean salir=false;

			for(int i=0;i<MAX_SONGS && salir==false;i++){
				if (songs[i]==null){
					songs[i]=song;
					salir=true;
				}
			}
			if (salir==false){
					message="Cupos de canciones llenos";
			}
		return message;
	}
//showInfo
	public String showInfo(){
		String message;
		message=super.showInfo()+
		"\n**  Grade: "+getGrade()+
		"\n***********************************************************";
		return message;
	}
}