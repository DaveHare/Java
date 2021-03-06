package hendelse;



import stud5.Person;

public class Main {

	public static void main(String[] args) {
		Person testPerson1= new Person("Siri", "Mykland", 1992);
		Person testPerson2= new Person("Frida", "Erdal", 1994);
		Person testPerson3= new Person("Christine", "Valkner",1997);
		
		Hendelse h1 = new Hendelse(LocalDate.of(2017, 12, 22), LocalDate.of(2018, 01, 03), "Jul");
		Hendelse h2= new Hendelse(LocalDate.of(2017, 12, 31), LocalDate.of(2018, 01, 01), "Nytt�r");
		Hendelse h3 = new Hendelse(LocalDate.of(2018, 01, 04), LocalDate.of(2018, 01, 06), "Undervisningsstart");
		
		
		h1.leggTilPerson(testPerson1);
		h1.leggTilPerson(testPerson2);
		
		h2.leggTilPerson(testPerson1);
		h2.leggTilPerson(testPerson3);
		
		h3.leggTilPerson(testPerson3);
		h3.leggTilPerson(testPerson2);
		
	
		
		System.out.println(h1.kolliderer(h2));
		System.out.println(h2.kolliderer(h1, h3));
		
		System.out.println(h3.getInviterte().toString());
		
		 
		
	}

}
