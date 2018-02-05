package mine_lister;

/*
 * F�rst inn f�rst ut k� (FIFO) basert p� ei lenket liste
 */
public class Koe <T> {
	private MinLenketeListe<T> lista;
	
	public Koe() {
		lista = new MinLenketeListe<>();
	}
	
	// Engelsk enqueue. addLast O(1) kj�retid
	public void ankomst(T objekt) {
		lista.add(objekt);
	}
	
	// Engelsk dequeue. removeFirst O(1) kj�retid
	public T taUt() {
		return lista.remove(0);
	}
	
	// getFirst
	public T forste() {
		return lista.get(0);
	}
	
	// getLast
	public T siste() {
		return lista.get(lista.size() - 1);
	}
}
