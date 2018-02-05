package oppgave1;

public class MinArrayList<T>{
	private Object[] elementene;
	private int buffer;
	private int antallElementer; //antall elemnter i listen
	
	public void printAll() {
		for(Object o: elementene) {
			System.out.print((o== null ? "null" : o.toString()) + ", ");
		}
	}
	
	public MinArrayList() {
		antallElementer = 0;
		elementene =  new Object[10];
		buffer =  3;
	}

	/*public int size() { 
		return antallElementer; 
	}*/
	
	/*public boolean add(Object x) { 
		elementene[antallElementer++] = x; 
		return true; 
	}*/
	
	public void addFirst(Object x) { 
		checkFirst();
		buffer--;
		elementene[buffer] = x;
		antallElementer++;
	}
	
	public void addLast(Object x) { 
		checkLast();
		System.out.println(antallElementer);
		elementene[buffer + antallElementer] = x;  
		antallElementer++; 
	}
	
	public void add(int index, Object x) {  
		if (index < buffer || index > buffer + antallElementer)   throw new ArrayIndexOutOfBoundsException("Må være en plass mellom " + buffer + " og " + buffer + antallElementer);   
		elementene[index] = x;  
		//antallElementer++;  
	}
	
	public Object remove(int index) {   
		if (index < 0 || index >= buffer + antallElementer) throw new ArrayIndexOutOfBoundsException("Må være en plass mellom " + buffer + " og " + buffer + antallElementer);   
		Object removedItem = elementene[index];   
		for (int i = index; i < elementene.length - 1; i++) {    
			elementene[i] = elementene[i + 1];    
		}
			antallElementer--; 
			return removedItem; 
	}
	
	public Object get(int index) {
		if (index < 0 || index >= elementene.length) throw new ArrayIndexOutOfBoundsException("Må være en plass mellom 0 og " + elementene.length); 
		Object elementet = elementene[buffer + index];
		System.out.println(elementet);
		return elementet;
	}
	
	public void checkFirst() {
		if (buffer == 0) {
			Object[] old = elementene; 
			elementene = new Object[elementene.length * 2 + 1]; 
			for (int i = 0; i < old.length; i++) { 
				//System.out.println(old[i] + ", ");
				elementene[old.length + i] = old[i]; 
				} 
			buffer = old.length;
		}
	}
	private void checkLast() { 

		if (elementene.length == buffer + antallElementer) {
			Object[] old = elementene; 
			elementene = new Object[elementene.length * 2 + 1]; 
			for (int i = 0; i < old.length; i++) { 
				elementene[i] = old[i]; 
				} 
			} 
		}
}
