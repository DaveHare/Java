package Exceptions;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		String filnavn= "C:\\Users\\sirim\\workspace";
		
		File fila=new File(filnavn);
		try{
			Filbehandling.SjekkFilInnhold(fila);
		}catch(IOException e){
			System.err.println("Et problem oppstod under lesing av fila:");
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			System.err.println("Fila inneholdt et object av ukjent klasse:");
			e.printStackTrace();
		}
		
	}

}
