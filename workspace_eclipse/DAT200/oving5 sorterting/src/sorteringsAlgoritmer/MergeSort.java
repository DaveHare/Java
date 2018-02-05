package sorteringsAlgoritmer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Flettesortering, engelsk Merge Sort
 * 
 */
public class MergeSort {
public static int i=0;
	/*
	 * Kombinerer to sorterte lister til én sortert liste
	 * 
	 * Kjøretid O(m + n)
	 * 
	 * Minnebruk O(m + n)
	 */
	public static <T extends Comparable<? super T>> List<T> kombinerSorterteLister(List<T> list1, List<T> list2) {
		List<T> resultat = new ArrayList<>();
		
		Iterator<T> liste1ref = list1.iterator();
		Iterator<T> liste2ref = list2.iterator();
		
		T liste1element = liste1ref.next();
		T liste2element = liste2ref.next();
		
		do {
			if (liste1element.compareTo(liste2element) <= 0) {
				resultat.add(liste1element);
				if (!liste1ref.hasNext()) {
					resultat.add(liste2element);
					break;
				}
				liste1element = liste1ref.next();
			} else {
				resultat.add(liste2element);
				if (!liste2ref.hasNext()) {
					resultat.add(liste1element);
					break;
				}
				liste2element = liste2ref.next();
			}
		} while (true);
		
		while (liste1ref.hasNext()) {
			resultat.add(liste1ref.next());
		}
		
		while (liste2ref.hasNext()) {
			resultat.add(liste2ref.next());
		}
		return resultat;
	}
	
	/*
	 * MergeSort algoritmen bruker kombiner sorterte 
	 * lister sammen med splitt-og-hersk
	 * teknikken for å sortere lister. Idéen er:
	 * - Splitt lista i to
	 * - Sorter hver halvpart for seg
	 * - Kombiner de to
	 * 
	 * Kjøretid Theta(n*log(n))
	 * 
	 * Fordeler:
	 *  - Garantert n*log(n) kjøretid
	 *  - Enkel å parallellisere
	 *  - Stabil
	 *  
	 * Ulemper:
	 *  - Minnebruk: Min versjon O(n*log(n)) minne. Mulig å lage en versjon som bruker bare
	 *    to arrays som får O(n) minnebruk.
	 *  - Stor tidskonstant på grunn av kopiering av elementer
	 */
	public static <T extends Comparable<? super T>> List<T> mergeSort(List<T> elementene) {
		i++;
		if (elementene.size() <3 ) {
			Innsettingssortering.sorter(elementene);
//			System.out.println(i);
			return elementene;
		}//else 	System.out.println(i);
		
		/*
		 * Kjøretid subList
		 *  O(1) tid på en List
		 *  O(tid det tar å navigere), i praksis O(n) på en linkedlist
		 */
		List<T> forsteDel = elementene.subList(0, elementene.size()/2);
//		System.out.println(forsteDel);
		List<T> andreDel =  elementene.subList(elementene.size()/2, elementene.size());
		
		if(andreDel.size()<3){
			System.out.println("Nederste nivå:   L1: "+ forsteDel+",    L2: "+andreDel);
		}
		
		forsteDel = mergeSort(forsteDel);
		
		andreDel = mergeSort(andreDel);

		
		List<T> resultat = kombinerSorterteLister(forsteDel, andreDel);
		
		return resultat;
	}
	
}
