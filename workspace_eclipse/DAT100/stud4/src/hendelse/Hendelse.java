package hendelse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.stream.events.StartDocument;

import stud5.Person;

/*
 * Utdelt kode for �ving 4
 */
public class Hendelse {
	private String beskrivelse;  
	private LocalDate startDato; 
	private LocalDate sluttDato;
	private ArrayList<Person> inviterte;
	
	public Hendelse() {
		startDato = LocalDate.now();
		sluttDato = LocalDate.now();
		beskrivelse = "";
		inviterte=new ArrayList<Person>();
	}
	
	public Hendelse(LocalDate startDato, LocalDate sluttDato, String beskrivelse) {
		this.startDato = startDato;
		this.sluttDato = sluttDato;
		this.beskrivelse = beskrivelse;
		inviterte=new ArrayList<Person>();
	}
		
	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}
	
	public LocalDate getStartDato() {
		return startDato;
	}
	
	public void setStartDato(LocalDate startDato) throws IllegalArgumentException {
		if (sluttDato != null && sluttDato.isBefore(startDato)) {
			throw new IllegalArgumentException("Startdato kan ikke v�re etter sluttdato!");
		}
		this.startDato = startDato;
	}
	
	public LocalDate getSluttDato() {
		return sluttDato;
	}
	
	public void setSluttDato(LocalDate sluttDato) throws IllegalArgumentException {
		if (startDato != null && sluttDato.isBefore(startDato)) {
			throw new IllegalArgumentException("Sluttdato kan ikke v�re f�r startdato!");
		}
		this.sluttDato = sluttDato;
	}
	
	public String toString() {
		return "Hendelsen \"" + beskrivelse + "\" starter p� " + 
				startDato.toString() + " og slutter p� " + sluttDato.toString();
	}	
	
	/*
	 * Metode som tester om to hendelser kolliderer. Denne versjonen er
	 * en statisk metode som tar inn to hendelser.
	 * 
	 * Merk: Hendelser som "m�tes" (den ene slutter samme
	 * dan som den andre starter) rapporteres som at de ikke
	 * kolliderer
	 */
	public static boolean kolliderer(Hendelse en, Hendelse to) {
		LocalDate start1 = en.getStartDato();
		LocalDate start2 = to.getStartDato();
		LocalDate slutt1 = en.getSluttDato();
		LocalDate slutt2 = to.getSluttDato();
		if (slutt1.equals(start2)) return false;
		if (start1.equals(slutt2)) return false;
		if (slutt1.isBefore(start2)) {
			return false;
		}
		if (slutt2.isBefore(start1)) {
			return false;
		}
		return true;
	}
	
	/*
	 * Alternativ m�te � sjekke om to hendelser kolliderer. Denne metoden er
	 * en instansmetode. Den gj�r det samme som den andre Kolliderer metoden,
	 * men brukes annerledes. Se enhetstestene for hvordan de to metodene skal
	 * brukes.
	 */
	public boolean kolliderer(Hendelse denAndre) {
		LocalDate start2 = denAndre.getStartDato();
		LocalDate slutt2 = denAndre.getSluttDato();
		if (sluttDato.equals(start2)) return false;
		if (startDato.equals(slutt2)) return false;
		if (sluttDato.isBefore(start2)) {
			return false;
		}
		if (slutt2.isBefore(startDato)) {
			return false;
		}
		return true;		
	}
	
	public void leggTilPerson(Person nyPerson){
		System.out.println(nyPerson);
		inviterte.add(nyPerson);	
		nyPerson.skalDeltaPaa(this);
	}
	public ArrayList<Person> getInviterte(){
		return inviterte;
	}
}
