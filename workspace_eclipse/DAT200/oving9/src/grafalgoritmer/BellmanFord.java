package grafalgoritmer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import grafrepresentasjoner.Graf;

public class BellmanFord <T> {
	private Graf<T> grafen;			// Grafen som skal behandles
	private int startnodeindeks;
	private int maalnodeindeks;
	private Queue<Integer> nodekoe;
	private List<Integer> noderTattUtSattInnListe;
	private ArrayList<Integer> forrigeindekser;
	
	public BellmanFord(Graf<T> grafen, int startnodeindeks, int maalnodeindeks) {
		this.grafen = grafen;
		this.startnodeindeks = startnodeindeks;
		this.maalnodeindeks = maalnodeindeks;		
		grafen.resetScores();
		grafen.setScore(startnodeindeks, 0);
		nodekoe = new LinkedList<>();
		nodekoe.add(startnodeindeks);
		noderTattUtSattInnListe = new ArrayList<>(grafen.noNodes());
		forrigeindekser = new ArrayList<>(grafen.noNodes());
		for (int i=0;i<grafen.noNodes();i++) {
			noderTattUtSattInnListe.add(0);
			forrigeindekser.add(Graf.INGEN_SCORE);
		}
		noderTattUtSattInnListe.set(startnodeindeks, 1);
	}
	
	public void bellmanFord() {
		int nykostnad;
		while (!nodekoe.isEmpty()) {
			int nvNodeindeks = nodekoe.remove();
			noderTattUtSattInnListe.set(nvNodeindeks, noderTattUtSattInnListe.get(nvNodeindeks) + 1);
			if(noderTattUtSattInnListe.get(nvNodeindeks) > 2*grafen.noNodes()) {
				throw new IllegalArgumentException("Grafen har en negativ sykel!");
			}
			List<Integer> naboer = grafen.getNeighbours(nvNodeindeks);
			for (int naboindeks: naboer) {
				nykostnad = grafen.getScore(nvNodeindeks) + grafen.getWeight(nvNodeindeks, naboindeks);
				if (grafen.getScore(naboindeks) == Graf.INGEN_SCORE || grafen.getScore(naboindeks) > nykostnad) {
					grafen.setScore(naboindeks, nykostnad);
					forrigeindekser.set(naboindeks, nvNodeindeks);
					if (noderTattUtSattInnListe.get(naboindeks) % 2 == 0) {
						nodekoe.add(naboindeks);
						noderTattUtSattInnListe.set(naboindeks, noderTattUtSattInnListe.get(naboindeks) + 1);						
					}
				}
			}
		}
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
