package mine_lister;

/*
 * Kø implementasjon basert på en array samt indekser
 * inn i arrayen for første og siste element.
 * 
 * Alternativt navn sirkulært buffer siden indeksene
 * går tilbake til start når de har kommet forbi slutten
 * av arrayen.
 * 
 * Denne tar mindre plass enn lenket liste versjonen, men
 * har begrenset kapasitet og kan ikke utvide seg.
 */
public class BegrensetArrayKoe <T> {
	Object[] objektene;
	int start;
	int slutt;
	int antallElementer;
	
	public BegrensetArrayKoe(int kapasitet) {
		objektene = new Object[kapasitet];
		start = 0;
		slutt = 0;
		antallElementer = 0;
	}
	
	/*
	 * Legger til et element på slutten av køen
	 * 
	 * Kjøretid O(1)
	 */
	public void ankomst(T objekt) {
		if (antallElementer >= objektene.length) {
			throw new IllegalStateException("Køen er full");
		}
		objektene[slutt] = objekt;
		slutt++;
		antallElementer++;
		slutt = slutt % objektene.length;
	}
	
	/*
	 * Tar ut et element i starten av køen
	 * 
	 * Kjøretid O(1)
	 */
	public T taUt() {
		if (antallElementer <= 0) {
			throw new IllegalStateException("Køen er tom!");
		}
		T resultat = (T)objektene[start];
		start++;
		antallElementer--;
		start = start % objektene.length;
		return resultat;
	}
	
	public T forste() {
		return (T)objektene[start];
	}
	
	public T siste() {
		int sisteIndeks = slutt - 1;
		if (sisteIndeks == -1) sisteIndeks = objektene.length - 1;
		return (T)objektene[sisteIndeks];
	}
	
	/*
	 * Testemetode
	 */
	public static void main(String[] args) {
		BegrensetArrayKoe<Integer> test = new BegrensetArrayKoe<>(5);
		test.ankomst(4);
		test.ankomst(7);
		test.ankomst(9);
		System.out.println(test.taUt());
		System.out.println(test.taUt());
		test.ankomst(10);
		test.ankomst(12);
		test.ankomst(18);
		System.out.println(test.taUt());
		System.out.println(test.taUt());
		System.out.println(test.taUt());
		System.out.println(test.taUt());
		test.ankomst(19);
		test.ankomst(21);
		System.out.println(test.taUt());
		System.out.println(test.taUt());
		
	}
}
