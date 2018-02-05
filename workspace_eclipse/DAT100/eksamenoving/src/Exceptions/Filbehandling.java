package Exceptions;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Filbehandling {

	public static void SjekkFilInnhold(File fila)throws IOException, ClassNotFoundException{
		/*
		 * object o; instansvariabel
		 * try(fileinputstrem
		 * objectinputstream(input)){
		 * while(true){
		 * o=lese object
		 * }
		 * }catch EOFException
		 * 
		 */
		
		
		
		
		Object o;
		try(FileInputStream infile= new FileInputStream(fila);
				ObjectInputStream inobject= new ObjectInputStream(infile);){
			o= inobject.readObject();
			System.out.println(o.getClass());
			System.out.println(o);
		}catch(EOFException e){
			System.out.println("Ferdig med å lese!");
		}
	}
	
	
	
	
}
