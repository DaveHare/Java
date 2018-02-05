package sorteringsAlgoritmer;

import java.util.ArrayList;

/*
 * Ønsker å lage en splitt-og-hersk algoritme
 * 
 * Ønsker å lage en in-place sorteringsalgoritme
 */
public class QuickSort {
	public static int i=0;
	public static String nederste;
	
	/*
	 * Splitter lista i to basert på at første element er pivot element
	 * 
	 * Kjøretid: O(n)
	 * 
	 * Minnebruk: O(1)
	 */
	public static <T extends Comparable<? super T>> int splittPaaPivot(ArrayList<T> lista, int s, int e) {
		i++;
		int start = s+1;
		int slutt = e;
		
		T pivot = lista.get(s);
		T temp;
		
		while (start < slutt) {
			if (lista.get(start).compareTo(pivot) <= 0 && lista.get(slutt).compareTo(pivot) > 0) {
				start++;
				slutt--;
				continue;
			}
			if (lista.get(start).compareTo(pivot) > 0 && lista.get(slutt).compareTo(pivot) <= 0) {
				temp = lista.get(start);
				lista.set(start, lista.get(slutt));
				lista.set(slutt, temp);
				start++;
				slutt--;
				continue;
			}
			if (lista.get(start).compareTo(pivot) > 0 && lista.get(slutt).compareTo(pivot) > 0) {
				slutt--;
				continue;
			}
			if (lista.get(start).compareTo(pivot) <= 0 && lista.get(slutt).compareTo(pivot) <= 0) {
				start++;
				continue;
			}
		}
		
		// Flytter pivot til midten
		if (lista.get(start).compareTo(pivot) > 0) {
			start--;
		}
		temp = lista.get(s);
		lista.set(s, lista.get(start));
		lista.set(start, temp);
		return start;
	}
	
	private static <T> void swapElements(ArrayList<T> lista, int indeks1, int indeks2) {
		T temp = lista.get(indeks1);
		lista.set(indeks1, lista.get(indeks2));
		lista.set(indeks2, temp);
		System.out.println(lista);
	}
	
	public static <T extends Comparable<? super T>> void medianAvTrePivot(ArrayList<T> lista, int start, int slutt) {
		
		i++;
		T forste = lista.get(start);
		T siste = lista.get(slutt);
		
		int midtersteIndeks = start + (slutt-start)/2;
		T midterste = lista.get(midtersteIndeks);
		
		if (forste.compareTo(siste) < 0) {
			if (forste.compareTo(midterste) < 0) {
				if (midterste.compareTo(siste) < 0) {
					swapElements(lista, start, midtersteIndeks);
				
				} else {
					swapElements(lista, start, slutt);
				}
			} else {
				// Første mindre enn siste, større enn eller lik midterste
				return;
			}
		} else {
			// Første større enn eller lik siste
			if (forste.compareTo(midterste) < 0) {
				// Siste, første, midterste
				return;
			} else {
				// Første større enn eller lik siste og midterste
				if (siste.compareTo(midterste) < 0) {
					swapElements(lista, start, midtersteIndeks);
				} else {
					swapElements(lista, start, slutt);
				}
			}
		}
		
		nederste="Nederste nivå:   L1: "+ lista.subList(start, midtersteIndeks)+",    L2: "+lista.subList(midtersteIndeks, slutt);
		System.out.println(nederste);
		
	}
	public static <T extends Comparable<? super T>> void randomisertPivot(ArrayList<T> lista, int start, int slutt) {
		int differanse = slutt - start;
		int pivotindeks = start + (int)(Math.random()*differanse);
		swapElements(lista, start, pivotindeks);
	}
	
	/*
	 * Kjøretid:
	 * - Best case O(n*log(n)), lista splittes eksakt i to
	 *   Oppstår i naiv implementasjon ved allerede sortert liste!
	 * - Worst case O(n^2), pivot er alltid første eller siste element
	 * - Average case O(n*log(n))
	 * 
	 */
	public static <T extends Comparable<? super T>> void quickSort(ArrayList<T> lista, int start, int slutt) {
		if (slutt - start < 3) {
			i++;
			Innsettingssortering.sorter(lista.subList(start, slutt+1));
			return;
		}
		
		medianAvTrePivot(lista, start, slutt);
		int pivotPosisjon = splittPaaPivot(lista, start, slutt);
		quickSort(lista, start, pivotPosisjon - 1);
		quickSort(lista, pivotPosisjon + 1, slutt);
	}
	
	/*
	 * Selection problemet: Finn det k-ende minste elementet i ei liste.
	 * Spesialtilfellet: Finn medianen i ei liste.
	 * 
	 * QuickSelect: Modifikasjon av quicksort som løser dette problemet ved å gå ned
	 * bare ei grein.
	 * 
	 * Kjøretid O(n)
	 */
	private static <T extends Comparable<? super T>> T quickSelect(ArrayList<T> lista, int start, int slutt, int k) {
		if (slutt - start < 3) {
			Innsettingssortering.sorter(lista.subList(start, slutt+1));
			lista.get(k);
		}
		
		medianAvTrePivot(lista, start, slutt);
		
		int pivotPosisjon = splittPaaPivot(lista, start, slutt);
		if (pivotPosisjon < k) {
			return quickSelect(lista, pivotPosisjon + 1, slutt, k);
		} else {
			return quickSelect(lista, start, pivotPosisjon - 1, k);
		}
	}

	public static <T extends Comparable<? super T>> T quickSelect(ArrayList<T> lista, int k) {
		return quickSelect(lista, 0, lista.size() - 1, k);
	}
	
	public static <T extends Comparable<? super T>> void quickSort(ArrayList<T> lista) {
		quickSort(lista, 0, lista.size() - 1);
	}

	public static void main(String[] args) {
		ArrayList<Integer> talliste = new ArrayList<>();
		talliste.add(94);
		talliste.add(39);
		talliste.add(42);
		talliste.add(76);
		talliste.add(66);
		talliste.add(87);
		talliste.add(29);
		talliste.add(68);
		talliste.add(94);
		talliste.add(10);
		talliste.add(44);
		System.out.println(talliste);
//		splittPaaPivot(talliste, 0, talliste.size() - 1);
		quickSort(talliste);
		System.out.println(talliste);
		
	}

}
