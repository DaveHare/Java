package prioritetskoer;

import java.util.ArrayList;

/*
 * Prioritetskø basert på en minimum binærhaug.
 * 
 * En minimum binærhaug (minimum binary heap) er et binærtre hvor begge barna må være
 * større enn forelderen.
 */
public class MaxHaug <T> {
	private class Innslag {
		int prioritet;
		T verdi;
		
		public Innslag(int prioritet, T verdi) {
			this.prioritet = prioritet;
			this.verdi = verdi;
		}
	}
	
	// En binærhaug kan lagres som en arraylist
	private ArrayList<Innslag> innslagene = new ArrayList<>();

	// Legger inn et dummy element i posisjon 0 for å få enkel matematikk
	public MaxHaug() {
		innslagene.add(null);
	}
	
	/*
	 * Kjøretid O(n). Det kan i utgangspunktet se ut som den har n*log(n) kjøretid,
	 * men antall noder den bytter om er aldri høyere enn n.
	 */
	public MaxHaug(ArrayList<Integer> prioriteter, ArrayList<? extends T> startliste) {
		innslagene.add(null);
		for (int i=0;i<startliste.size();i++) {
			innslagene.add(new Innslag(prioriteter.get(i), startliste.get(i)));
		}
		for (int i=innslagene.size()/2;i>0;i--) {
			bobleNed(i);
		}
	}
	
	/*
	 * Kjøretid O(1). Henter alltid ut første element.
	 */
	public T findMax() {
		if (innslagene.size() < 2) return null;
		return innslagene.get(1).verdi;
	}
	
	/*
	 * Kjøretid O(log(n)) fra bobleOpp
	 */
	public void insert(int prioritet, T objekt) {
		Innslag i = new Innslag(prioritet, objekt);
		innslagene.add(i);
		bobleOpp(innslagene.size() -  1);
	}
	
	/*
	 * Kjøretid O(log(n)) siden denne går oppover i treet potensielt helt til rota.
	 */
	private void bobleOpp(int index) {
		if (index == 1) return;
		int forelder = index/2;
		while (index > 1 && innslagene.get(forelder).prioritet < innslagene.get(index).prioritet) {
			bytt(forelder, index);
			index = forelder;
			forelder = index/2;
		}
	}
	
	/*
	 * Kjøretid O(1)
	 */
	private void bytt(int index1, int index2) {
		Innslag temp = innslagene.get(index1);
		innslagene.set(index1, innslagene.get(index2));
		innslagene.set(index2, temp);
		
	}
	
	/*
	 * Kjøretid O(log(n)) fra bobleNed
	 */
	public T removeMax() {
		try{
		Innslag resultat = innslagene.get(1);
		if (innslagene.size() > 2) {
			innslagene.set(1, innslagene.remove(innslagene.size() - 1));
			bobleNed(1);
		} else {
			innslagene.remove(1);
		}
		return resultat.verdi;
		}catch(IndexOutOfBoundsException e){
			System.err.println("Listen er tom.");
//			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * Kjøretid O(1). Hjelpemetode for å gjøre bobleNed litt kortere gjennom å si at
	 * noder som ikke fins i treet har en veldig stor verdi.
	 */
	private int finnPrioritet(int index) {
		if (index < innslagene.size()) return innslagene.get(index).prioritet;
		return Integer.MIN_VALUE;
	}
	
	/*
	 * Kjøretid O(log(n)) siden den går nedover i treet potensielt helt ned til bladnodene
	 */
	private void bobleNed(int index) {
		int venstrebarn = index*2;
		int hoyrebarn = venstrebarn + 1;
		
		int venstrePrioritet = finnPrioritet(venstrebarn);//25
		
		int hoyrePrioritet = finnPrioritet(hoyrebarn);//19
		int maxPrioritet = innslagene.get(index).prioritet;//12
//		System.out.println(venstrePrioritet+" - "+ maxPrioritet+ " - "+ hoyrePrioritet);
		

		while (!(maxPrioritet > venstrePrioritet && maxPrioritet > hoyrePrioritet)) {
			if (venstrePrioritet > hoyrePrioritet) {
//				System.out.println(" if");
				bytt(index, venstrebarn);
				index = venstrebarn;
			} else {
//				System.out.println(" else");
				bytt(index, hoyrebarn);
				index = hoyrebarn;
			}
			venstrebarn = index*2;
			hoyrebarn = venstrebarn + 1;
			venstrePrioritet = finnPrioritet(venstrebarn);
			hoyrePrioritet = finnPrioritet(hoyrebarn);
			maxPrioritet = innslagene.get(index).prioritet;
//			System.out.println(venstrePrioritet+" - "+ maxPrioritet+ " - "+ hoyrePrioritet);
		}
	}
	
	/*
	 * Kjøretid O(log(n)) fra bobleOpp
	 */
	public void decreaseKey(int index, int prioritet) {
		Innslag i = innslagene.get(index);
		if (prioritet > i.prioritet) throw new IllegalArgumentException("Prøver å øke i stedet for å senke nøkkel!");
		i.prioritet = prioritet;
		bobleOpp(index);
	}
	
	/*
	 * Hjelpemetode for debugging og testing
	 */
	public String toString() {
		StringBuilder resultat = new StringBuilder();
		resultat.append("Minimum Haug: \n");
		Innslag innslaget;
		for (int i=1;i<innslagene.size();i++) {
			innslaget = innslagene.get(i);
			resultat.append(i + ": " + innslaget.prioritet + " - " + innslaget.verdi + "\n");
		}
		return resultat.toString();
	}
	
	public int size() {
		return innslagene.size() -1;
	}
	
	public boolean isEmpty() {
		if (innslagene.size() < 2) return true;
		return false;
	}
	
	/*
	 * Testemetode
	 */
	public static void main(String[] args) {
		MaxHaug<String> testehaug = new MaxHaug<>();
		testehaug.insert(10, "Ti");
		testehaug.insert(25, "Tjuefem");
		testehaug.insert(12, "Tolv");
		testehaug.insert(8, "Åtte");
		testehaug.insert(33, "Trettitre");
		testehaug.insert(11, "Elleve");
		testehaug.insert(19, "Nitten");
		System.out.println(testehaug);
		System.out.println();
		System.out.println(testehaug.findMax());
		System.out.println(testehaug.removeMax());
		System.out.println(testehaug);
		
		System.out.println(testehaug.removeMax());
		testehaug.insert(15, "Femten");
		System.out.println(testehaug);
		System.out.println(testehaug.removeMax());
		System.out.println(testehaug);
		System.out.println(testehaug.removeMax());
		System.out.println(testehaug);
		System.out.println(testehaug.removeMax());
		System.out.println(testehaug);
		System.out.println(testehaug.removeMax());
		System.out.println(testehaug);
		System.out.println(testehaug.removeMax());
		System.out.println(testehaug);
		System.out.println(testehaug.removeMax());
		System.out.println(testehaug);
		System.out.println(testehaug.removeMax());
	}
}
