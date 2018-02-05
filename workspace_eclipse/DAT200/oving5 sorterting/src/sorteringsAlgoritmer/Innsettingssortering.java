package sorteringsAlgoritmer;

import java.util.ArrayList;
import java.util.List;

public class Innsettingssortering {
	/*
	 * En enkel sorteringsalgoritme: Innsettingssortering
	 * 
	 * Kj�retid:
	 *  Worst case O(n^2)
	 *  While-loopen m� tilbake til start hver gang, lista er sortert i motsatt rekkef�lge
	 *  
	 *  Best case O(n)
	 *  Lista er allerede sortert p� det man �nsker � sortere p�.
	 *  
	 *  Average case O(n^2)
	 */
	public static <T extends Comparable<? super T>> void sorter(List<T> lista) {
		for (int i=1;i<lista.size();i++) {
			int j = i;
			while (j > 0 && lista.get(j).compareTo(lista.get(j-1)) < 0) {
				T temp = lista.get(j);
				lista.set(j, lista.get(j-1));
				lista.set(j-1, temp);
				j--;
			}
		}
	}
}
