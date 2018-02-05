package finnelement;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * Denne klassen inneholder eksempler på Generics
 */
public class GenericsEksempler {
	
	// Finn Element i ei liste med heltall
	public static int finnElement(int element, int[] liste) {
		for (int i=0;i<liste.length;i++) {
			if (liste[i] == element) return i;
		}
		return -1;
	}

	// Finn element i liste med flyttall. Denne er nesten
	// identisk med den forrige
	public static int finnElement(double element, double[] liste) {
		for (int i=0;i<liste.length;i++) {
			if (liste[i] == element) return i;
		}
		return -1;
	}

/*  Finn element i ei liste med strenger. Denne er nesten
 * identisk med de to forrige. Den er kommentert ut for
 * å teste dne generiske versjonen. Hvis både en
 * generisk og en spesifikk metode passer med et
 * metodekall så velges i utgangspunktet den spesifikke.
 * 
	public static int finnElement(String element, String[] liste) {
		for (int i=0;i<liste.length;i++) {
			if (liste[i].equals(element)) return i;
		}
		return -1;
	}*/

	/*
	 * Generisk versjon av finnElement metoden, som
	 * kan brukes på lister av hvilken som helst type.
	 * Den har en typeparameter <T>. Hver gang metoden
	 * kalles så vil T erstattes med en type basert
	 * på metodekallet.
	 */
	public static <T> int finnElement(T element, T[] liste) {
		for (int i=0;i<liste.length;i++) {
			if (liste[i].equals(element)) return i;
		}
		return -1;	
	}
	
	/*
	 * Eksempel på generisk metode hvor returtypen er
	 * bestemt av typeparameteren
	 */
	public static <T> T midtersteVerdi(List<T> inn) {
		return inn.get(inn.size()/2);
	}
	
	/*
	 * Wildcard (?), betyr at man ikke bryr seg om
	 * typeparameteren til denne samlingen.
	 */
	public static void printCollection(Collection<?> c) {
		for (Object o: c) {
			System.out.println(c);
		}
	}
	
	/*
	 * Eksempel på typeparameter med begrensning.
	 * Denne metoden gir bare mening å bruke på samlinger
	 * av typer som arver fra Flyttbar.
	 */
	public static void flyttAlle(Collection<? extends Flyttbar> flyttbare, double deltax, double deltay) {
		for (Flyttbar f: flyttbare) {
			f.flytt(deltax, deltay);
		}
	}
	
	/*
	 * Et komplisert eksempel: Finn det største elementet
	 * i en samling av elementer. Les typeparameteren som:
	 *   Typeparameteren T må være en subtype av
	 *   Comparable av typen T eller en supertype av T.
	 * 
	 * Comparable grensesnittet er selv generisk, derfor
	 * hakeparenteser inni hakeparenteser.
	 */
	public static <T extends Comparable<? super T>> T max(List<T> samling) {
		T hoyeste = samling.get(0);
		for (T o: samling) {
			if (o.compareTo(hoyeste) > 0) hoyeste = o;
		}
		return hoyeste;
	}
	
	public static void main(String[] args) {
		// Tester finnElement med en array av strenger
		String[] elementene = {"en", "to", "tre", "fire"};
		System.out.println(finnElement("tre", elementene));
		
		// Et punkt og en array av strenger gir T som Object
		System.out.println(finnElement(new Point(3, 4), elementene));

		// Tester finnElement med en array av punkter
		Point[] punktene = new Point[3];
		punktene[0] = new Point(2, 3);
		punktene[1] = new Point(4, 3);
		punktene[2] = new Point(6, 3);
		System.out.println(finnElement(new Point(4, 3), punktene));
		
		// Tester midtersteVerdi
		ArrayList<String> strenger = new ArrayList<>();
		for (String s: elementene) strenger.add(s);
		String test = midtersteVerdi(strenger);
		
		ArrayList<Point> punkter = new ArrayList<>();
		for (Point p: punktene) punkter.add(p);
		Point tp = midtersteVerdi(punkter);
		
		// Tester printCollection
		printCollection(punkter);
		
		// Rå (raw) type: ArrayList uten typeparameter 
		ArrayList test2 = new ArrayList();
		
		/* Metodekall på max
		 * Disse vil feile (IndexOutOfBoundsException) 
		 * siden listene er tomme og max metoden
		 * som skrevet her ikke sjekker for dette
		 * spesialtilfellet.
		 * */
		ArrayList<Person> personer = new ArrayList<>();
		Person p = max(personer);
		
		ArrayList<Student> studenter = new ArrayList<>();
		Student s = max(studenter);
	}
	
	
}
