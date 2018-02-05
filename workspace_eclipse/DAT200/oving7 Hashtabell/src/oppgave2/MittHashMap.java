package oppgave2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/*
 * Eksempel HashMap implementasjon, uferdig.
 * 
 * Legg merke til at denne i motsetning til AVLTre implementerer
 * Map og ikke SortedMap samt at den ikke stiller noen
 * betingelse om sammenliknbarhet på nøkkelen.
 */
public class MittHashMap <K, V> implements Map<K, V> {
	public static final double FYLLINGSGRAD = 0.7;
	
	// Representerer et nøkkel - verdi par. Sammenliknes
	// på nøkkelen.
	private class Innslag {
		K nokkel;
		V verdi;
		
		public Innslag(K key, V value) {
			nokkel = key;
			verdi = value;
		}
		
		@Override public int hashCode() {
			return nokkel.hashCode();
		}
		
		@Override public boolean equals(Object o) {
			return nokkel.equals(o);
		}
	}
	
	private Object[] elementene;	// Array som inneholder elementene
	private int antallElementer;	// Antall elementer i lista nå
	
	/*
	 * På samme måte som en ArrayList trenger også et HashMap
	 * en startkapasitet
	 */
	public MittHashMap(int startkapasitet) {
		elementene = new Object[startkapasitet];
		antallElementer = 0;
		for (int i=0;i<elementene.length;i++) {
			elementene[i] = null;
		}
	}

	/*
	 * Kjøretid O(tabellstørrelse) siden den setter alle 
	 * referansene til null
	 */
	@Override
	public void clear() {
		antallElementer = 0;
		for (int i=0;i<elementene.length;i++) {
			elementene[i] = null;
		}
	}

