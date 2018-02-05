package trestrukturer;

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
		Binaertrenode forelder;
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
		
		Iterator<String> testiterator = testetre.postOrderIterator();
		while (testiterator.hasNext()) {
			System.out.println(testiterator.next());
		}
	}
}
