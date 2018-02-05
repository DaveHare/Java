package grafalgoritmer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import grafrepresentasjoner.Graf;

/*
 * Algoritme: Topologisk sortering - sorterer nodene i en DAG
 * slik at for hver kant så kommer franoden før tilnoden i
 * den sorterte rekkefølgen
 * 
 * Går fra Graf til liste med nodeindekser
 * 
 * Kjøretid O(E)
 */
public class TopologiskSortering <T> {
	private Graf<T> grafen;			// Grafen som skal behandles
	private Queue<Integer> nodekoe;
	private List<Integer> sortertListe;
	
	/*
	 * Kjøretid O(V) fra resetScores
	 */
	public TopologiskSortering(Graf<T> grafen) {
		this.grafen = grafen;
		grafen.resetScores();
		nodekoe = new LinkedList<>();
		sortertListe = new ArrayList<>(grafen.noNodes());
	}
	
	public List<Integer> topologiskSortering(){
		// Starter med score 0 for alle noder O(V)
		for (int i=0;i<grafen.noNodes();i++) {
			grafen.setScore(i, 0);
		}
		
		// Beregner antall innkommende kanter for hver node O(E)
		for (int i=0;i<grafen.noNodes();i++) {
			List<Integer> naboliste = grafen.getNeighbours(i);
			for (int naboen: naboliste) {
				grafen.setScore(naboen, grafen.getScore(naboen) + 1);
			}
		}
		
		// Legger til alle noder med 0 innkommende kanter i køen O(V)
		for (int i=0;i<grafen.noNodes();i++) {
			if (grafen.getScore(i) == 0) nodekoe.add(i);
		}
		
		/*
		 * While-loop kjører O(V) ganger da alle nodene legges
		 * til én gang for en DAG. I en graf med sykler vil
		 * noen noder aldri bli lagt til da de aldri vil
		 * få score 0.
		 * 
		 * Den indre for-loopen kjører O(E) ganger totalt siden
		 * alle naboer til alle noder er E.
		 * 
		 * Å ta ut fra en kø, å sette inn på slutten av ei
		 * liste og å legge inn på slutten av ei kø er alle O(1)
		 * 
		 * Total kjøretid O(E)
		 */
		while (!nodekoe.isEmpty()) {
			int nodeindeks = nodekoe.remove();
			sortertListe.add(nodeindeks);
			List<Integer> naboliste = grafen.getNeighbours(nodeindeks);
			for (int naboen: naboliste) {
				grafen.setScore(naboen, grafen.getScore(naboen) - 1);
				if (grafen.getScore(naboen) == 0) {
					nodekoe.add(naboen);
				}
			}
		}
		
		return sortertListe;
	}
}
