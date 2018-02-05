package maksimalDelsekvens;

public class FinnElement {
	
	/*
	 * Algoritme for � finne et oppgitt element i ei liste med tall. Prinsippet er
	 * det samme for � finne et oppgitt element i ei liste med objekter.
	 * 
	 * Returnerer indeksen til elementet i lista, eller -1 om elementet ikke er med i lista
	 * 
	 * Kj�retid: 
	 * - Best case: O(1), f�rste element er elementet man leiter etter
	 * - Worst case: O(n), elementet man leiter etter er ikke med i lista
	 * - Average case: O(n), elementet er rundt halvveis inn.
	 * 
	 */
	public static int finnElement(int element, int[] liste) {
		for (int i=0;i<liste.length;i++) {
			if (liste[i] == element) return i;
		}
		return -1;
	}
	
	/* 
	 * Bin�rs�k: En algoritme for � finne et oppgitt element i ei sortert liste.
	 * 
	 * Denne inneholder en while-l�kke, men while-l�kka halverer st�rrelsen
	 * p� problemet hver gang den kj�res. Prinsippet er � sammenlikne det man leiter
	 * etter med midterste element. Hvis det man leiter etter er st�rre, m� det ligge
	 * i siste halvpart. Hvis det man leiter etter er mindre, m� det ligge i f�rste
	 * halvpart.
	 * 
	 * Returnerer indeksen til elementet i lista, eller -1 om elementet ikke er med i lista
	 * 
	 * Kj�retid O(log(n)) worst og average case. Dette er en typisk kj�retid for slike
	 * algoritmer som gj�r gjentatt halvering av problemst�rrelsen.
	 * 
	 * Kj�retid O(1) best case som er at det man leiter etter er midterste element.
	 */
	public static int finnElementSortert(int element, int[] liste) {
		int start=0;
		int slutt = liste.length;
		while (slutt - start > 1) {
			int midterste = start + (slutt - start)/2;
			if (element == liste[midterste]) return midterste;
			if (element < liste[midterste]) {
				slutt = midterste;
			} else {
				start = midterste;
			}
		}
		if (element == liste[start]) return start;
		if (element == liste[slutt]) return slutt;
		return -1;  // Elementet er ikke med i lista
	}
	
	/*
	 * Main metode for � teste algoritmene
	 */
	public static void main(String[] args) {
		int[] tallene = {6, 2, 8, 6, 1, 8, 45};
		System.out.println(finnElement(8, tallene));
		int[] sortert = {6, 8, 9, 12, 17, 22, 27, 34, 38, 39};
		System.out.println(finnElementSortert(10, sortert));		
	}
}
