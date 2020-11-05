package model;

public class Playlist{
//constants
	public static int MAX_SONGS=50;
//atributes
	protected String name;
	protected int duration;
	protected String genres;
//relations
	public Song[] songs;
//constructor
	public Playlist(String name, int duration, String genres){
		this.name=name;
		this.duration=duration;
		this.genres= genres;
		songs= new Song[MAX_SONGS];
	}
//getters
	public String getName(){
		return name;
	}
	public String getGenres(){
		return genres;
	}
	public int getDuration(){
		return duration;
	}

//setters
	public void setName(String name){
		this.name=name;
	}
	public void setDuration(int duration){
		this.duration=duration;
	}
	public void setGenres(String genres){
		this.genres=genres;
	}
//showInfo
	public String showInfo(){
		String message;
		message="\n"+
		"************************ Playlist **************************"+
		"\n**  Title: "+getName()+
		"\n**  Duration: "+getDuration()+
		"\n**  Genre: "+getGenres();
		return message;
	}

	
}//END CLASS