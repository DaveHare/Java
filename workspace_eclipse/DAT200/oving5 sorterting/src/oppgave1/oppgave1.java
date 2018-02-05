package oppgave1;

import java.util.ArrayList;

import sorteringsAlgoritmer.MergeSort;
import sorteringsAlgoritmer.QuickSort;
import sorteringsAlgoritmer.ShellSort;

public class oppgave1 {
	public static ArrayList<Integer> array1;
	public static ArrayList<Integer> array2;

	public static void main(String[] args) {

		array1 = new ArrayList<>();
		array2 = new ArrayList<>();
		lagLister();
//a)
		System.out.println("Oppgave a");
		System.out.println(array1);
		ShellSort.KSorter(array1, 5);
		System.out.println(array1);
		System.out.println("-----------------------");
		System.out.println(array2);
		ShellSort.KSorter(array2, 5);
		System.out.println(array2);

// b)
		System.out.println("-----------------------\n\nOppgave b");
		System.out.println(array1);
		ShellSort.KSorter(array1, 3);
		System.out.println(array1);
		System.out.println("-----------------------");
		System.out.println(array2);
		ShellSort.KSorter(array2, 3);
		System.out.println(array2);

//c
		lagLister();
		System.out.println("-----------------------\n\nOppgave c");
		System.out.println(array1);
		MergeSort.mergeSort(array1);
		System.out.println(array1);
		System.out.println("-----------------------");
		System.out.println(array2);
		MergeSort.mergeSort(array2);
		System.out.println(array2);
		
		
		/* Oppgave d
		 * Hvor mange nivåer med rekursjon gjør MergeSort her? 2
		 * Hvor mange utgaver av den rekursive MergeSort
		 * metoden vil det maksimalt være på kallstabelen? 2
		 * Anta at MergeSort går over til Insertion Sort 
		 * på arraystørrelse 3 eller lavere.
		 */
		
		
		/* Oppgave e
		 * Vis hvordan en median-of-three quicksort 
		 * splitter arrayene. Vis de splittete arrayene på
		 * nederste nivå av rekursjonen. Anta at QuickSort 
		 * går over til Insertion Sort på arraystørrelse 3
		 * eller lavere.
		 */
		lagLister();
		System.out.println("-----------------------\n\nOppgave e");
		System.out.println(array1);
		QuickSort.quickSort(array1);
		System.out.println(array1);
		System.out.println(QuickSort.nederste);
		System.out.println("antall nivå meed rekursjon: "+ QuickSort.i);
		System.out.println("-----------------------");
		System.out.println(array2);
		QuickSort.quickSort(array2);
		System.out.println(array2);
		System.out.println(QuickSort.nederste);
		System.out.println("antall nivå meed rekursjon: "+ QuickSort.i);
		
	}

	private static void lagLister() {
		array1=new ArrayList<>();
		array1.add(35);
		array1.add(44);
		array1.add(5);
		array1.add(43);
		array1.add(32);
		array1.add(65);
		array1.add(20);
		array1.add(2);
		array1.add(15);
		array1.add(46);
		//---------------------
		
		array2=new ArrayList<>();
		array2.add(2);
		array2.add(6);
		array2.add(9);
		array2.add(7);
		array2.add(12);
		array2.add(17);
		array2.add(18);
		array2.add(26);
		array2.add(22);
		array2.add(35);

	}

}


