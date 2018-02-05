import java.time.LocalDate;

public class personHendelseTest {

	public personHendelseTest() {

	}

	public static void main(String[] args) {
		/*
		 * Lag en main metode som demonstrerer bruken av
		 * hendelser og personer. Lag minst to hendelser
		 * og minst tre personer som deltar på minst én 
		 * hendelse hver, og skriv ut informasjon om dem.
		 */
		
// opprette hendelser av classen Hendelse
		Hendelse feeezt = new Hendelse("Fest hos Lukas", LocalDate.now(), LocalDate.now());
		Hendelse party = new Hendelse("Partey hos kell", LocalDate.now(),LocalDate.now());


	// personer
		Person personObjekt1 = new Person(111,"Siri", "Mykland", 1996);
		Person personObjekt2 = new Person(112,"Sara", "land", 1997);
		Person personObjekt3 = new Person(113,"Ary", "Fjell", 1999);
		
		// diss skal på hendelsene
		feeezt.leggTilPerson(personObjekt1, personObjekt2, personObjekt3);
		party.leggTilPerson(personObjekt2,personObjekt3);

// skrive ut 
		System.out.println(feeezt+ "\n");
		System.out.println(party+ "\n");


	}
}
