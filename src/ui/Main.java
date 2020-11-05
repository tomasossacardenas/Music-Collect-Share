package ui;
import model.Mcs;
import java.util.*;
public class Main{
public static Scanner entrada = new Scanner(System.in);
	public static void main (String[] args){
		Mcs mcs= new Mcs(10, 50, 20);
		showMenu();
		chooseOption(mcs);
	}
/**
* This method registers a new user. <br>
*<b>Pos:</b>The user has been created satisfactorily<br>
*@param mcs is the app that is going to save all the data, mcs!=null.
*/
	public static void registerUser(Mcs mcs){
		String mensaje;
		System.out.println("Ingrese el Nombre de Usuario");
		String userName=entrada.nextLine();
		System.out.println("Ingrese la Contraseña");
		String password=entrada.nextLine();
		System.out.println("Ingrese la Edad");
		int age=entrada.nextInt();entrada.nextLine();
		mensaje=mcs.addUser(userName, password, age);
		System.out.println(mensaje);
		showMenu();
		chooseOption(mcs);
	}
/**
* This method registers a Song. <br>
*<b>Pos:</b>The Song has been created satisfactorily<br>
*@param mcs is the app that is going to save all the data, mcs!=null.
*/
	public static void registerSong(Mcs mcs){
		String mensaje;
		System.out.println("Ingrese su nombre de usuario");
		String userName=entrada.nextLine();
		System.out.println("Ingrese el titulo de la cancion");
		String title=entrada.nextLine();
		System.out.println("Ingrese la fecha de lanzamiento");
		String releaseDate=entrada.nextLine();
		System.out.println("Ingrese el nombre del Artista");
		String artistName=entrada.nextLine();
		System.out.println("Ingrese la duracion de la cancion");
		int duration=entrada.nextInt();entrada.nextLine();
		System.out.println("Ingrese el numero del genero\n 1.ROCK\n 2.HIPHOP\n 3.CLASSICAL\n 4.REGGAE\n 5.SALSA\n 6.METAL");
		int optionGenre=entrada.nextInt();entrada.nextLine();
		mensaje=mcs.addSong(title, releaseDate, artistName, duration, mcs.returnGenre(optionGenre), userName);
		System.out.println(mensaje);
		showMenu();
		chooseOption(mcs);
	}
//Create playlist
/**
* This method Registers a Playlist. <br>
*<b>Pos:</b>The playlist has been created with all of its atributes depending on the user choice<br>
*@param mcs is the app that is going to save all the data, mcs!=null.
*@param option is the  option the user chose about what type of playlist to create, option!=null, option!=
*/
	public static void registerPlaylist(Mcs mcs, int option){
		String mensaje="";
		String userName, name;
		switch(option){
			case 1: 
				System.out.println("Ingrese su nombre de usuario");
				 userName=entrada.nextLine();
				System.out.println("Ingrese el nombre de la playlist");
				 name=entrada.nextLine();
				mensaje=mcs.addPlaylist(name, userName);
				System.out.println(mensaje);
				break;
			case 2:
				System.out.println("Cuantos usuarios van a tener acceso a este playlist MAXIMO PERMITIDOS 5");
				int usersQuantity=entrada.nextInt();entrada.nextLine();
				String[] users= new String[usersQuantity];
					for(int i=0;i<usersQuantity;i++){
						System.out.println("Ingrese el nombre del "+ (i+1)+" usuario");
						 userName=entrada.nextLine();
						users[i]=userName;
					}
					System.out.println("Ingrese el nombre de la playlist");
					 name=entrada.nextLine();
					mensaje=mcs.addPlaylist(name, users, usersQuantity);
					System.out.println(mensaje);
					break;
			case 3:
				System.out.println("Ingrese el nombre de la playlist");
				name=entrada.nextLine();
				mensaje=mcs.addPlaylist(name);
				System.out.println(mensaje);
				break;
			default:
				System.out.println("Opcion no valida");
				break;

		}
	}

/**
* This method shows the menu of the functionalities that the program has. <br>
*<b>Pos:</b>The menu has been shown correctly<br>
*/
	public static void showMenu(){
		System.out.println("");
		System.out.println("Digite el numero de la actividad que desea realizar: \n 1. Registrar un usuario \n 2. Listar Usuarios \n 3. Registrar una cancion\n 4. Listar Canciones Compartidas\n 5. Crear Playlist \n 6. Calificar playlist publica\n 7. Agregar cancion del pool a una playlist\n 8.Mostrar informacion de playlists");
	}
/**
* This method shows menu of the three types of playlist. <br>
*<b>Pos:</b>The functionality has been chosen correctly<br>
*@param mcs is the app that is going to save all the data, mcs!=null.
*/
	public static void showPlaylistMenu(Mcs mcs){
		System.out.println("");
		System.out.println("\n 1. Playlist privada \n 2. Playlist Restringida \n 3. Playlist publica");
	}

/**
* This method shows the info of the users in the app. <br>
*<b>Pos:</b>The users information has been shown in a correct way<br>
*@param mcs is the app  that is going to save all the data, mcs!=null.
*/
	public static void showUsersInfo(Mcs mcs){
		for(int i=0;i<mcs.MAX_USERS;i++){
			if(mcs.showInfo(i)!=""){
			System.out.println(mcs.showInfo(i));
			}
		}
		showMenu();
		chooseOption(mcs);
	}

/**
* This method shows the info of the songs in the app. <br>
*<b>Pos:</b>The users information has been shown in a correct way<br>
*@param mcs is the app  that is going to save all the data, mcs!=null.
*/
	public static void showSongsInfo(Mcs mcs){
		for(int i=0;i<mcs.MAX_SONGS;i++){
			if(mcs.showSongsInfo(i)!=""){
			System.out.println(mcs.showSongsInfo(i));
			}
		}
		showMenu();
		chooseOption(mcs);
	}
/**
* This method shows info of restricted Playlists. <br>
*<b>Pos:</b>The info has been shown<br>
*@param mcs is the app that is going to save all the data, mcs!=null.
*/
	public static void showPlaylistInfo(Mcs mcs, int option){
		switch(option){
			case 1:
				for(int i=0;i<mcs.MAX_PLAYLISTS;i++){
					if(mcs.showPrivateInfo(i)!=""){
					System.out.println(mcs.showPrivateInfo(i));
					}
				}
				showMenu();
				chooseOption(mcs);
			break;
			case 2:
				for(int i=0;i<mcs.MAX_PLAYLISTS;i++){
					if(mcs.showRestrictedInfo(i)!=""){
					System.out.println(mcs.showRestrictedInfo(i));
					}
				}
				showMenu();
				chooseOption(mcs);
			break;
			case 3:
				for(int i=0;i<mcs.MAX_PLAYLISTS;i++){
					if(mcs.showPublicInfo(i)!=""){
					System.out.println(mcs.showPublicInfo(i));
					}
				}
				showMenu();
				chooseOption(mcs);
			break;
		}	
	}

/**
* This method does different tasks depending of what option of the menu the user chose. <br>
*<b>Pos:</b>The functionality has been chosen correctly<br>
*@param mcs is the app that is going to save all the data, mcs!=null.
*/
	public static void chooseOption(Mcs mcs){
		int menuOption=entrada.nextInt();entrada.nextLine();
		switch(menuOption){
			case 1:
				registerUser(mcs);
				break;
			case 2:
				showUsersInfo(mcs);
				break;
			case 3:
				registerSong(mcs);
				break;
			case 4:
				showSongsInfo(mcs);
				break;
			case 5:
				System.out.println("Que tipo de playlist desea crear");
				showPlaylistMenu(mcs);
				choosePlaylistOption(mcs);
				showMenu();
				chooseOption(mcs);
				break;
			case 6:
				assignGrade(mcs);
			case 7:
				System.out.println("A que tipo de playlist va a añadir la cancion?");
				showPlaylistMenu(mcs);
				choosePlaylistOptionAddSong(mcs);
				showMenu();
				chooseOption(mcs);
			case 8:
				System.out.println("Desea saber la informacion de que tipo de playlists");
				showPlaylistMenu(mcs);
				choosePlaylistOptionInfo(mcs);
				showMenu();
				chooseOption(mcs);

		}//switch
	}

/**
* This method does different tasks depending of what type of PLaylist the user want to create. <br>
*<b>Pos:</b>The functionality has been chosen correctly<br>
*@param mcs is the app that is going to save all the data, mcs!=null.
*/
	public static void choosePlaylistOption(Mcs mcs){
		int menuOption=entrada.nextInt();entrada.nextLine();
		switch(menuOption){
			case 1:
			case 2:
			case 3:
				registerPlaylist(mcs, menuOption);
				break;
		}
	}
//option to show information about a playlist
/**
* This method does different tasks depending of what type of PLaylist the user wants to know the information. <br>
*<b>Pos:</b>The functionality has been chosen correctly<br>
*@param mcs is the app that is going to save all the data, mcs!=null.
*/
	public static void choosePlaylistOptionInfo(Mcs mcs){
		int menuOption=entrada.nextInt();entrada.nextLine();
		switch(menuOption){
			case 1:
			case 2:
			case 3:
				showPlaylistInfo(mcs, menuOption);
				break;
		}
	}

/**
* This method executes the method addSong after asking the user wich Playlist does he wants to add the song. <br>
*<b>Pos:</b>The method addSong has been done correctly<br>
*@param mcs is the app that is going to save all the data, mcs!=null.
*/
	public static void choosePlaylistOptionAddSong(Mcs mcs){
		int menuOption=entrada.nextInt();entrada.nextLine();
		switch(menuOption){
			case 1:
			case 2:
			case 3:
				addSongToPlaylist(mcs, menuOption);
				break;
		}
	}


/**
* This method add an existing song to a Playlist. <br>
*<b>Pos:</b>If the song existed, it has been added to the Playlist<br>
*@param mcs is the app that is going to save all the data, mcs!=null.
*/
	public static void addSongToPlaylist(Mcs mcs, int option){
		String userName, playlistName, songName;
		switch(option){
			case 1:
				System.out.println("Ingrese su nombre de usuario");
				userName=entrada.nextLine();
				System.out.println("Ingrese el nombre de la playlist privada");
				playlistName=entrada.nextLine();
				System.out.println("Ingrese el nombre de la cancion del pool de canciones");
				songName=entrada.nextLine();
				System.out.println(mcs.addSongToPrivatePlaylist(userName, playlistName, songName));
				break;
			case 2:
				System.out.println("Ingrese su nombre de usuario");
				userName=entrada.nextLine();
				System.out.println("Ingrese el nombre de la playlist restringida");
				 playlistName=entrada.nextLine();
				System.out.println("Ingrese el nombre de la cancion del pool de canciones");
				songName=entrada.nextLine();
				System.out.println(mcs.addSongToRestrictedPlaylist(userName, playlistName, songName));
				break;
			case 3:
				System.out.println("Ingrese el nombre de la playlist publica");
				 playlistName=entrada.nextLine();
				System.out.println("Ingrese el nombre de la cancion del pool de canciones");
				 songName=entrada.nextLine();
				System.out.println(mcs.addSongToPublicPlaylist(playlistName, songName));
				break;

		}

	}


/**
* This method assigns a grrade to a public Playlist <br>
*<b>Pos:</b>The grade of the public Playlist has been modified<br>
*@param mcs is the app that is going to save all the data, mcs!=null.
*/
	public static void assignGrade(Mcs mcs){
		System.out.println("Ingrese el nombre de la playlist publica que desea calificar");
		String playlistName=entrada.nextLine();
		String mensaje="";
		if (mcs.publicPlaylistExists(playlistName)==true){
			System.out.println("Ingrese la nota de la playlist "+playlistName);
			int grade=entrada.nextInt();entrada.nextLine();
			mensaje=mcs.setPlaylistGrade(grade, playlistName);
			System.out.println(mensaje+", nota actual de la playlist "+playlistName+"="+ mcs.returnPublicPlaylist(playlistName).getGrade());
			System.out.println("");
		}
		else{
			System.out.println("La playlist publica "+ playlistName +" no existe");
		}
		showMenu();
		chooseOption(mcs);
	}

}//END OF CLASS 