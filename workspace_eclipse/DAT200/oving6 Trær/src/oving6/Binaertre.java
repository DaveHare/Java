package oving6;


import java.util.Iterator;
import java.util.Stack;


/*
 * Start på enimplementasjon av binærtre
 */
public class Binaertre <T> {
	private class Binaertrenode {
		T objekt;
		Binaertrenode venstrebarn;
		Binaertrenode hoyrebarn;
//		Binaertrenode forelder;
	}

	/*
	 * Med utgangspunkt i binærtreimplementasjonen fra timen 
	 * (Binaertre eller BinaertSoketre, velg selv), skriv en 
	 * rekursiv metode som beregner antall bladnoder i treet.
	 */
	private int count(Binaertrenode noden) {
		Binaertrenode element1 = noden.venstrebarn;
		Binaertrenode element2 = noden.hoyrebarn;

		if( element1 == null && element2 == null ) return 1;
		if( element1 == null ) return 0;
		if( element2 == null ) return 0;
		return count(element1) + count(element2);
	}

	/*b) Lag en rekursiv algoritme som skriver ut alle noder på 
	 * et oppgitt nivå i treet. Skriv algoritmen som en Java 
	 * metode som opererer på Binaertre klassen eller på BinaertSoketre klassen.
	 */
	private void skrivUtNivaa(int nivaa, Binaertrenode noden){
		nivaa--;
		
		if(nivaa==0){ 
			if(noden.venstrebarn!=null){
				System.out.println(noden.venstrebarn.objekt+", ");
			}if(noden.hoyrebarn!=null){
				System.out.println(noden.hoyrebarn.objekt+", ");
			}
		} 
		if (nivaa>0) {
			skrivUtNivaa(nivaa, noden.venstrebarn); 
			skrivUtNivaa(nivaa, noden.hoyrebarn);
		}



	}


	private Binaertrenode rot;

	public Iterator<T> postOrderIterator() {
		return new postOrderIterator();
	}

	private class postOrderIterator implements Iterator<T> {

		private class StabelElement {
			Binaertrenode noden;
			int teller;

			public StabelElement(Binaertrenode noden, int teller) {
				this.noden = noden;
				this.teller = teller;
			}
		}

		private Stack<StabelElement> stabelen;

		public postOrderIterator() {
			stabelen = new Stack<>();
			stabelen.push(new StabelElement(rot, 0));
		}

		@Override
		public boolean hasNext() {
			if (stabelen.isEmpty()) return false;
			return true;
		}

		@Override
		public T next() {
			while (true) {
				StabelElement elementet = stabelen.pop();
				if (elementet.teller == 0) {
					elementet.teller++;
					stabelen.push(elementet);
					if (elementet.noden.venstrebarn != null) {
						stabelen.push(new StabelElement(elementet.noden.venstrebarn, 0));
					}
					continue;
				}
				if (elementet.teller == 1) {
					elementet.teller++;
					stabelen.push(elementet);
					if (elementet.noden.hoyrebarn != null) {
						stabelen.push(new StabelElement(elementet.noden.hoyrebarn, 0));
					}
					continue;					
				}
				return elementet.noden.objekt;
			}
		}

	}




	public static void main(String[] args) {
		Binaertre<String> testetre = new Binaertre<>();
		testetre.rot = testetre.new Binaertrenode();
		testetre.rot.objekt = "+";
		testetre.rot.venstrebarn = testetre.new Binaertrenode();
		testetre.rot.venstrebarn.objekt = "*";
		testetre.rot.hoyrebarn = testetre.new Binaertrenode();
		testetre.rot.hoyrebarn.objekt = "8";
		testetre.rot.venstrebarn.venstrebarn = testetre.new Binaertrenode();
		testetre.rot.venstrebarn.venstrebarn.objekt = "3";
		testetre.rot.venstrebarn.hoyrebarn = testetre.new Binaertrenode();
		testetre.rot.venstrebarn.hoyrebarn.objekt = "5";
		testetre.rot.hoyrebarn.hoyrebarn = testetre.new Binaertrenode();
		testetre.rot.hoyrebarn.hoyrebarn.objekt = "4";
		testetre.rot.hoyrebarn.venstrebarn = testetre.new Binaertrenode();
		testetre.rot.hoyrebarn.venstrebarn.objekt = "2";
		Iterator<String> testiterator = testetre.postOrderIterator();
		while (testiterator.hasNext()) {
			System.out.println(testiterator.next());
		}

		System.out.println("antallbladnoder : "+ testetre.count(testetre.rot) +"\n");
		testetre.skrivUtNivaa(1, testetre.rot);
		System.out.println();
		testiterator = testetre.preOrderIterator();
		while (testiterator.hasNext()) {
			System.out.println(testiterator.next());
		}
	}





	//"-----------------------------------------------------------------"

	public Iterator<T> preOrderIterator() {
		return new preOrderIterator();
	}

	private class preOrderIterator implements Iterator<T> {

		private class StabelElement {
			Binaertrenode noden;

			public StabelElement(Binaertrenode noden) {
				this.noden = noden;
			}
		}

		private Stack<StabelElement> stabelen;

		public preOrderIterator() {
			stabelen = new Stack<>();
			stabelen.push(new StabelElement(rot));
		}

		@Override
		public boolean hasNext() {
			if (stabelen.isEmpty()) return false;
			return true;
		}

		@Override
		public T next() {

			StabelElement element = stabelen.pop();         

			if (element.noden.hoyrebarn != null) stabelen.push(new StabelElement(element.noden.hoyrebarn));
			if (element.noden.venstrebarn != null) stabelen.push(new StabelElement(element.noden.venstrebarn));

			return element.noden.objekt;
		}
	}
}








