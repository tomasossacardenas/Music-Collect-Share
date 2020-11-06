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
/**
* This method adds a Song. <br>
*<b>Pre:</b>The array songs[] must be already created<br>
*<b>Pos:</b>The song has been created correctly<br>
*@param song , is the song that is going to be added to the array of songs, song!=null
*@return message, a String that shows if it was possible to create the song or not.
*/
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

/**
* This method shows playlist info. <br>
*<b>Pos:</b>The playlist information has been shown correctly<br>
*@return message, a String that is the information of the playlist.
*/
	public String showInfo(){
		String message;
		message=super.showInfo()+
		"\n**  User: "+ getUser().getUsername()+
		"\n***********************************************************";
		return message;
	}
}