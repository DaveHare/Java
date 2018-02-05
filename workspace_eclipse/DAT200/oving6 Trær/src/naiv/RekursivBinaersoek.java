package naiv;

import java.util.ArrayList;
import java.util.List;

public class RekursivBinaersoek {
	
	public static <T extends Comparable<? super T>> int binaerSoek(List<T> elementer, T element) {
		return binaerSoek(elementer, 0, elementer.size() - 1, element);
	}
	
	/*
	 * Rekursiv formulering av binærsøk.
	 * 
	 * Algoritme
	 * - Sammenlikn søkeelementet med midterste element
	 * - Hvis likt, returner indeksen til midterste element
	 * - Hvis avstanden mellom første og siste element er 1,
	 *   sjekk søkeelement mot første og siste element. Returner
	 *   indeksen til første eller siste element hvis første
	 *   eller siste element er like søkeelementet, ellers
	 *   returner -1
	 * - Hvis søkeelementet er mindre enn midterste element,
	 *   er det i første halvpart. Kjør binærsøk rekursivt på
	 *   første halvpart
	 * - Hvis søkeelementet er større, kjør binærsøk rekursivt
	 *   på siste halvpart.
	 */
	public static <T extends Comparable<? super T>> int binaerSoek(List<T> elementer, int start, int slutt, T elementet) {
		T startElement = elementer.get(start);
		T sluttElement = elementer.get(slutt);
		
		if (startElement.compareTo(elementet) == 0) {
			return start;
		}
		
		if (sluttElement.compareTo(elementet) == 0) {
			return slutt;
		}		
		
		if (start == slutt-1) {
			return -1;
		}
		
		int midt = start + (slutt - start)/2;
		T midtElement = elementer.get(midt);
		if (midtElement.compareTo(elementet) == 0) {
			return midt;
		}
		if (midtElement.compareTo(elementet) < 0) {
			return binaerSoek(elementer, midt, slutt, elementet);
		}
		if (midtElement.compareTo(elementet) > 0) {
			return binaerSoek(elementer, start, midt, elementet);
		}
		return midt;
	}

	public static <T extends Comparable<? super T>> int binaerSoekNaermesteOver(List<T> elementer, T element) {
		if (elementer.isEmpty()) return 0;
		if (elementer.get(0).compareTo(element) > 0) return 0;
		if (elementer.get(elementer.size() - 1).compareTo(element) <= 0) return elementer.size();
		return binaerSoekNaermesteOver(elementer, 0, elementer.size() - 1, element);
	}
	
	
	public static <T extends Comparable<? super T>> int binaerSoekNaermesteOver(List<T> elementer, int start, int slutt, T elementet) {
		T startElement = elementer.get(start);
		T sluttElement = elementer.get(slutt);
		
		if (startElement.compareTo(elementet) == 0) {
			return start;
		}
		
		if (sluttElement.compareTo(elementet) == 0) {
			return slutt;
		}		
		
		if (start == slutt-1) {
			return slutt;
		}
		
		int midt = start + (slutt - start)/2;
		T midtElement = elementer.get(midt);
		if (midtElement.compareTo(elementet) == 0) {
			return midt;
		}
		if (midtElement.compareTo(elementet) < 0) {
			return binaerSoekNaermesteOver(elementer, midt, slutt, elementet);
		}
		if (midtElement.compareTo(elementet) > 0) {
			return binaerSoekNaermesteOver(elementer, start, midt, elementet);
		}
		return midt;
	}

	public static void main(String[] args) {
		int[] sortert = {6, 8, 9, 12, 17, 22, 27, 34, 38, 39};
		ArrayList<Integer> talliste = new ArrayList<Integer>();
		for (int tall: sortert) { talliste.add(tall); }
		System.out.println(binaerSoek(talliste, 45));
		
	}

}
