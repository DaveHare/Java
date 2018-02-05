package grafalgoritmer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import grafrepresentasjoner.Graf;


public class Dijkstra <T> {
	private MinHaug<Integer> prioritetskoe;
	private Graf<T> grafen;			// Grafen som skal behandles
	private int startnodeindeks;
	private int maalnodeindeks;
	
	private ArrayList<Integer> forrigeindekser;
	
	/*
	 * Setter opp strukturer for å kjøre Dijkstra algoritmen
	 * 
	 * Kjøretid O(v)
	 */
	public Dijkstra(Graf<T> grafen, int startnodeindeks, int maalnodeindeks) {
		this.grafen = grafen;
		this.startnodeindeks = startnodeindeks;
		this.maalnodeindeks = maalnodeindeks;		
		grafen.resetScores();
		grafen.setScore(startnodeindeks, 0);
		prioritetskoe = new MinHaug<>();
		prioritetskoe.insert(0, startnodeindeks);
		forrigeindekser = new ArrayList<>();
		for (int i=0;i<grafen.noNodes();i++) {
			forrigeindekser.add(Graf.INGEN_SCORE);
		}
	}
	
	/*
	 * Kjører selve Dijkstra algoritmen
	 * 
	 * Kjøretid:
	 * - For hver node i prioritskøa ta ut laveste node. Prioritetskøa har worst-case
	 *   innhold O(v): O(v*removeMin(v))
	 * - For hver node sette den inn i prioritetskøa. O(v*insert(v))
	 * - Denne versjonen setter inn nye versjoner av nodene når prioriteten senkes. Worst-case
	 *   kjøretid O(e*insert(v))
	 * - Versjoner som bruker callbacks og decreaseKey bruker denne i stedet. Worst-casr
	 *   kjøretid O(e*decreaseKey(v))
	 * 
	 * Total: O(v*removeMin + v*insert + (e*decreaseKey eller e*insert))
	 * 
	 * ArrayPriorityQueue: O(v^2 + v + e) = O(v^2 + e)
	 * Binærhaug: O(v*log(v) + v*log(v) + e*log(v)) = O(v*log(v) + e*log(v))
	 * 
	 * Fibonacci heap: O(v*log(v) + e)
	 * 
	 * For tette grafer e=O(v^2):
	 *   ArrayPriorityQueue: O(v^2)
	 *   Binærhaug: O(v^2*log(v))
	 *   Fibonacci heap: O(v^2)
	 * 
	 * For glisne grafer e=O(v):
	 *   ArrayPriorityQueue: O(v^2)
	 *   Binærhaug: O(v*log(v))
	 *   Fibonacci heap: O(v*log(v))
	 */
	public void dijkstra() {
		int nodeindeks;
		int nykostnad;
		// Så lenge det er nider igjen å se på
		while (!prioritetskoe.isEmpty()) {
			nodeindeks = prioritetskoe.removeMin();
			if (nodeindeks == maalnodeindeks) break;		// Slutter når den har nådd målet
			if (grafen.isHandled(nodeindeks)) continue;		// Hopper over noder som allerede er håndtert
			grafen.setHandled(nodeindeks, true);
			List<Integer> naboer = grafen.getNeighbours(nodeindeks);
			for (int naboindeks: naboer) {
				nykostnad = grafen.getScore(nodeindeks) + grafen.getWeight(nodeindeks, naboindeks);
				if (grafen.getScore(naboindeks) == Graf.INGEN_SCORE) {
					grafen.setScore(naboindeks, nykostnad);
					prioritetskoe.insert(nykostnad, naboindeks);
					forrigeindekser.set(naboindeks, nodeindeks);
				} else {
					if (grafen.getScore(naboindeks) > nykostnad) {
						grafen.setScore(naboindeks, nykostnad);
						prioritetskoe.insert(nykostnad, naboindeks);
						forrigeindekser.set(naboindeks, nodeindeks);
					}
				}
			}
		}
	}
	
	/*
	 * Henter ut korteste vei etter at Dijkstra algoritmen har kjørt. Følger "forrige element"
	 * referansene fra målnoden og tilbake til startnoden.
	 * 
	 * Kjøretid O(lengden til stien fra start til mål)
	 */
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
