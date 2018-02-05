package grafalgoritmer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import grafrepresentasjoner.Graf;

/*
 * Finner dominerende vei gjennom en aktivitetsgraf. Denne starter i første node
 * i den topologiske sorteringen og fortsetter til siste node. Den har en annen
 * betingelse for å justere score for noder men likner ellers mye på algoritmen for
 * korteste vei i en DAG, og har samme kjøretid O(E)
 */
public class AktivitetVarighet <T> {
	private Graf<T> grafen;			// Grafen som skal behandles

	private ArrayList<Integer> forrigeindekser;
	private List<Integer> topologiskSortering;

	public AktivitetVarighet(Graf<T> grafen) {
		this.grafen = grafen;
		
		forrigeindekser = new ArrayList<>();
		
		for (int i=0;i<grafen.noNodes();i++) {
			forrigeindekser.add(Graf.INGEN_SCORE);
		}
		
		TopologiskSortering<T> sorterer = new TopologiskSortering<>(grafen);
		topologiskSortering = sorterer.topologiskSortering();
		
		grafen.resetScores();
		grafen.setScore(topologiskSortering.get(0), 0);
	}

	public void beregnTid() {
		Iterator<Integer> iterator = topologiskSortering.iterator();
		int indeks;
		int nykostnad;
		while (iterator.hasNext()) {
			indeks = iterator.next();
			List<Integer> naboer = grafen.getNeighbours(indeks);
			for (int naboindeks: naboer) {
				nykostnad = grafen.getScore(indeks) + grafen.getWeight(indeks, naboindeks);
				if (grafen.getScore(naboindeks) == Graf.INGEN_SCORE) {
					grafen.setScore(naboindeks, nykostnad);
					forrigeindekser.set(naboindeks, indeks);
				} else {
					if (grafen.getScore(naboindeks) < nykostnad) {
						grafen.setScore(naboindeks, nykostnad);
						forrigeindekser.set(naboindeks, indeks);
					}
				}
			}

		}
	}
	
	public List<Integer> hentDominerendeVei() {
		ArrayList<Integer> motsattVei = new ArrayList<>();
		int nvNode = topologiskSortering.get(topologiskSortering.size() - 1);
		
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
