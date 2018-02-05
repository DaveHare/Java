package prioritetskoer;

import java.util.ArrayList;

/*
 * Implementasjon av en prioritetsk� basert p� en arraylist. Vist som en enkel
 * versjon av prioritetsk� som likevel kan v�re brukbar hvis man har en algoritme
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
	
	// Kj�retid O(1)
	public void insert(int prioritet, V objekt) {
		innslagene.add(new Innslag(prioritet, objekt));
	}
	
	/*
	 * Kj�retid O(n)
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
	 * Kj�retid O(n)
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
	 * Kj�retid O(1)
	 */
	public void decreaseKey(int index, int nyPrioritet) {
		Innslag i = innslagene.get(index);
		i.prioritet = nyPrioritet;
	}
	
	/*
	 * Kj�retid O(n). Gj�r et sekvensielt s�k.
	 */
	public void decreaseKey(V objekt, int nyPrioritet) {
		for (Innslag i: innslagene) {
			if (i.verdi.equals(objekt)) {
				i.prioritet = nyPrioritet;
			}
		}
	}
}
