package grafalgoritmer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import grafrepresentasjoner.Graf;

/*
 * Finn korteste vei i en DAG.
 * 
 * Kjøretid O(E)
 * - Topologisk sortering O(E)
 * - Går gjennom nodene i sortert rekkefølge O(V)
 * - Ser på kantene ut av hver node mellom start og mål O(E) totalt
 */
public class KortesteVeiDAG <T> {
	private Graf<T> grafen;			// Grafen som skal behandles
	private int startnodeindeks;
	private int maalnodeindeks;
	
	private ArrayList<Integer> forrigeindekser;
	private List<Integer> topologiskSortering;

	public KortesteVeiDAG(Graf<T> grafen, int startnodeindeks, int maalnodeindeks) {
		this.grafen = grafen;
		this.startnodeindeks = startnodeindeks;
		this.maalnodeindeks = maalnodeindeks;
		
		forrigeindekser = new ArrayList<>();
		
		for (int i=0;i<grafen.noNodes();i++) {
			forrigeindekser.add(Graf.INGEN_SCORE);
		}
				
		TopologiskSortering<T> sorterer = new TopologiskSortering<>(grafen);
		topologiskSortering = sorterer.topologiskSortering();

		// Resetter scores *etter* topologisk sortering 
		grafen.resetScores();
		grafen.setScore(startnodeindeks, 0);

	}
	
	public void kortesteVei() {
		Iterator<Integer> iterator = topologiskSortering.iterator();
		int indeks = 0;
		int nykostnad;
		while (iterator.hasNext()) {
			indeks = iterator.next();
			if (indeks == startnodeindeks) break;
		}
		
		do {
			if (indeks == maalnodeindeks) break;
			List<Integer> naboer = grafen.getNeighbours(indeks);
			for (int naboindeks: naboer) {
				nykostnad = grafen.getScore(indeks) + grafen.getWeight(indeks, naboindeks);
				if (grafen.getScore(naboindeks) == Graf.INGEN_SCORE) {
					grafen.setScore(naboindeks, nykostnad);
					forrigeindekser.set(naboindeks, indeks);
				} else {
					if (grafen.getScore(naboindeks) > nykostnad) {
						grafen.setScore(naboindeks, nykostnad);
						forrigeindekser.set(naboindeks, indeks);
					}
				}
			}
			indeks = iterator.next();
		} while (iterator.hasNext());
	}
	
	public List<Integer> getShortestPath() {
		ArrayList<Integer> motsattVei = new ArrayList<>();
		int nvNode = maalnodeindeks;
		
		// Startnoden får aldri satt noen score, så denne betingelsen slår til når algoritmen
		// har nådd startnoden.
		while (nvNode != Graf.INGEN_SCORE) { 
			motsattVei.add(nvNode);
			nvNode = forrigeindekser.get(nvNode);
		}
		Collections.reverse(motsattVei);
		return motsattVei;
	}

}
