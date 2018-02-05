package hoyestetall;

public class HoyesteTall {

	/* Eksempel på en algoritme:
	 * Finn det høyeste tallet i en array av heltall
	 * 
	 * Pseudokode:
	 * - Hvis arrayen er tom, returner 0
	 * - Sett høyeste tall lik første element
	 * - For hvert element
	 *      - Sjekk om elementet er høyere og 
	 *          sett høyeste tall lik elementet hvis det er høyere
	 */
	public static int hoyesteTall(int[] tallene) {
		if (tallene.length == 0) return 0;
		int hoyestetall = tallene[0];
		for (int tallet: tallene) {
			if (hoyestetall < tallet) hoyestetall = tallet;
		}
		return hoyestetall;
	}
	
	/*
	 * Analyse av kjøretida for denne algoritmen:
	 * 
	 * Med testarray:
	 * - Følg array, 1 basisoperasjon
	 * - Sammenlikning 1 basisoperasjon
	 * - Lag variabel "hoyestetall" 1 basisoperasjon
	 * - Tilordning 1 basisoperasjon
	 * - Les element i array 1 basisoperasjon
	 * - Lag variabel "tallet" 1 basisoperasjon
	 * - For hvert element i arrayen:
	 *   - Les elementet og tilordne variabelen 2 basisoperasjoner
	 *   - sammenlikning 1 basisoperasjon
	 *   - Hvis sammenlikning er sann: 1 tilordning + 1 les variabel
	 * - returner tallet 1 basisoperasjon
	 * 
	 * Summerer opp: f(n) = 7 + 3*n + 2*x  <-- Vekstfunksjon
	 *   n = antall elementer i arrayen
	 *   x = antall ganger if-setningen slår til
	 * 
	 * Best case: if-setning slår aldri til siden første element
	 * er størst, x=0
	 * 
	 * Worst case: if-setning slår til hver eneste gang, array
	 * er sortert i stigende rekkefølge, x=n
	 * 
	 * 3n er det dominante leddet.
	 * 
	 * Algoritmens kjøretid stiger lineært med n
	 * 
	 * g(n) = 6*n >= f(n) for alle n>7
	 *  => Algoritmen er O(n)
	 * 
	 * g(n) = 3*n <= f(n) for alle n
	 *  => Algoritmen er Omega(n)
	 *  => Algoritmen er Theta(n)
	 * 
	 * For arrayen i main: 7 + 3*7 + 2 = 30 basisoperasjoner
	 */
	
	public static void main(String[] args) {
		int[] tallene = {8, -10, 4, -3, 12, 3, -4};
		System.out.println(hoyesteTall(tallene));
	}
}
