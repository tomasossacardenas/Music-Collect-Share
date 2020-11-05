package model;
public class RestrictedPlaylist extends Playlist{
	//constants
	public static int MAX_RESTRICTED_USERS=5;
	//relations
	public User[] users;
	public Song[] songs;
//constructor
	public RestrictedPlaylist(String name, int duration, String genres, User[] users){
		super(name, duration, genres);
		this.users=users;
		songs= new Song[MAX_SONGS];
	}
//show info
	public String showInfo(){
		String message;
		message=super.showInfo()+ showUsersNames();
		return message;
	}
//showUsersNames
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

	public boolean verifyUser(String userName){
		boolean exists=false;
		for (int i=0;i<users.length;i++){
			if(users[i]!=null && users[i].getUsername().equals(userName)){
				exists=true;
			}
		}
		return exists;
		
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
}