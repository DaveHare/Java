package oppgave2;

import java.util.ArrayList;
import java.util.Arrays;

public class SammelignLister{


	public static <T> ArrayList<T> sammenlignLister(ArrayList<T> liste1, ArrayList<T> liste2){

		ArrayList<T> fellesListe= new ArrayList<T>();

		for(int i=0; i<liste1.size();i++){
			for(int j=0; j<liste2.size();j++){
//				System.out.println(liste1.get(i));
				if(liste1.get(i).equals(liste2.get(j))){
					fellesListe.add(liste1.get(i));
//					System.out.println(liste1.get(i));
				}
			}
		}
		return fellesListe;

	}

	public static void main(String[] args) {
		ArrayList<Integer> obj1= new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6, 7, 8));
		ArrayList<Integer> obj2= new ArrayList<Integer>(Arrays.asList(3, 10, 5, 7));
		
		ArrayList<String> obj3= new ArrayList<String>(Arrays.asList("en", "to", "fem","tre"));
		ArrayList<String> obj4= new ArrayList<String>(Arrays.asList("en", "fire","to", "tretten"));

		
		System.out.println(sammenlignLister(obj1, obj2));
		System.out.println(sammenlignLister(obj3, obj4));
	}

}





