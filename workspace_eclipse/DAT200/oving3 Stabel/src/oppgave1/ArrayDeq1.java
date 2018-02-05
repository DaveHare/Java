package oppgave1;



import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ArrayDeq1 <T> implements List<T> {

	private Object[] elementene;	// Array som inneholder elementene
	private int antallElementer;// Antall elementer i lista nå
	private int startbuffer;


	public ArrayDeq1(int startbuffer, int startstørrelse) {
		this.startbuffer= startbuffer;
		elementene = new Object[startbuffer+startstørrelse];
		antallElementer = 0;
	}

	// O(1)
	@Override
	public boolean add(T e) {
		if(elementene.length == startbuffer + antallElementer){
			utvidSiste();
		}
		if(antallElementer < elementene.length){
			elementene[antallElementer+startbuffer] = e;
			antallElementer++;
		}
		return true;
	}

	//O(antall elementer som må flyttes)
	// worstcase: O(n/2)
	// average case: O(n)
	@Override
	public void add(int index, T element) {
		if(index > antallElementer)	throw new IndexOutOfBoundsException("Index er ugyldig.");

		if(index== antallElementer){
			add(element);
		}
		if(index==0){
			addFirst(element);
		}

		if(index>= antallElementer/2){
			if(elementene.length == startbuffer + antallElementer){
				utvidSiste();
			}
			for(int i=antallElementer+startbuffer-1;i>=index;i--){
				elementene[i+1]=elementene[i];
			}	
			elementene[index+startbuffer]=element;	
			antallElementer++;
			startbuffer--;
		}

	}

	//  O(n) for-løkken
	public void utvidFørste(){

		System.out.println("buffer=0, utvider");
		Object[] tempElementene = elementene; 
		elementene = new Object[(int)(tempElementene.length *2 +1) ]; 
		int nybuffer = tempElementene.length;
		for (int i = 0; i < tempElementene.length; i++) { 
			System.out.println(tempElementene[i] + ", ");
			elementene[nybuffer + i] = tempElementene[i]; 
			startbuffer= nybuffer;
		}
	}

	//O(1) amorterized
	public boolean addFirst(T element) {
		if (startbuffer == 0) {
			utvidFørste();
		}
		startbuffer--;
		elementene[startbuffer] = element;
		antallElementer++;
		return true;

	}

	//  O(n) for if-løkken
	public void utvidSiste(){

		Object[] nyliste = new Object[length()*2];
		System.out.println("utvidet bak.");
		int i=0;
		for(Object dataen: elementene){
			i++;
			nyliste[i+startbuffer]=dataen;
		}	
		elementene=nyliste;	

	}
	/*
	 * O(1) for hvis løkken ikke er true
	 */
	public void addLast(T element){
		if(elementene.length == startbuffer + antallElementer){
			utvidSiste();
		}
		elementene[antallElementer+startbuffer]=element;
		antallElementer++;
	}

	/*
	 * O(1)
	 */
	@Override
	public void clear() {
		elementene = new Object[elementene.length];
		antallElementer = 0;
	}


	/*
	 * O(1)
	 */
	@Override
	public T get(int index) {
		return (T)elementene[index+startbuffer];
	}


	/*
	 * O(n)
	 */
	@Override
	public int indexOf(Object o) {

		for (int index = startbuffer;index < antallElementer;index++) {
			if (elementene[index].equals(o)) return index;
		}
		return -1;
	}

	/*
	 * O(1)
	 */
	@Override
	public boolean remove(Object o) {

		int index = indexOf(o);
		if (index == -1) return false;
		remove(index);
		return true;
	}

	//O(antall elementer som må flyttes)
	// worstcase: O(n/2)
	// average case: O(n)
	@Override
	public T remove(int index) {
		T element = (T)elementene[index+startbuffer];
		if(index>=antallElementer/2){
			index+=startbuffer;

			for (int i=index+startbuffer;i<antallElementer+startbuffer;i--) {
				elementene[i] = elementene[i+1];
			}

		}else{
			for (int i=index+startbuffer;i<startbuffer;i++) {
				elementene[i] = elementene[i-1];
			}

		}

		antallElementer--;
		System.out.println("fjernet: "+element);

		return element;
	}

	/*
	 * O(1)
	 */
	@Override
	public T set(int index, T element) {
		index+=startbuffer;
		T resultat = (T)elementene[index];
		elementene[index] = element;
		return resultat;
	}
	/*
	 * O(n)
	 */
	public String toString(){

		String resultat = "";
		for(int i =startbuffer; i<length(); i++){
			resultat+=i-startbuffer +"-"+ elementene[i]+", ";
		}
		return resultat;
	}

	/*
	 * O(1)
	 */
	public int getAntElementer(){
		return antallElementer;
	}

	/*
	 * O(1)
	 */
	public int length() {
		return elementene.length;
	}



	// ------------------------------------------------------
	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
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


	@Override
	public int size() {
		return elementene.length;
	}
}






