package oppgave2;

import java.util.ArrayList;

import sorteringsAlgoritmer.QuickSort;

public class Oppgave2 {

	/*
	 * a) Du har ei liste med tidspunkt og varighet 
	 * for telefonsamtaler og ønsker å liste dem opp i
	 * sortert rekkefølge stigende på tidspunkt. 
	 * Telefonsamtalene blir lagret etter hvert som de blir
	 * registrert. De vil derfor normalt sett lagres i 
	 * stigende rekkefølge på tidspunkt, men tregheter
	 * i systemet gjør at noen få samtaler blir lagret 
	 * i feil rekkefølge. Hvilken sorteringsalgoritme
	 * ville du ha brukt for dette problemet?
	 * 
	 * Jeg ville brukt Innsettingssortering fordi det er 
	 * kun et par elementer som skal flyttes.
	 * Den har kjøretid:
	 *  Worst case O(n^2)
	 *  While-loopen må tilbake til start hver gang, lista er sortert i motsatt rekkefølge
	 *  
	 *  Best case O(n)
	 *  Lista er allerede sortert på det man ønsker å sortere på.
	 *  
	 *  Average case O(n^2)- vårt case
	 */
	
	
	/*
	 * b) Du har ei liste med studenter og ønsker å liste dem 
	 * ut i sortert rekkefølge på navn. Studentene ligger i 
	 * utgangspunktet sortert på studentnummer. Hvilken 
	 * sorteringsalgoritme ville du ha brukt for dette problemet?
	 * 
	 * Quicksort, fordi den den sorterer somregel raskere en 
	 * mergesort og heapsort + at den bruker medianen til å dele 
	 * listen i to som søreger for at man aldri får worstcase(O(n^2))
	 * og heller får O(n log n) average case.
	 * 
	 * bestcase er hvis listen blir splittet midt på, 
	 * og listen er sortert: O(n log n)
	 * 
	 */
	
	/*
	 * c) Skrive en generisk metode som fjerner duplikater fra 
	 * ei liste og returnerer lista uten duplikatene. Den 
	 * returnerte lista trenger ikke å være i samme rekkefølge 
	 * som denv opprinnelige men må inneholde de samme elementene 
	 * minus duplikatene. Du har ikke lov til å bruke metoder fra
	 *  Java sitt Collection rammeverk, men du har lov til å 
	 *  bruke all kode som er lagt ut på DAT200 sidene 
	 *  på Canvas. Metoden trenger bare å virke på lister av elementer
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
