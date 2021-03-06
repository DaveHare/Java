import java.time.LocalDate;
import java.util.ArrayList;


public class Hendelse {
	// Oppgave E
	private String beskrivelse;
	private LocalDate startDato;
	private LocalDate sluttDato;
	private ArrayList inviterte;



	// Definerer to konstrukt�rer for Hendelse (frivillig)
	public Hendelse() {
		inviterte=new ArrayList();
	}

	public Hendelse(String beskrivelse, LocalDate startDato, LocalDate sluttDato) {
		this.beskrivelse = beskrivelse;
		this.startDato = startDato;
		setSluttDato(sluttDato);
		inviterte=new ArrayList();
	}

	// Oppgave F
	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public LocalDate getStartDato() {
		return startDato;
	}

	public void setStartDato(LocalDate startDato) {
		// oppgave h)
		if (sluttDato != null && startDato.compareTo(sluttDato) > 0) {
			// Studentene har hatt basis unntaksh�ndtering, men jeg krever det ikke for denne �vingen.
			throw new IllegalArgumentException("En hendelse kan ikke slutte f�r den starter!");
		}
		this.startDato = startDato;
	}

	public LocalDate getSluttDato() {
		return sluttDato;
	}

	public void setSluttDato(LocalDate sluttDato) {
		// oppgave h)
		if (startDato != null && startDato.compareTo(sluttDato) > 0) {
			throw new IllegalArgumentException("En hendelse kan ikke slutte f�r den starter!");
		}
		this.sluttDato = sluttDato;
	}

	public String toString() {
		String resultat = "Hendelse " + beskrivelse + "\n" +
				"Starter: " + startDato.toString() + " og slutter " + sluttDato.toString()
				+ "\n" + liste();

		return resultat;
	}

	// Oppgave 
	public boolean overlapper(Hendelse denAndreHendelsen) {
		LocalDate start2 = denAndreHendelsen.getStartDato();
		LocalDate slutt2 = denAndreHendelsen.getSluttDato();

		// Hendelse 1 slutter f�r hendelse 2 starter
		if (sluttDato.compareTo(start2) < 0) return false;

		// Hendelse 2 slutter f�r hendelse 1 starter
		if (slutt2.compareTo(startDato) < 0) return false;

		// Ellers overlapper de
		return true;
	}

	public static boolean overlapper(Hendelse hendelseEn, Hendelse hendelseTo) {
		LocalDate start1 = hendelseEn.getStartDato();
		LocalDate start2 = hendelseTo.getStartDato();
		LocalDate slutt1 = hendelseEn.getSluttDato();
		LocalDate slutt2 = hendelseTo.getSluttDato();

		// Hendelse 1 slutter f�r hendelse 2 starter
		if (slutt1.compareTo(start2) < 0) return false;

		// Hendelse 2 slutter f�r hendelse 1 starter
		if (slutt2.compareTo(start1) < 0) return false;

		// Ellers overlapper de
		return true;
	}
	// for  � kunne legge flere objekter i en hendelse
	// som her : enHendelse.leggTilPerson(personObjekt1, personObjekt2, personObjekt3);
	public void leggTilPerson(Person...personer){
		for(Person person : personer){
			inviterte.add(person);
			person.skalDeltaPaa(this);
		}
	}
	// en liste over innviterte gjester til en hendelse.
	// Gjestene lagres i arraylisten liste:
	public ArrayList liste() {
		return inviterte;
	}
}
