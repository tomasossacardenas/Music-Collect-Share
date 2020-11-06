package model;

public class Playlist{
//atributes
	protected String name;
	protected int duration;
	protected String genres;
//relations
	public Song[] songs;
//constructor
	public Playlist(String name){
		this.name=name;
		duration=0;
		genres= "";
		songs= new Song[Mcs.MAX_SONGS];
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
	
/**
* This method shows playlist info. <br>
*<b>Pos:</b>The playlist information has been shown correctly<br>
*@return message, a String that is the information of the playlist.
*/
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