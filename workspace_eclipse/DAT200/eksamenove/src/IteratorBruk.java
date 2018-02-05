package iterator;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * Demonstrasjon på bruk av iteratorer, objekter som brukes for å gå gjennom
 * en samling (collection) element for element.
 */
public class IteratorBruk {

	public static void main(String[] args) {
		// Lager en ArrayList av elementer
		ArrayList<Integer> test = new ArrayList<>();
		test.add(10);
		test.add(8);
		test.add(12);
		test.add(10);
		test.add(9);
		
		// Lager en iterator over lista
		Iterator<Integer> iterator = test.iterator();
		
		// Går gjennom lista på tradisjonelt vis
		while (iterator.hasNext()) {
			int tall = iterator.next();
			System.out.println(tall);
		}
		
		// Ekvivalent for-each loop. for-each loopen bruker en iterator internt.
		for (Integer tall: test) {
			System.out.println(tall);			
		}
	}

}