	@Override
	public boolean containsKey(Object key) {
		if (get(key) != null) return true;
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Kjøretid O(1) best og average case, O(n) worst case på grunn av kvadratiskProving
	 */
	@Override
	public V get(Object key) {
		K nokkel = (K)key;
		int verdi = beregnPosisjon(nokkel);
		Innslag element = (Innslag)elementene[verdi];
		if (element == null) return null;
		if (nokkel.equals(element.nokkel) && element.verdi != null) {
			return element.verdi;
		}
		verdi = kvadratiskProving(nokkel);
		if (elementene[verdi] == null) return null;
		element = (Innslag)elementene[verdi];
		return element.verdi;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Kjøretid: O(n) ved utvidelse, O(1) ellers
	 * 
	 * Kjøretid for n innsettinger: O(n) + en utvidelse som er O(n)
	 * Amortized kjøretid for én innsetting er O(n)/n = O(1)
	 *
	@Override
	public V put(K key, V value) {
		if (antallElementer >= (elementene.length)*FYLLINGSGRAD) {
			utvidLista();
		}
		int posisjon = beregnPosisjon(key);
		Innslag element = (Innslag)elementene[posisjon];
		if (elementene[posisjon] == null) {
			elementene[posisjon] = new Innslag(key, value);
			antallElementer++;
		} else {
			posisjon = kvadratiskProving(key);
			if (elementene[posisjon] != null) {
				Innslag i = (Innslag)elementene[posisjon];
				V verdi = i.verdi;
				i.verdi = value;
				return verdi;
			}
			elementene[posisjon] = new Innslag(key, value);
			antallElementer++;
		}
		return null;
	}
	*/
	public V put(K key, V value) {
		if (antallElementer >= (elementene.length)*FYLLINGSGRAD) {
			utvidLista();
		}
		
		// Sjekk om nøkkelen allerede er i lista
		int posisjon = kvadratiskProving(key);
		Innslag element = (Innslag)elementene[posisjon];
		if (element != null) {
			V gammelVerdi = element.verdi;
			element.verdi = value;
			return gammelVerdi;
		}
		
		// Ellers sett inn på første ledige sted
		posisjon = forsteLedigeSted(key);
		if (elementene[posisjon] == null) {
			elementene[posisjon] = new Innslag(key, value);
			antallElementer++;
			return null;
		} else {
			element = (Innslag)elementene[posisjon];
			element.verdi = value;
			element.nokkel = key;
			antallElementer++;
			return null;
		}
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Kjøretid O(1)
	 */
	@Override
	public V remove(Object key) {
		K nokkel = (K)key;
		int verdi = beregnPosisjon(nokkel);
		if (elementene[verdi] == null) {
			return null;
		}
		Innslag i = (Innslag)elementene[verdi];
		if (i.nokkel.equals(nokkel)) {
			i.verdi = null;
		} else {
			verdi = kvadratiskProving(nokkel);
			i = (Innslag)elementene[verdi];
			if (i.nokkel.equals(nokkel)) {
				i.verdi = null;
				antallElementer--;
			}
		}
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	private int beregnPosisjon(K nokkel) {
		return nokkel.hashCode() % elementene.length;
	}
	
	/*
	 * Kjøretid typisk O(1), worst case O(n)
	 */
	private int kvadratiskProving(K nokkel) {
		int forsoksplass = beregnPosisjon(nokkel);
		int i = 0;
		Innslag innslaget = (Innslag)elementene[forsoksplass];
		while (elementene[forsoksplass] != null && !innslaget.nokkel.equals(nokkel)) {
			i++;
			// Fra beviset: For tabellengde som er et primtall så er de første
			// tabellengde/2 plassene unike.
			if (i > elementene.length/2) throw new RuntimeException("For full!");
			forsoksplass += 2*i-1;
			forsoksplass %= elementene.length;
			innslaget = (Innslag)elementene[forsoksplass];
		}
		return forsoksplass;
	}
	
	private int forsteLedigeSted(K nokkel) {
		int forsoksplass = beregnPosisjon(nokkel);
		int i = 0;
		Innslag innslaget = (Innslag)elementene[forsoksplass];
		while (elementene[forsoksplass] != null && !(innslaget.verdi == null)) {
			i++;
			// Fra beviset: For tabellengde som er et primtall så er de første
			// tabellengde/2 plassene unike.
			if (i > elementene.length/2) throw new RuntimeException("For full!");
			forsoksplass += 2*i-1;
			forsoksplass %= elementene.length;
			innslaget = (Innslag)elementene[forsoksplass];
		}
		return forsoksplass;
	}
	
	/*
	 * Utvider tabellen til størrelse lik det første primtallet høyere enn
	 * det dobbelte av gammel størrelse
	 * 
	 * Engelsk: Rehashing.
	 * 
	 * Kjøretid O(lengde på gammel liste)
	 * Ved 70% fylling O(n)
	 */
	private void utvidLista() {
		// Lagrer referanse til gammel liste
		Object[] gammelListe = elementene;
		
		// Lager ny liste
		int nyAntallElementer = elementene.length*2 + 1;
		while (!erPrimtall(nyAntallElementer)) nyAntallElementer+=2;
		
		// Erstatter gammel liste med tom ny liste i hovedstrukturen slik at jeg kan bruke
		// put() metoden
		elementene = new Object[nyAntallElementer];
		antallElementer = 0;
		for (Object o: gammelListe) {
			if (o != null) {
				Innslag i = (Innslag)o;
				if (i.verdi != null) put(i.nokkel, i.verdi);
			}
		}
	}
	
	private boolean erPrimtall(int tall) {
		for (int i=2;i<=Math.sqrt(tall);i++) {
			if (tall % i == 0) return false;
		}
		return true;
	}
	
	public void printTable() {
		for (int i=0;i<elementene.length;i++) {
			Innslag innslag = (Innslag)elementene[i];
			System.out.print(i + ": ");
			if (innslag == null) {
				System.out.println("null");
			} else {
				System.out.println(innslag.nokkel + ", " + innslag.verdi);
			}
		}
	}
	
	public static void main(String[] args) {
		MittHashMap<Integer, String> test = new MittHashMap<>(7);
		test.put(1, "en");
		test.put(2, "to");
		test.put(30, "tretti");
		test.put(14, "fjorten");
		test.put(10, "ti");
		test.put(2, "två");
		test.put(13, "tretten");
		test.put(25, "tjuefem");
		test.put(9, "ni");
		System.out.println(test.get(2));
		System.out.println(test.get(12));
		System.out.println(test.get(13));
		System.out.println(test.get(30));
		System.out.println(test.get(9));
		System.out.println(test.elementene.length);
		test.printTable();
		test.remove(30);
		System.out.println(test.get(13));
		test.printTable();
		test.put(47, "førtisju");
		System.out.println(test.get(13));
		System.out.println(test.get(47));
		test.printTable();
	}
}
