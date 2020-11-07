package model;

public class Playlist{
//atributes
	protected String name;//name of the playlist
	protected int duration;//the duration of the playlist depending on the duration of all of its songs.
	protected String genres;//The genres that the playlist has depending on the genres of each song.
//relations
	public Song[] songs;// this class has a relation with songs, it means an object of this class could have more than one song
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