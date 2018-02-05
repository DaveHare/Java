package application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class LagreData implements EventHandler<MouseEvent> {
	
	public static String filnavn= "personer.bin";
	public static String filnavn2= "hendelser.bin";
	public ArrayList<Person> personliste;
	public ArrayList<Hendelse> hendelser;
	
	public LagreData(ArrayList<Person> personliste, ArrayList<Hendelse> hendelser){
		this.personliste= personliste;
		this.hendelser= hendelser;
	}

	@Override
	public void handle(MouseEvent arg0) {

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filnavn,false);
			for (Person p : personliste) {
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(p);
				System.out.println("Personen er skrevet.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		//Hendelse fil
		fos = null;
		try {
			fos = new FileOutputStream(filnavn2,false);
			for (Hendelse h : hendelser) {
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(h);
				System.out.println("hendelsen er skrevet.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}





	}

}
