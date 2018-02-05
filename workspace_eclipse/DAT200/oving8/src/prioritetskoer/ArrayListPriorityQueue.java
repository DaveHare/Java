package prioritetskoer;

import java.util.ArrayList;

/*
 * Implementasjon av en prioritetskø basert på en arraylist. Vist som en enkel
 * versjon av prioritetskø som likevel kan være brukbar hvis man har en algoritme
 * so trenger rask innsetting men ikke bryr seg om de andre operasjonene.
 */
public class ArrayListPriorityQueue <V> {
	private class Innslag {
		int prioritet;
		V verdi;
		
		public Innslag(int prioritet, V verdi) {
			this.prioritet = prioritet;
			this.verdi = verdi;
		}
	}
	
	private ArrayList<Innslag> innslagene = new ArrayList<>();
	
	// Kjøretid O(1)
	public void insert(int prioritet, V objekt) {
		innslagene.add(new Innslag(prioritet, objekt));
	}
	
	/*
	 * Kjøretid O(n)
	 */
	public V findMin() {
		int nvMin = innslagene.get(0).prioritet;
		V nvObjekt = innslagene.get(0).verdi;
		for (Innslag i: innslagene) {
			if (i.prioritet < nvMin) {
				nvMin = i.prioritet;
				nvObjekt = i.verdi;
			}
		}
		return nvObjekt;
	}
	
	/*
	 * Kjøretid O(n)
	 */
	public V removeMin() {
		int nvMin = innslagene.get(0).prioritet;
		V nvObjekt = innslagene.get(0).verdi;
		int minIndex = 0;
		for (int index=0;index<innslagene.size();index++) {
			Innslag i = innslagene.get(index);
			if (i.prioritet < nvMin) {
				nvMin = i.prioritet;
				nvObjekt = i.verdi;
				minIndex = index;
			}
		}
		innslagene.remove(minIndex);
		return nvObjekt;
	}
	
	/*
	 * Kjøretid O(1)
	 */
	public void decreaseKey(int index, int nyPrioritet) {
		Innslag i = innslagene.get(index);
		i.prioritet = nyPrioritet;
	}
	
	/*
	 * Kjøretid O(n). Gjør et sekvensielt søk.
	 */
	public void decreaseKey(V objekt, int nyPrioritet) {
		for (Innslag i: innslagene) {
			if (i.verdi.equals(objekt)) {
				i.prioritet = nyPrioritet;
			}
		}
	}
}
