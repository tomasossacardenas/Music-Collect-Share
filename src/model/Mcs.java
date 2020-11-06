package model;
import java.util.*;
public class Mcs{
//constants
	public final static int MAX_USERS=10, MAX_SONGS=50, MAX_PLAYLISTS=20;
//atributes
	private int numUsers, numSongs, numPlaylists;
//relations
	private Song[] songs;
	public Playlist[] playlists;
	public User[] users;
//constructor
	public Mcs(int numUsers, int numSongs, int numPlaylists){
		this.numUsers=numUsers;
		this.numSongs=numSongs;
		this.numPlaylists=numPlaylists;
		playlists=new Playlist[MAX_PLAYLISTS];
		users=new User[MAX_USERS];
		songs= new Song[MAX_SONGS];
	}
//getters
	public int getNumUsers(){
		return numUsers;
	}
	public int getNumSongs(){
		return numSongs;
	}
	public int getNumPlaylists(){
		return numPlaylists;
	}
//setters
	public void setNumUsers(int numUsers){
		this.numUsers=numUsers;
	}
	public void setNumSongs(int numSongs){
		this.numSongs=numSongs;
	}
	public void setNumPlaylists(int numPlaylists){
		this.numPlaylists=numPlaylists;
	}

/**
* This method finds a user with an especific name. <br>
*<b>Pre:</b>The array users[] must be already created<br>
*<b>Pos:</b>The user has been found or not<br>
*@param userName is the String of the name of the user, userName!=null and userName!="".
*@return found, a boolean that shows if the user had been found or not.
*/
	public boolean findUser(String userName){
		boolean salir=false;
		boolean found=false;
		for(int i=0;i<MAX_USERS && salir==false;i++){
			if (users[i]!=null && users[i].getUsername().equals(userName)){
				found=true;
			}
		}
		return found;
	}
/**
* This method adds a new user. <br>
*<b>Pre:</b>The array users[] must be already created<br>
*<b>Pos:</b>The user has been added correctly<br>
*@param userName is the String of the name of the user, userName!=null and userName!="".
*@param password is the password of the user.
*@param age is the age of the user.
*@return message, a String that shows a message to the user if the process was succesfull or not
*/
	public String addUser(String userName, String password, int age){
		boolean found= findUser(userName);
		String message="El usuario ha sido registrado";
		boolean salir=false;
		if (found==false){
			for(int i=0;i<MAX_USERS && salir==false;i++){
				if (users[i]==null){
					users[i]=new User(userName, password, age);
					salir=true;
				}
			}
			if (salir==false){
					message="Cupos de usuarios lleno, no se pudo registrar";
			}
		}
		else{
			message="Este usuario ya existe en el MCS";
		}
		return message;
	}

/**
* This method shows users info. <br>
*<b>Pre:</b>The array users[] must be already created<br>
*<b>Pos:</b>The user information has been shown correctly<br>
*@param i , it helps to go user by user, showing everything about it, i!=null
*@return message, a String that is the information of the user.
*/
	public String showInfo(int i){
		String message="";
		if (users[i]!=null){
			message=users[i].showInfo();
			
		}
		return message;
	}

/**
* This method shows songs info. <br>
*<b>Pre:</b>The array songs[] must be already created<br>
*<b>Pos:</b>The songs information has been shown correctly<br>
*@param i , it helps to go song by song, showing everything about it, i!=null
*@return message, a String that is the information of the song.
*/
	public String showSongsInfo(int i){
		String message="";
		if (songs[i]!=null){
			message=songs[i].showInfo();
			
		}
		return message;
	}
/**
* This method shows restricted playlists info. <br>
*<b>Pre:</b>The array playlists[] must be already created<br>
*<b>Pos:</b>Class RestrictedPlaylist has to exist<br>
*@param i , it helps to go restricted playlist one by one, showing everything about it, i!=null
*@return message, a String that is the information of the restrictedPlaylist
*/
	public String showRestrictedInfo(int i){
		String message="";
		if (playlists[i]!=null && playlists[i] instanceof RestrictedPlaylist){
			RestrictedPlaylist restrictedPlaylist=(RestrictedPlaylist)playlists[i];
			message=restrictedPlaylist.showInfo();
		}
		return message;
	}
/**
* This method shows private Playlists info. <br>
*<b>Pre:</b>The array playlists[] must be already created<br>
*<b>Pos:</b>Class PrivatePlaylist has to exist<br>
*@param i , it helps to go private playlist one by one, showing everything about it, i!=null.
*@return message, a String that is the information of the private Playlist
*/
	public String showPrivateInfo(int i ){
		String message="";
		if (playlists[i]!=null && playlists[i] instanceof PrivatePlaylist){
			PrivatePlaylist privatePlaylist=(PrivatePlaylist)playlists[i];
			message=privatePlaylist.showInfo();
			
		}
		return message;
	}
/**
* This method shows public Playlists info. <br>
*<b>Pre:</b>The array playlists[] must be already created<br>
*<b>Pos:</b>Class PublicPlaylist has to exist<br>
*@param i , it helps to go public playlist one by one, showing everything about it, i!=null.
*@return message, a String that is the information of the pulblic Playlist
*/
	public String showPublicInfo(int i ){
		String message="";
		if (playlists[i]!=null && playlists[i] instanceof PublicPlaylist){
			PublicPlaylist publicPlaylist=(PublicPlaylist)playlists[i];
			message=publicPlaylist.showInfo();
			
		}
		return message;
	}
/**
* This method adds a Song. <br>
*<b>Pre:</b>The array songs[] must be already created<br>
*<b>Pos:</b>The song has been created correctly<br>
*@param title , is the title of the song, title!=null and title!="";
*@param releaseDate , is the date when the song had been released, releaseDate!=null and releaseDate!="".
*@param artistName , is the name of the artist of the song, artistName!=null and artistName!="".
*@param duration is the duration of the song, duration!=null and duration>0.
*@param genre is the genre of the song, genre!=null.
*@param author is the name of the author, author!=null and author!="".
*@return message, a String that shows if it was possible to create the song or not.
*/
	public String addSong(String title, String releaseDate, String artistName, int duration, GenreSong genre, String author){
		String message="La cancion ha sido creada";
		boolean salir=false;

			for(int i=0;i<MAX_SONGS && salir==false;i++){
				if (songs[i]==null){
					songs[i]=new Song(title, releaseDate, artistName, duration, genre, returnUser(author));
					salir=true;
				}
			}
			if (salir==false){
					message="Cupos de canciones llenos";
			}
		setUserCategory(returnUser(author));
		return message;
	}
/**
* This method returns a genre depending of the number of the option shown in the menu. <br>
*<b>Pre:</b>Enum GenreSong must be already created<br>
*<b>Pos:</b>The genre has been returned correctly<br>
*@param option , is the number the user chose fo what genre is the song, option!=null.
*@return tp, type GenreSong which means what genre did the user choose.
*/
	public GenreSong returnGenre(int option){
		GenreSong tp=GenreSong.ROCK;
		switch (option){
			case 1:
				tp=GenreSong.ROCK;
				break;
			case 2:
				tp=GenreSong.HIPHOP;
				break;
			case 3:
				tp=GenreSong.CLASSICAL;
				break;
			case 4:
				tp=GenreSong.REGGAE;
				break;
			case 5:
				tp=GenreSong.SALSA;
				break;
			case 6:
				tp=GenreSong.METAL;
				break;
		}
		return tp;
	}
/**
* This method returns an User. <br>
*<b>Pre:</b>The array users[] must be already created<br>
*<b>Pos:</b>The user has been returned correctly<br>
*@param userName is the name of the user, userName!=null and userName!="".
*@return userx, User depending on the userName the user wrote.
*/
	public User returnUser(String userName){
		User userx= null;
		boolean encontrar=false;
		for (int i=0;i<MAX_USERS;i++){
			if(users[i]!=null && users[i].getUsername().equals(userName)){
				encontrar=true;
				userx=users[i];
			}
		}
		return userx;
	}
/**
* This method find a public playlist depending on the name and returns it. <br>
*<b>Pre:</b>The array playlists[] must be already created<br>
*<b>Pos:</b>The publicPlaylist has been returned correctly<br>
*@param name , is the name of the playlist, name!=null.
*@return publicPlaylistx, PublicPlaylist that is the playlist found with the name
*/
	public PublicPlaylist returnPublicPlaylist(String name){
		PublicPlaylist publicPlaylistx= null;
		boolean encontrar=false;
		for (int i=0;i<MAX_PLAYLISTS;i++){
			if(playlists[i]!=null && playlists[i].getName().equals(name) && playlists[i] instanceof PublicPlaylist){
				encontrar=true;
				publicPlaylistx=(PublicPlaylist)playlists[i];
			}
		}
		return publicPlaylistx;
	}
/**
* This method find a private playlist depending on the name and returns it. <br>
*<b>Pre:</b>The array playlists[] must be already created<br>
*<b>Pos:</b>The privatePlaylist has been returned correctly<br>
*@param playlistName , is the name of the playlist, playlistName!=null and playlistName!="".
*@param userName , is the name of the user, userName!=null and userName!="".
*@return privatePlaylistx, PrivatePlaylist that is the playlist found with the name
*/
	public PrivatePlaylist returnPrivatePlaylist(String playlistName, String userName){

		PrivatePlaylist privatePlaylistx= null;
		PrivatePlaylist	privatePlaylisty= null;
		boolean encontrar=false;
		for (int i=0;i<MAX_PLAYLISTS;i++){
			if(playlists[i]!=null && playlists[i].getName().equals(playlistName)&& playlists[i] instanceof PrivatePlaylist){
				privatePlaylisty=(PrivatePlaylist)playlists[i];
					if(privatePlaylisty.getUser()==returnUser(userName)){
						encontrar=true;
						privatePlaylistx=(PrivatePlaylist)playlists[i];
					}
			}
		}
		return privatePlaylistx;
	}
/**
* This method find a restricted playlist depending on the name and returns it. <br>
*<b>Pre:</b>The array playlists[] must be already created<br>
*<b>Pos:</b>The restrictedPlaylist has been returned correctly<br>
*@param playlistName , is the name of the playlist, playlistName!=null and playlistName!="".
*@param userName , is the name of the user, userName!=null and userName!="".
*@return restrictedPlaylistx, RestrictedPlaylist that is the playlist found with the name
*/
	public RestrictedPlaylist returnRestrictedPlaylist(String playlistName, String userName){
		RestrictedPlaylist restrictedPlaylistx=null;
		boolean encontrar=false;
		for (int i=0;i<MAX_PLAYLISTS;i++){
			if(playlists[i]!=null && playlists[i].getName().equals(playlistName) && playlists[i] instanceof RestrictedPlaylist){
				encontrar=true;
				restrictedPlaylistx=(RestrictedPlaylist)playlists[i];
			}
		}
		return restrictedPlaylistx;
	}
/**
* This method returns a Song. <br>
*<b>Pre:</b>The array songs[] must be already created<br>
*<b>Pos:</b>The song has been returned correctly<br>
*@param title , is the title of the song, title!=null and title!="".
*@return songx, Song the song with the title that the user entered.
*/
	public Song returnSong(String title){
		Song songx=null;
		boolean encontrar=false;
		for (int i=0;i<MAX_SONGS;i++){
			if(songs[i]!=null && songs[i].getTitle().equals(title)){
				encontrar=true;
				songx=songs[i];
			}
		}
		return songx;
	}
/**
* This method changes the category of the user. <br>
*<b>Pre:</b>The array songs[] must be already created<br>
*<b>Pre:</b>The array users[] must be already created<br>
*<b>Pos:</b>The catefory has been changed correctly<br>
*@param user , is the User which its category is going to be changed, user!=null.
*/
	public void setUserCategory(User user){
		int contador=0;
		for (int i=0;i< MAX_SONGS;i++){
			if(songs[i]!=null && songs[i].getAuthor().equals(user)){
				contador++;
			}
		}
		for (int i=0;i< MAX_USERS;i++){
			if(users[i]!=null && users[i].getUsername().equals(user.getUsername())){
				if (contador<3){
					users[i].setCategory(Category.NEWBIE);
				}
				if (contador>=3 && contador<10){
					users[i].setCategory(Category.LITTLE_CONTRIBUTOR);
				}
				if (contador>=10 && contador<30){
					users[i].setCategory(Category.MILD_CONTRIBUTOR);
				}
				if (contador>=30){
					users[i].setCategory(Category.STAR_CONTRIBUTOR);
				}
			}
		}
	}
/**
* This method adds a privatePlaylist. <br>
*<b>Pre:</b>The array playlists[] must be already created<br>
*<b>Pos:</b>The playlist has been added correctly<br>
*@param name , is the name of the playlist, playlistName!=null and playlistName!="".
*@param userName , is the name of the user, userName!=null and userName!="".
*@return message, String that shows if the procedure could have been done or not.
*/
	public String addPlaylist(String name, String userName){
		String message="La playlist privada ha sido creada";
		boolean salir=false;
			for(int i=0;i<MAX_PLAYLISTS && salir==false;i++){
				if (playlists[i]==null){
					playlists[i]= new PrivatePlaylist(name, returnUser(userName));
					salir=true;
				}
			}
			if (salir==false){
					message="Cupos de playlists privados llenos";
			}
		return message;
	}
/**
* This method adds a public Playlist. <br>
*<b>Pre:</b>The array playlists[] must be already created<br>
*<b>Pos:
</b>The playlist has been added correctly<br>
*@param name , is the name of the playlist, name!=null and name!="".
*@return message, String that shows if the procedure could have been done or not.
*/
	public String addPlaylist(String name){
		String message="La playlist publica ha sido creada";
		boolean salir=false;
			for(int i=0;i<MAX_PLAYLISTS && salir==false;i++){
				if (playlists[i]==null){
					playlists[i]= new PublicPlaylist(name);
					salir=true;
				}
			}
			if (salir==false){
					message="Cupos de playlists publicas llenos";
			}
		return message;
	}
/**
* This method adds a restricted Playlist. <br>
*<b>Pre:</b>The array playlists[] must be already created<br>
*<b>Pos:</b>The playlist has been added correctly<br>
*@param name , is the name of the playlist, name!=null and name!="".
*@param usersNames , is the array of names of the users that are going to have access to the playlist usersNames!=null.
*@param usersQuantity is the cuantity of users that have acces to the playlist, usersQuantity!=null.
*@return message, String that shows if the procedure could have been done or not.
*/
	public String addPlaylist(String name, String[] usersNames, int usersQuantity){
		String message="";
		boolean salir=false;
			for(int i=0;i<MAX_PLAYLISTS && salir==false;i++){
				if (playlists[i]==null){
					playlists[i] = new RestrictedPlaylist(name, returnUsers(usersQuantity, usersNames));
					salir=true;
					message="La playlist restringida ha sido creada";
				}
			}
			if (salir==false){
					message="Cupos de playlists restringidos llenos";
			}
		return message;
	}
/**
* This method returns an array of users. <br>
*<b>Pre:</b>The array users[] must be already created<br>
*<b>Pre:</b>The array usersNames[] must be already created<br>
*<b>Pos:</b>The array has been returned correctly<br>
*@param usersQuantity is the cuantity of users, usersQuantity!=null
*@param usersNames , is the array of names of the users usersNames!=null.
*@return users, User an array that contains objects of type User.
*/
	public User[] returnUsers(int usersQuantity, String[] usersNames){
		User[] users=new User[usersQuantity];
		for (int i=0;i<usersQuantity;i++){
			users[i]=returnUser(usersNames[i]);
		}
		return users;
	}
/**
* This method verifies if a public playlist exists. <br>
*<b>Pre:</b>The array playlists[] must be already created<br>
*<b>Pos:</b>Program could verify if the public playlist existed<br>
*@param playlistName , is the name of the playlist, playlistName!=null and playlistName!="".
*@return found, boolean that shows if the user exists or not.
*/
	public boolean publicPlaylistExists(String playlistName){
		boolean salir=false;
		boolean found=false;
		for(int i=0;i<MAX_PLAYLISTS && salir==false;i++){
			if (playlists[i]!=null && playlists[i].getName().equals(playlistName) && playlists[i] instanceof PublicPlaylist){
				found=true;
			}
		}
		return found;
	}
/**
* This method modifies the grade of a publicPlaylist. <br>
*<b>Pre:</b>The array playlists[] must be already created<br>
*<b>Pos:</b>The playlist has been added correctly<br>
*@param name , is the name of the playlist, name!=null and name!="".
*@param grade , is the grade the user gives to the playlist, grade!=null and grade>=0.
*@return message, String that shows if the procedure could have been done or not.
*/
	public String setPlaylistGrade(int grade, String name){
		int actualGrade=returnPublicPlaylist(name).getGrade();
		int newGrade=grade;
		String mensaje="La nota de la playlist fue modificada";
		int gradeChanged=0;
		if (actualGrade!=0 && actualGrade<=5){
			gradeChanged=(actualGrade+newGrade)/2;
		}
		else if (actualGrade==0){
			gradeChanged=newGrade;
		}
		else{
			mensaje="La nota debe ser menor o igual a 5";
		}
		returnPublicPlaylist(name).setGrade(gradeChanged);
		return mensaje;
	}
/**
* This method adds a song to a private playlist <br>
*<b>Pos:</b>The song has been added correctly<br>
*@param playlistName , is the name of the playlist, playlistName!=null and playlistName!="".
*@param userName , is the name of the user, userName!=null and userName!="".
*@param songName , is the name of the song that is going to be added, songName!=null.
*@return message, String that shows if the procedure could have been done or not.
*/
	public String addSongToPrivatePlaylist(String userName, String playlistName, String songName){
		PrivatePlaylist privatePlaylistx=returnPrivatePlaylist(playlistName, userName);
		Song songx=returnSong(songName);
		String mensaje="";

		if (privatePlaylistx!=null && songx!=null){
			mensaje=privatePlaylistx.addSong(songx);
			setDuration(privatePlaylistx, songx);
			setGenre(privatePlaylistx, songx);
		}
		if(songx==null){
			mensaje+="La cancion con el nombre"+ songName+" no existe";
		}
		if(privatePlaylistx==null){
			mensaje+= ", La playlist "+playlistName+" no existe o usted no esta autorizado para manipularla";
		}
		


		return mensaje;
	}
/**
* This method adds a song to a Restricted playlist <br>
*<b>Pos:</b>The song has been added correctly<br>
*@param playlistName , is the name of the playlist, playlistName!=null and playlistName!="".
*@param userName , is the name of the user, userName!=null and userName!="".
*@param songName , is the name of the song that is going to be added, songName!=null.
*@return message, String that shows if the procedure could have been done or not.
*/
	public String addSongToRestrictedPlaylist(String userName, String playlistName, String songName){
		RestrictedPlaylist restrictedPlaylistx=returnRestrictedPlaylist(playlistName, userName);
		Song songx=returnSong(songName);
		String mensaje="";
		boolean userExists=restrictedPlaylistx.verifyUser(userName);

		if (restrictedPlaylistx!=null && songx!=null && userExists==true){
			mensaje=restrictedPlaylistx.addSong(songx);
			setDuration(restrictedPlaylistx, songx);
			setGenre(restrictedPlaylistx, songx);
		}
		if(songx==null){
			mensaje+="La cancion con el nombre"+ songName+" no existe";
		}
		if(restrictedPlaylistx==null){
			mensaje+= ", La playlist "+playlistName+" no existe";
		}
		if (userExists==false){
			mensaje +=", El usuario "+userName+" no tiene acceso a esta playlist";
		}
		

		return mensaje;
	}
/**
* This method adds a song to a public playlist <br>
*<b>Pos:</b>The song has been added correctly<br>
*@param playlistName , is the name of the playlist, playlistName!=null and playlistName!="".
*@param songName , is the name of the song that is going to be added, songName!=null.
*@return message, String that shows if the procedure could have been done or not.
*/
	public String addSongToPublicPlaylist(String playlistName, String songName){
		PublicPlaylist publicPlaylistx=returnPublicPlaylist(playlistName);
		Song songx=returnSong(songName);
		String mensaje="";

		if (publicPlaylistx!=null && songx!=null){
			mensaje=publicPlaylistx.addSong(songx);
			setDuration(publicPlaylistx, songx);
			setGenre(publicPlaylistx, songx);
		}
		if(songx==null){
			mensaje+="La cancion con el nombre"+ songName+" no existe";
		}
		if(publicPlaylistx==null){
			mensaje+= ", La playlist "+playlistName+" no existe";
		}
		
		return mensaje;
	}
/**
* This method sets the duration of a private playlist, this method is going to be done just after add a song to a playlist<br>
*<b>Pos:</b>The duration has been modified correctly<br>
*@param privatePlaylistx , is the playlist, privatePlaylist!=null.
*@param songx , is the song that has been just added, songx!=null.
*/
	public void setDuration(PrivatePlaylist privatePlaylistx, Song songx){
		int newDuration=privatePlaylistx.getDuration()+songx.getDuration();
		privatePlaylistx.setDuration(newDuration);
	}
/**
* This method sets the duration of a restricted playlist, this method is going to be done just after add a song to a playlist<br>
*<b>Pos:</b>The duration has been modified correctly<br>
*@param restrictedPlaylistx , is the playlist, restrcistedPlaylist!=null.
*@param songx , is the song that has been just added, songx!=null.
*/
	public void setDuration(RestrictedPlaylist restrictedPlaylistx, Song songx){
		int newDuration=restrictedPlaylistx.getDuration()+songx.getDuration();
		restrictedPlaylistx.setDuration(newDuration);
	}
/**
* This method sets the duration of a public playlist, this method is going to be done just after add a song to a playlist<br>
*<b>Pos:</b>The duration has been modified correctly<br>
*@param publicPlaylistx , is the playlist, publicPlaylist!=null.
*@param songx , is the song that has been just added, songx!=null.
*/
	public void setDuration(PublicPlaylist publicPlaylistx, Song songx){
		int newDuration=publicPlaylistx.getDuration()+songx.getDuration();
		publicPlaylistx.setDuration(newDuration);
	}

/**
* This method sets the genre of a private playlist, this method is going to be done just after add a song to a playlist<br>
*<b>Pos:</b>The genre has been modified correctly<br>
*@param privatePlaylistx , is the playlist, privatePlaylist!=null.
*@param songx , is the song that has been just added, songx!=null.
*/
	public void setGenre(PrivatePlaylist privatePlaylistx, Song songx){
		String newGenres="";
		String songGenre=songx.getGenre().name();
		if (privatePlaylistx.getGenres()!=""){
			newGenres=privatePlaylistx.getGenres()+","+songGenre;
		}
		else{
			newGenres=songx.getGenre().name();
		}
		privatePlaylistx.setGenres(newGenres);
	}
/**
* This method sets the genre of a restricted playlist, this method is going to be done just after add a song to a playlist<br>
*<b>Pos:</b>The genre has been modified correctly<br>
*@param restrictedPlaylistx , is the playlist, restrictedPlaylist!=null.
*@param songx , is the song that has been just added, songx!=null.
*/
	public void setGenre(RestrictedPlaylist restrictedPlaylistx, Song songx){
		String newGenres="";
		String songGenre=songx.getGenre().name();
		if (restrictedPlaylistx.getGenres()!=""){
			newGenres=restrictedPlaylistx.getGenres()+","+songGenre;
		}
		else{
			newGenres=songx.getGenre().name();
		}
		restrictedPlaylistx.setGenres(newGenres);
	}
/**
* This method sets the genre of a public playlist, this method is going to be done just after add a song to a playlist<br>
*<b>Pos:</b>The genre has been modified correctly<br>
*@param publicPlaylistx , is the playlist, publicPlaylist!=null.
*@param songx , is the song that has been just added, songx!=null.
*/
	public void setGenre(PublicPlaylist publicPlaylistx, Song songx){
		String newGenres="";
		String songGenre=songx.getGenre().name();
		if (publicPlaylistx.getGenres()!=""){
			newGenres=publicPlaylistx.getGenres()+","+songGenre;
		}
		else{
			newGenres=songx.getGenre().name();
		}
		publicPlaylistx.setGenres(newGenres);
	}	
}//END OF CLASS
