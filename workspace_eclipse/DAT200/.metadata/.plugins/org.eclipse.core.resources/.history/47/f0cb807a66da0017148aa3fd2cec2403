package mine_lister;

/*
 * Eksempel på en stabel implementert med ei liste
 */
public class Stabel <T> {
	// Bruker ArrayList da den er raskere på operasjoner
	// hvor de to listeimplementasjonene har samme O-notasjon
	MinArrayList<T> elementer;
	
	public Stabel() {
		elementer = new MinArrayList<>();
	}
	
	// Add last
	public void push(T element) {
		elementer.add(element);
	}
	
	// Remove last
	public T pop() {
		return elementer.remove(elementer.size() - 1);
	}
	
	// Get last
	public T peek() {
		return elementer.get(elementer.size() - 1);
	}
	
	// Brukes av løkkekonstruksjoner
	public boolean isEmpty() {
		return elementer.isEmpty();
	}
}
