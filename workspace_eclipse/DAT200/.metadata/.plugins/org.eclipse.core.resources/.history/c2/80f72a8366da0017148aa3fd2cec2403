package mine_lister;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * Liste som holder elementene sine i sortert orden.
 */
public class SortertListe <T extends Comparable<? super T>> implements Iterable<T> {
	private ArrayList<T> elementene;
	
	public SortertListe() {
		elementene = new ArrayList<>();
	}
	
	/*
	 * Kjøretid O(n) siden addAny til ArrayList har
	 * O(n) kjøretid. addAny tilsvarer add(index, element).
	 * 
	 * Selve søket tar O(log(n)) tid.
	 * 
	 * Best case O(1) for å sette inn noe som er større
	 * enn alle andre elementer.
	 */
	public void add(T element) {
		// Sjekker om lista er tom. Setter inn nytt element først
		if (elementene.size() == 0) {
			elementene.add(element);
			return;
		}
				
		// Sjekker om nytt element skal inn først
		if (elementene.get(0).compareTo(element) >= 0) {
			elementene.add(0, element);
			return;
		}

		/*
		 *  Sjekker om nytt element skal inn sist
		 *  Hvis lista har kun ett element, skal det nye
		 *  elementet inn enten først eller sist
		 */		
		if (elementene.get(elementene.size()-1).compareTo(element) < 0) {
			elementene.add(element);
			return;
		}
		
		/* Binærsøk for å finne riktig sted å sette inn
		 * Denne virker bare hvis elementet ikke skal inn
		 * helt i starten eller helt på slutten. Sjekker
		 * derfor dette først
		 */
		int midt;
		int start = 0;
		int slutt = elementene.size() - 1;
		T foer, etter;
		while (true) {
			midt = start + (slutt - start)/2;
			foer = elementene.get(midt);
			etter = elementene.get(midt + 1);

			if (foer.compareTo(element) < 0 && etter.compareTo(element)>= 0) {
				// Har funnet stedet hvor man skal sette inn det nye elementet
				elementene.add(midt+1, element);
				return;
			} else {
				if (foer.compareTo(element) > 0) {
					slutt = midt;
				} else {
					start = midt;
				}
			}
		}
		
	}
	
	public T get(int index) {
		return elementene.get(index);
	}
	
	public T remove(int index) {
		return elementene.remove(index);
	}
	
	public Iterator<T> iterator() {
		return elementene.iterator();
	}
	
	/*
	 * Testemetode
	 */
	public static void main(String[] args) {
		SortertListe<Integer> lista = new SortertListe<>();
		lista.add(7);
		lista.add(3);
		lista.add(10);
		lista.add(5);
		lista.add(9);
		lista.add(-2);
		lista.add(1);
		lista.add(6);
		lista.add(17);
		lista.add(12);
		lista.add(11);
		for (Integer tall: lista) {
			System.out.println(tall);
		}
	}
}
