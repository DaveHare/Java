package application;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javafx.stage.FileChooser;



public class objektserialisering {

	public static void skrivTilFil(Terningssett settet)throws EOFException, IOException, FileNotFoundException{
		
		try{ 
		FileChooser filvelger = new FileChooser();			
		File fila= filvelger.showOpenDialog(null);
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
