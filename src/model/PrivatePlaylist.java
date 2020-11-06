package model;
public class PrivatePlaylist extends Playlist{
//relations
	public User user;
	public Song[] songs;
//constructor
	public PrivatePlaylist(String name,  User user){
		super(name);
		this.user=user;
		songs= new Song[Mcs.MAX_SONGS];
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

			for(int i=0;i<Mcs.MAX_SONGS && salir==false;i++){
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