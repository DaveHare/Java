package mine_lister;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * Lenket liste: Implementasjon av List grensesnittet gjennom bruk av lenkete
 * elementer. Denne implementasjonen er en dobbeltlenket liste hvor hvert element har
 * referanser til både forrige og neste element. Den bruker 3 ganger så mye plass
 * som en ArrayList med samme antall elementer. En enkeltlenket liste har bare
 * referanser framover og tar 50% mindre plass, men støtter ikke navigasjon
 * bakover i lista.
 * 
 * Plassbruk: Tre referanser kontra én for ArrayList gjør at denne krever 3 ganger så
 * mye plass.
 */
public class MinLenketeListe <T> implements List<T> {
	
	/*
	 * Indre klasse for elementene i lista. Dette er en rein datastruktur og trenger derfor
	 * ikke erklære variablene sine private.
	 */
	private class ListeElement {
		T verdi;
		ListeElement forrige;
		ListeElement neste;
	}
	
	private ListeElement start;
	private ListeElement slutt;
	private int storrelse;
	
	public MinLenketeListe() {
		start = new ListeElement(); // Dummy elementer som er med for å gjøre algoritmene enklere.
		slutt = new ListeElement();
		
		storrelse = 0;
		
		start.neste = slutt;
		slutt.forrige = start;
		start.forrige = null;
		slutt.neste = null;
	}

	/*
	 * Kjøretid Theta(1) alltid, men har høyere konstantledd enn ArrayList sin.
	 */
	@Override
	public boolean add(T e) {
		ListeElement tidligereSiste = slutt.forrige;
		
		ListeElement nySiste = new ListeElement();
		nySiste.verdi = e;
		nySiste.forrige = tidligereSiste;
		nySiste.neste = slutt;
		
		tidligereSiste.neste = nySiste;
		slutt.forrige = nySiste;
		
		storrelse++;
		return true;
	}
	
	/*
	 * Hjelpemetode som brukes av mange metoder i den lenkete lista for å
	 * finne elementet med en oppgitt indeks. Kjøretida dens dominerer
	 * i mange av disse tilfellene.
	 * 
	 * Kjøretid O(indeks)
	 * Worst case og average case O(n)
	 * Best case - første og siste element - O(1)
	 */
	private ListeElement finnElementPaaIndeks(int indeks) {
		if (indeks < 0 || indeks >= storrelse) throw new IndexOutOfBoundsException();
		ListeElement nvElement = null;
		if (indeks > storrelse/2) {
			nvElement = slutt.forrige;
			int posisjon = storrelse-1;
			while (posisjon > indeks) {
				nvElement = nvElement.forrige;
				posisjon--;
			}			
		} else {
			nvElement = start.neste;
			int posisjon = 0;
			while (posisjon < indeks) {
				nvElement = nvElement.neste;
				posisjon++;
			}
		}
		return nvElement;
	}

	/*
	 * Kjøretid: O(n) pga. finnElementPaaIndeks
	 */
	@Override
	public void add(int index, T element) {
		ListeElement elementPaaIndex = finnElementPaaIndeks(index);
		
		ListeElement nyElement = new ListeElement();
		nyElement.verdi = element;
		nyElement.forrige = elementPaaIndex.forrige;
		nyElement.neste = elementPaaIndex;
		
		elementPaaIndex.forrige = nyElement;
		nyElement.forrige.neste = nyElement;
		
		storrelse++;
	
	}
	
	/*
	 * Kjøretid O(1)
	 */
	public void addFirst(T element) {
		ListeElement tidligereForste = start.neste;
		
		ListeElement nyForste = new ListeElement();
		nyForste.verdi = element;
		nyForste.forrige = start;
		nyForste.neste = tidligereForste;
		
		tidligereForste.forrige = nyForste;
		start.neste = nyForste;
		
		storrelse++;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * Kjøretid naiv: O(m*n)
	 * 
	 * Kjøretid optimal: O(m + n)
	 */
	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		/*for (T objekt: c) {
			add(index, objekt);
		}*/
		
		ListeElement posisjon = finnElementPaaIndeks(index);
		for (T objekt: c) {
			ListeElement nyElement = new ListeElement();
			nyElement.verdi = objekt;
			nyElement.forrige = posisjon.forrige;
			nyElement.neste = posisjon;
			
			posisjon.forrige = nyElement;
			nyElement.forrige.neste = nyElement;
			
			storrelse++;
		}
		
		return false;
	}

