package naiv;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

/*
 * Sortes set implementasjon basert på en ArrayList som holdes sortert.
 */
public class NaivSortedSet <T extends Comparable<? super T>> implements SortedSet<T> {
	private ArrayList<T> lista;
	
	public NaivSortedSet() {
		lista = new ArrayList<>();
	}

	/*
	 * Bruker binærsøk for å finne ut hvor i lista elementet skal settes inn,
	 * og setter det inn der.
	 * 
	 * Kjøretid O(n) på grunn av at addAny på en ArrayList kjører i O(n) tid.
	 * 
	 */
	@Override
	public boolean add(T arg0) {
		if (lista.isEmpty()) {
			lista.add(arg0);
			return true;
		}
		int index = RekursivBinaersoek.binaerSoekNaermesteOver(lista, arg0);
		if (index == lista.size()) {
			lista.add(arg0);
			return true;
		}
		if (lista.get(index).equals(arg0)) return false;
		lista.add(index, arg0);
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		lista.clear();
	}

	/* Bruker binærsøk for å finne elementet i lista og returnerer true hvis den finner
	 * elementet og false ellers.
	 * 
	 * Kjøretid O(log(n))
	 */
	@Override
	public boolean contains(Object arg0) {
		T objekt = (T)arg0;
		if (lista.isEmpty()) return false;
		int i=RekursivBinaersoek.binaerSoek(lista, objekt);
		if (i != -1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return lista.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return lista.iterator();
	}

	/*
	 * Bruker binærsøk for å finne ut om elementet er i lista og fjerner det hvis det er
	 * i lista.
	 * 
	 * Kjøretid O(n) for removeAny på en ArrayList hvis elementet er i mengden,
	 *    O(log(n)) for binærsøk hvis elementet ikke er i mengden.
	 */
	@Override
	public boolean remove(Object arg0) {
		T objekt = (T)arg0;
		if (lista.isEmpty()) return false;
		int i=RekursivBinaersoek.binaerSoek(lista, objekt);
		if (i != -1) {
			lista.remove(i);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return lista.size();
	}

	@Override
	public Object[] toArray() {
		return lista.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return lista.toArray(arg0);
	}

	@Override
	public Comparator<? super T> comparator() {
		return null; // Bruker natural ordering, så denne metoden skal returnere null
	}

	/*
	 * Kjøretid O(1)
	 */
	@Override
	public T first() {
		return lista.get(0);
	}

	@Override
	public SortedSet<T> headSet(T arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Kjøretid O(1)
	 */
	@Override
	public T last() {
		return lista.get(lista.size() - 1);
	}
	
	/*
	 * Kjøretid O(1)
	 */
	public T kFirst(int k) {
		return lista.get(k);
	}
	
	/*
	 * Finn det første elementet som er større enn oppgitt element. Returnerer
	 * null hvis det ikke finnes et større element i lista.
	 * 
	 * kjøretid O(log(n)) fra binærsøk
	 */
	public T findNext(T element) {
		int i=RekursivBinaersoek.binaerSoekNaermesteOver(lista, element);
		if (i == lista.size()) return null;
		if (lista.get(i).equals(element)) {
			return lista.get(i+1);
		} else {
			if (lista.get(i).compareTo(element) < 0) {
				return lista.get(i+1);
			} else {
				return lista.get(i);
			}
		}
	}

	@Override
	public SortedSet<T> subSet(T arg0, T arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<T> tailSet(T arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		NaivSortedSet<Integer> test = new NaivSortedSet<>();
		test.add(5);
		test.add(11);
		test.add(15);
		test.add(-5);
		test.add(1);
		test.add(9);
		test.add(11);
		test.add(14);
		for (int tallet: test) {
			System.out.println(tallet);
		}
		System.out.println(test.contains(7));
		System.out.println(test.contains(9));		
		System.out.println(test.contains(-8));
		System.out.println(test.contains(-5));		
		System.out.println(test.contains(20));
		System.out.println(test.contains(15));
		
		test.remove(9);
		test.add(12);
		for (int tallet: test) {
			System.out.println(tallet);
		}
		
		System.out.println(test.findNext(1));
		System.out.println(test.findNext(10));
		System.out.println(test.findNext(-10));
		System.out.println(test.findNext(50));
	}
}
