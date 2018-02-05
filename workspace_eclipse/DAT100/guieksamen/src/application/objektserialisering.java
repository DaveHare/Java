package application;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javafx.stage.FileChooser;
import javafx.stage.Stage;



public class objektserialisering {

	public static void skrivTilFil(Terningssett settet, Stage primaryStage)throws EOFException, IOException, FileNotFoundException{
		
		try{ 
		FileChooser filvelger = new FileChooser();			
		File fila= filvelger.showOpenDialog(primaryStage);
		if (fila!=null) {
		FileOutputStream fos= new FileOutputStream(fila);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
				oos.writeObject(settet);
				oos.close();
				fos.close();
		}	
		}catch(EOFException e){
			System.out.println("Alle objekter er skrevte.");;
		}
		
		
		
		
		
	}
	
	
	
	
}
