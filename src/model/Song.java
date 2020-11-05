package model;
enum GenreSong{
	ROCK, HIPHOP, CLASSICAL, REGGAE, SALSA, METAL
}
public class Song{
//atributes
	private String title;
	private String releaseDate;
	private String artistName;
	private int duration;
	private GenreSong genre;
	private User author;
//constructor
	public Song(String title, String releaseDate, String artistName, int duration, GenreSong genre, User author){
		this.title=title;
		this.releaseDate=releaseDate;
		this.artistName=artistName;
		this.duration=duration;
		this.genre=genre;
		this.author=author;
	}
//getters
	public String getTitle(){
		return title;
	}
	public String getReleaseDate(){
		return releaseDate;
	}
	public String getArtistName(){
		return artistName;
	}
	public int getDuration(){
		return duration;
	}
	public GenreSong getGenre(){
		return genre;
	}
	public User getAuthor(){
		return author;
	}
//setters
	public void setTitle(String title){
		this.title=title;
	}
	public void setReleaseDate(String releaseDate){
		this.releaseDate=releaseDate;
	}
	public void setArtistName(String artistName){
		this.artistName=artistName;
	}
	public void setDuration(int duration){
		this.duration=duration;
	}
	public void setGenreSong(GenreSong genre){
		this.genre=genre;
	}

	public String showInfo(){
		String message;
		message="*********************** Song ************************"+
		"\n**  Title: "+getTitle()+
		"\n**  Artist: "+getArtistName()+
		"\n**  Duration: "+getDuration()+
		"\n**  Genre: "+getGenre()+
		"\n****************************************************";

		return message;
	}

}