package application;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;




public class Hendelse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Oppgave E
	private CharSequence beskrivelse;
	private LocalDate startDato;
	private LocalDate sluttDato;
	private ArrayList<Person> inviterte=null;
	private String string;


	// Definerer to konstruktører for Hendelse (frivillig)
	//	public Hendelse() {
	//		inviterte=new ArrayList<Person>();
	//	}

	public Hendelse(CharSequence beskrivelse1, LocalDate startDato, LocalDate sluttDato) {
		this.beskrivelse = beskrivelse1;
		this.startDato = startDato;
		setSluttDato(sluttDato);
		inviterte=new ArrayList<Person>();
	}

	public Hendelse(String string) {
		this.string = string;
		String[] del = string.split(", ");
		String part1 = del[0];
		beskrivelse=(CharSequence)part1;


		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String part2 = del[1];
		System.out.println(part2);
		startDato = LocalDate.parse(part2, formatter);

		String part3 = del[2];
		sluttDato=LocalDate.parse(part3, formatter);

		for(int i=3; i<del.length; i++ ){
			String partI= del[i];
			if(partI=="null"){
				break;
			}else{
				System.out.println(partI);
				for (int j=0;j<Main.getPersonliste().size(); j+=3){
					if(del[i]==Main.getPersonliste().get(j).getNavn()){
						inviterte.add(Main.getPersonliste().get(j));
					}
				}
			}
		}
	}

	// Oppgave F
	public CharSequence getBeskrivelse() {
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
			// Studentene har hatt basis unntakshåndtering, men jeg krever det ikke for denne øvingen.
			throw new IllegalArgumentException("En hendelse kan ikke slutte før den starter!");
		}
		this.startDato = startDato;
	}

	public LocalDate getSluttDato() {
		return sluttDato;
	}

	public void setSluttDato(LocalDate sluttDato) {
		// oppgave h)
		if (startDato != null && startDato.compareTo(sluttDato) > 0) {
			throw new IllegalArgumentException("En hendelse kan ikke slutte før den starter!");
		}
		this.sluttDato = sluttDato;
	}

	public String toString() {
		String resultat = "Hendelse: " + beskrivelse + "\n" +
				"Starter: " + startDato.toString() + " og slutter " + sluttDato.toString();
		return resultat;
	}
	public String toString2() {
		String resultat = beskrivelse+ ", "+ startDato.toString()+ ", "+ sluttDato.toString() +", "+ inviterte;
		return resultat;
	}

	// Oppgave 
	public boolean overlapper(Hendelse denAndreHendelsen) {
		LocalDate start2 = denAndreHendelsen.getStartDato();
		LocalDate slutt2 = denAndreHendelsen.getSluttDato();

		// Hendelse 1 slutter før hendelse 2 starter
		if (sluttDato.compareTo(start2) < 0) return false;

		// Hendelse 2 slutter før hendelse 1 starter
		if (slutt2.compareTo(startDato) < 0) return false;

		// Ellers overlapper de
		return true;
	}

	public static boolean overlapper(Hendelse hendelseEn, Hendelse hendelseTo) {
		LocalDate start1 = hendelseEn.getStartDato();
		LocalDate start2 = hendelseTo.getStartDato();
		LocalDate slutt1 = hendelseEn.getSluttDato();
		LocalDate slutt2 = hendelseTo.getSluttDato();

		// Hendelse 1 slutter før hendelse 2 starter
		if (slutt1.compareTo(start2) < 0) return false;

		// Hendelse 2 slutter før hendelse 1 starter
		if (slutt2.compareTo(start1) < 0) return false;

		// Ellers overlapper de
		return true;
	}
	// for  å kunne legge flere objekter i en hendelse
	// som her : enHendelse.leggTilPerson(personObjekt1, personObjekt2, personObjekt3);
	public void leggTilPerson(Person...personer){
		for(Person person : personer){
			inviterte.add(person);
			person.skalDeltaPaa(this);
		}
	}
	public void setNyInviterte(ArrayList<Person> nyGjesteListe){
		inviterte=nyGjesteListe;
	}


	// en liste over innviterte gjester til en hendelse.
	// Gjestene lagres i arraylisten liste:
	public ArrayList<Person> getInviterte() {
		return inviterte;
	}
}
