
package sorteringsAlgoritmer;
import java.util.ArrayList;
public class ShellSort {
	/* 
	 * Gj�r en k-sort av ei liste. 
	 * En k-sort sorterer hvert k-ende element. 
	 * For eksempel en 5-sort gj�r det slik 
	 * at hvert 5. element er sortert. 
	 */
	public static <T extends Comparable<? super T>> void KSorter(ArrayList<T> lista, int k) {
		for (int a = 0; a < k; a++) {
			for (int i = a+k; i < lista.size(); i += k) {
				int j = i;
				while (j-k >= 0 && lista.get(j).compareTo(lista.get(j - k)) < 0) {
					T temp = lista.get(j);
					lista.set(j, lista.get(j - k));
					lista.set(j - k, temp);j -= k;}
			}
		}
	}
	/* 
	 * ShellSort. Id�en er � bruke Ksorter metoden for � flytte lave verdier mange hakk 
	 * mot starten og h�ye tall mange hakk mot slutten i �n operasjon i stedet for 
	 * mange slik som InsertionSort ville gjort. * 
	 * Kj�retid * 
	 * Worst case O(n^2), 
	 * Average case O(n*sqrt(n)). 
	 * Dette er ikke intuitivt og denne 
	 * * algoritmen er sv�rt vanskelig � analysere korrekt selv om den er bygd p� 
	 * * en enkel id�. * * Dette regnes som den mest effektive av de enkle sorteringsalgoritmene. */
	public static <T extends Comparable<? super T>> void shellSort(ArrayList<T> lista) {
		for (int k=lista.size()/2;k>1;k/=2) {
			if (k % 2 == 0) k += 1;
			KSorter(lista, k);}
		KSorter(lista, 1);
	}

}
