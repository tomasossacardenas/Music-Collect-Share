package model;
public class RestrictedPlaylist extends Playlist{
	//constants
	public static int MAX_RESTRICTED_USERS=5;//constant that shows that there is a limit of users for restrictedPlaylist
	//relations
	public User[] users;//This class has a relation with users, it means a restricted playlist could have more than one user 
	public Song[] songs;// this class has a relation with songs, it means an object of this class could have more than one song
//constructor
	public RestrictedPlaylist(String name, User[] users){
		super(name);
		this.users=users;
		songs= new Song[Mcs.MAX_SONGS];
	}
/**
* This method shows restricted playlist info. <br>
*<b>Pos:</b>The playlist information has been shown correctly<br>
*@return message, a String that is the information of the playlist.
*/
	public String showInfo(){
		String message;
		message=super.showInfo()+ showUsersNames();
		return message;
	}
/**
* This method shows the names of the users. <br>
*<b>Pre:</b>The array users[] must be already created<br>
*<b>Pos:</b>The users has been shown<br>
*@param userName , is the user name, userName!=null and userName!="".
*@return message, String that contains all the usernames of all of users.
*/
	public String showUsersNames(){
		String mensaje="\n Users: ";
		for(int i=0; i<users.length;i++){
			if(users[i]!=null){
				mensaje+= users[i].getUsername()+". ";
			}
		}
		mensaje+="\n***********************************************************";
		return mensaje;
	}
/**
* This method verify if a user exists. <br>
*<b>Pre:</b>The array users[] must be already created<br>
*<b>Pos:</b>The user has been verified<br>
*@param userName , is the user name, userName!=null and userName!="".
*@return exists, a boolean that shows if the user exists or not.
*/
	public boolean verifyUser(String userName){
		boolean exists=false;
		for (int i=0;i<users.length;i++){
			if(users[i]!=null && users[i].getUsername().equals(userName)){
				exists=true;
			}
		}
		return exists;
		
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
}