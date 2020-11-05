package model;
public class PrivatePlaylist extends Playlist{
//relations
	public User user;
	public Song[] songs;
//constructor
	public PrivatePlaylist(String name, int duration, String genres, User user){
		super(name, duration, genres);
		this.user=user;
		songs= new Song[MAX_SONGS];
	}
	public String getName(){
		return name;
	}
	public User getUser(){
		return user;
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
		"\n**  User: "+ getUser().getUsername()+
		"\n***********************************************************";
		return message;
	}
}