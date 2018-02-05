package finnelement;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/*
 * Eksempel på hvorfor lister med ulike typeparametre
 * regnes som ikke kompatible selv om den ene typen
 * er en subtype av den andre. Tenk over hva som ville
 * skjed dhvis linja "List<Object> objektliste = strengliste;"
 * hadde kompilert her.
 */
public class CollectionDemo {

	public static void main(String[] args) {
		List<String> strengliste = new ArrayList<>();
		strengliste.add("to");
		List<Object> objektliste = strengliste;
		objektliste.add(new Point(3, 4));
		String streng = strengliste.get(1);
		
	}

}
