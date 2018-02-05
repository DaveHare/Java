package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;



public class LesData implements EventHandler<MouseEvent> {
	
	public static String filnavn= "personer.bin";
	public static String filnavn2= "hendelser.bin";
	public ArrayList<Person> personliste;
	public ArrayList<Hendelse> hendelser;
	
	@Override
	public void handle(MouseEvent event) {
		
			List<Person> results = new ArrayList<Person>();

			FileInputStream fis = null;
			try {
				fis = new FileInputStream(filnavn);
				while (true) {
					ObjectInputStream ois = new ObjectInputStream(fis);
					Person p=new Person(ois.readObject().toString());
					System.out.println(p);
					results.add(p);
				}
			} catch (ClassNotFoundException | IOException ignored) {
				// as expected
			} finally {
				if (fis != null)
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			System.out.println("results = " + results);
			personliste= (ArrayList<Person>)results;
			
			//Hendelse fil
			List<Hendelse> results2 = new ArrayList<Hendelse>();
//			ArrayList<Person> inviterte = new ArrayList<Person>();

			fis = null;
			try {
				fis = new FileInputStream(filnavn2);
				while (true) {
					ObjectInputStream ois = new ObjectInputStream(fis);
					Hendelse h=new Hendelse(((Hendelse) ois.readObject()).toString2());
					System.out.println(h);
					results2.add(h);
				}
			} catch (ClassNotFoundException | IOException ignored) {
				// as expected
			} finally {
				if (fis != null)
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			System.out.println("results = " + results2);
			hendelser= (ArrayList<Hendelse>)results2;
			System.out.println(hendelser);
		Main.setHendelser(hendelser);
	}

}
