package maksimalDelsekvens;

/*
 * Eksempel på algoritmer og kjøretidsanalyse:
 * Maksimal Delsekvenssum.
 * 
 * Gitt en array av heltall n, finn den høyeste
 * summen av en delsekvens av arrayen. En delsekvens
 * er alle elementene fra og med en indeks i til og med
 * en høyere indeks j.
 */
public class MaksimalDelsekvensSum {
	
	/*
	 * Brute Force: Enkel men dårlig algoritme
	 * 
	 * Vekstfunksjon: n*(n+1)*(n+2)/6. Å finne denne 
	 * formelen krever ei grein i matematikken som heter 
	 * Kombinatorikk, og som er pensum i 
	 * MAT120 Diskret Matematikk
	 * 
	 * Kjøretid O(n^3)
	 * Årsak:
	 * - Ytre for-loop kjører n ganger
	 * - Midtre for-loop kjører proposjonalt med n ganger
	 * - Indre for-loop kjører proposjonalt med n ganger
	 * 
	 */
	public static int bruteForce(int[] tallene) {
		int maksimalSum = Integer.MIN_VALUE;
		for (int i=0;i<tallene.length;i++) {
			for (int j=i;j<tallene.length;j++) {
				int sum = 0;
				for (int k=i;k<j;k++) {
					sum += tallene[k];
				}
				if (maksimalSum < sum) maksimalSum = sum;
			}
		}
		return maksimalSum;
	}
	
	public static final int ANTALL = 4000;
	
	public static void main(String[] args) {
		int[] tallene = new int[ANTALL];
		
		/*
		 * Lager tilfeldige tall for å få datamengden stor nok
		 * til at kjøretida merkes. 4000 er egentlig et ganske
		 * lite tall i dagens dataverden.
		 */
		for (int a=0;a<ANTALL;a++) {
			tallene[a] = (int)(Math.random()*200) - 100;
		}
		System.out.println(bruteForce(tallene));
	}

}
