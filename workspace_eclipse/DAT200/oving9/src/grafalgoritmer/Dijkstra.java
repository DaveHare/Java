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
	 * Setter opp strukturer for � kj�re Dijkstra algoritmen
	 * 
	 * Kj�retid O(v)
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
	 * Kj�rer selve Dijkstra algoritmen
	 * 
	 * Kj�retid:
	 * - For hver node i prioritsk�a ta ut laveste node. Prioritetsk�a har worst-case
	 *   innhold O(v): O(v*removeMin(v))
	 * - For hver node sette den inn i prioritetsk�a. O(v*insert(v))
	 * - Denne versjonen setter inn nye versjoner av nodene n�r prioriteten senkes. Worst-case
	 *   kj�retid O(e*insert(v))
	 * - Versjoner som bruker callbacks og decreaseKey bruker denne i stedet. Worst-casr
	 *   kj�retid O(e*decreaseKey(v))
	 * 
	 * Total: O(v*removeMin + v*insert + (e*decreaseKey eller e*insert))
	 * 
	 * ArrayPriorityQueue: O(v^2 + v + e) = O(v^2 + e)
	 * Bin�rhaug: O(v*log(v) + v*log(v) + e*log(v)) = O(v*log(v) + e*log(v))
	 * 
	 * Fibonacci heap: O(v*log(v) + e)
	 * 
	 * For tette grafer e=O(v^2):
	 *   ArrayPriorityQueue: O(v^2)
	 *   Bin�rhaug: O(v^2*log(v))
	 *   Fibonacci heap: O(v^2)
	 * 
	 * For glisne grafer e=O(v):
	 *   ArrayPriorityQueue: O(v^2)
	 *   Bin�rhaug: O(v*log(v))
	 *   Fibonacci heap: O(v*log(v))
	 */
	public void dijkstra() {
		int nodeindeks;
		int nykostnad;
		// S� lenge det er nider igjen � se p�
		while (!prioritetskoe.isEmpty()) {
			nodeindeks = prioritetskoe.removeMin();
			if (nodeindeks == maalnodeindeks) break;		// Slutter n�r den har n�dd m�let
			if (grafen.isHandled(nodeindeks)) continue;		// Hopper over noder som allerede er h�ndtert
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
	 * Henter ut korteste vei etter at Dijkstra algoritmen har kj�rt. F�lger "forrige element"
	 * referansene fra m�lnoden og tilbake til startnoden.
	 * 
	 * Kj�retid O(lengden til stien fra start til m�l)
	 */
	public List<Integer> getShortestPath() {
		ArrayList<Integer> motsattVei = new ArrayList<>();
		int nvNode = maalnodeindeks;
		
		// Startnoden f�r aldri satt noen score, s� denne betingelsen sl�r til n�r algoritmen
		// har n�dd startnoden.
		while (nvNode != Graf.INGEN_SCORE) { 
			motsattVei.add(nvNode);
			nvNode = forrigeindekser.get(nvNode);
		}
		Collections.reverse(motsattVei);
		return motsattVei;
	}
}
