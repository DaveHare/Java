package oppgave2;

import java.util.ArrayList;

import sorteringsAlgoritmer.QuickSort;

public class Oppgave2 {

	/*
	 * a) Du har ei liste med tidspunkt og varighet 
	 * for telefonsamtaler og �nsker � liste dem opp i
	 * sortert rekkef�lge stigende p� tidspunkt. 
	 * Telefonsamtalene blir lagret etter hvert som de blir
	 * registrert. De vil derfor normalt sett lagres i 
	 * stigende rekkef�lge p� tidspunkt, men tregheter
	 * i systemet gj�r at noen f� samtaler blir lagret 
	 * i feil rekkef�lge. Hvilken sorteringsalgoritme
	 * ville du ha brukt for dette problemet?
	 * 
	 * Jeg ville brukt Innsettingssortering fordi det er 
	 * kun et par elementer som skal flyttes.
	 * Den har kj�retid:
	 *  Worst case O(n^2)
	 *  While-loopen m� tilbake til start hver gang, lista er sortert i motsatt rekkef�lge
	 *  
	 *  Best case O(n)
	 *  Lista er allerede sortert p� det man �nsker � sortere p�.
	 *  
	 *  Average case O(n^2)- v�rt case
	 */
	
	
	/*
	 * b) Du har ei liste med studenter og �nsker � liste dem 
	 * ut i sortert rekkef�lge p� navn. Studentene ligger i 
	 * utgangspunktet sortert p� studentnummer. Hvilken 
	 * sorteringsalgoritme ville du ha brukt for dette problemet?
	 * 
	 * Quicksort, fordi den den sorterer somregel raskere en 
	 * mergesort og heapsort + at den bruker medianen til � dele 
	 * listen i to som s�reger for at man aldri f�r worstcase(O(n^2))
	 * og heller f�r O(n log n) average case.
	 * 
	 * bestcase er hvis listen blir splittet midt p�, 
	 * og listen er sortert: O(n log n)
	 * 
	 */
	
	/*
	 * c) Skrive en generisk metode som fjerner duplikater fra 
	 * ei liste og returnerer lista uten duplikatene. Den 
	 * returnerte lista trenger ikke � v�re i samme rekkef�lge 
	 * som denv opprinnelige men m� inneholde de samme elementene 
	 * minus duplikatene. Du har ikke lov til � bruke metoder fra
	 *  Java sitt Collection rammeverk, men du har lov til � 
	 *  bruke all kode som er lagt ut p� DAT200 sidene 
	 *  p� Canvas. Metoden trenger bare � virke p� lister av elementer
	 *  som er sammenliknbare (Comparable).
	 */
	
	public static <T extends Comparable<? super T>> ArrayList<T> fjernDuplikater(ArrayList<T> liste){
		ArrayList<T> nyliste=new ArrayList<T>();
		QuickSort.quickSort(liste);
		System.out.println(liste);
		nyliste.add(liste.get(0));
		
		for(int i =0; i < liste.size()-1; i++){
			if(liste.get(i).compareTo(liste.get(i+1))!=0){
				nyliste.add(liste.get(i+1));
			}
		}
			
		return nyliste;
	}

	
	
	public static void main(String[] args){
		ArrayList<String> liste= new ArrayList<>();
		liste.add("a");
		liste.add("b");
		liste.add("d");
		liste.add("r");
		liste.add("r");
		liste.add("a");
		liste.add("y");
		liste.add("a");
		liste.add("y");
		liste.add("r");
		
//		System.out.println(liste.get(3).compareTo(liste.get(4)));
		System.out.println(liste);
		
		liste=fjernDuplikater(liste);
		System.out.println(liste);
	}
}
