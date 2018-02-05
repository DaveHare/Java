package Exceptions;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class fillesning {

	public static void lesFilObjekter(File fila)throws ClassNotFoundException, 
	FileNotFoundException, IOException{
		Object o;
	try(FileInputStream fis= new FileInputStream(fila);
		ObjectInputStream ois = new ObjectInputStream(fis)){
		while(true){
			o=ois.readObject();
			System.out.println(o.getClass());
			System.out.println(o);
		}
		
		
	}catch(EOFException e){
		System.out.println("Ferdig med å lese filen");
	}
		
	}
	
	
	
	
	
	
}