	/*
	 * O(1) kjøretid med garbage collector, Garbage collectoren må bruke O(n) tid!
	 * 
	 * O(n) kjøretid uten garbage collector for å slette hvert element for seg.
	 */
	@Override
	public void clear() {
		storrelse = 0;
		
		start.neste = slutt;
		slutt.forrige = start;
	}

	/*
	 * Kjøretid O(n) pga. bruk av indexOf.
	 */
	@Override
	public boolean contains(Object o) {
		if (indexOf(o) != -1) return true;
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * Kjøretid:
	 *   Get first: O(1)
	 *   Get last: O(1)
	 *   Get any: O(n) pga. finnElementPaaIndeks
	 */
	@Override
	public T get(int index) {
		if (index == 0) {
			return start.neste.verdi;
		}
		if (index == storrelse-1) {
			return slutt.forrige.verdi;
		}
		ListeElement elementet = finnElementPaaIndeks(index);
		
		if (elementet != null) return elementet.verdi;
		return null;
	}

	/*
	* Kjøretid O(n) med sekvensielt søk
	 */
	@Override
	public int indexOf(Object o) {
		ListeElement nvElement = start.neste;
		int posisjon = 0;
		while (posisjon < storrelse) {
			if (nvElement.verdi.equals(o)) {
				return posisjon;
			}
			nvElement = nvElement.neste;
			posisjon++;
		}
		return -1;
	}

	// Kjøretid O(1)
	@Override
	public boolean isEmpty() {
		if (storrelse == 0) return true;
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new MinIterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * Kjøretid O(1)
	 */
	private void removeElement(ListeElement elementet) {
		ListeElement forrige = elementet.forrige;
		ListeElement neste = elementet.neste;
		forrige.neste = neste;
		neste.forrige = forrige;
		storrelse--;
	}

	/*
	 * Kjøretid: O(n)
	 */
	@Override
	public boolean remove(Object o) {
		ListeElement nvElement = start.neste;
		int posisjon = 0;
		while (posisjon < storrelse) {
			if (nvElement.verdi.equals(o)) {
				removeElement(nvElement);
				return true;
			}
			nvElement = nvElement.neste;
			posisjon++;
		}
		return false;
	}

	/*
	 * Kjøretid: O(n) pga. finnElementPaaIndeks
	 */
	@Override
	public T remove(int index) {
		ListeElement elementet = finnElementPaaIndeks(index);
		removeElement(elementet);
		return elementet.verdi;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * Kjøretid O(n) pga. finnElementPaaIndeks
	 */
	@Override
	public T set(int index, T element) {
		ListeElement elementet = finnElementPaaIndeks(index);
		T gammelVerdi = elementet.verdi;
		elementet.verdi = element;
		return gammelVerdi;
	}

	@Override
	public int size() {
		return storrelse;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class MinIterator implements Iterator<T> {
		
		private ListeElement posisjon;
		
		public MinIterator() {
			posisjon = start;
		}

		@Override
		public boolean hasNext() {
			if (posisjon.neste != slutt) return true;
			return false;
		}

		@Override
		public T next() {
			posisjon = posisjon.neste;
			return posisjon.verdi;
		}
	}

	private class MinListeIterator implements ListIterator<T> {
		
		private ListeElement posisjon;
		
		public MinListeIterator() {
			posisjon = start;
		}

		@Override
		public void add(T e) {
			ListeElement forrige = posisjon.forrige;
			
			ListeElement nyElement = new ListeElement();
			nyElement.verdi = e;
			nyElement.forrige = forrige;
			nyElement.neste = posisjon;
			
			forrige.neste = nyElement;
			posisjon.forrige = nyElement;
			
			storrelse++;
		}

		@Override
		public boolean hasNext() {
			if (posisjon.neste != slutt) return true;
			return false;
		}

		@Override
		public T next() {
			posisjon = posisjon.neste;
			return posisjon.verdi;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public T previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void remove() {
			removeElement(posisjon);
		}

		@Override
		public void set(T e) {
			posisjon.verdi = e;
		}
		
	}
	
	public static void main(String[] args) {
		List<String> strengliste = new MinLenketeListe<>();
		strengliste.add("En");
		strengliste.add("tre");
		strengliste.add("fire");
		strengliste.add("fem");
		strengliste.add("ergg");
		strengliste.add("tradgade");
		strengliste.add("fiadgre");
		
		for (String streng: strengliste) {
			System.out.println(streng);
		}

	}
}
