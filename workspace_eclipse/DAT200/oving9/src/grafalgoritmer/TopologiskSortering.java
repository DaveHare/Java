package grafalgoritmer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import grafrepresentasjoner.Graf;

/*
 * Algoritme: Topologisk sortering - sorterer nodene i en DAG
 * slik at for hver kant s� kommer franoden f�r tilnoden i
 * den sorterte rekkef�lgen
 * 
 * G�r fra Graf til liste med nodeindekser
 * 
 * Kj�retid O(E)
 */
public class TopologiskSortering <T> {
	private Graf<T> grafen;			// Grafen som skal behandles
	private Queue<Integer> nodekoe;
	private List<Integer> sortertListe;
	
	/*
	 * Kj�retid O(V) fra resetScores
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
		
		// Legger til alle noder med 0 innkommende kanter i k�en O(V)
		for (int i=0;i<grafen.noNodes();i++) {
			if (grafen.getScore(i) == 0) nodekoe.add(i);
		}
		
		/*
		 * While-loop kj�rer O(V) ganger da alle nodene legges
		 * til �n gang for en DAG. I en graf med sykler vil
		 * noen noder aldri bli lagt til da de aldri vil
		 * f� score 0.
		 * 
		 * Den indre for-loopen kj�rer O(E) ganger totalt siden
		 * alle naboer til alle noder er E.
		 * 
		 * � ta ut fra en k�, � sette inn p� slutten av ei
		 * liste og � legge inn p� slutten av ei k� er alle O(1)
		 * 
		 * Total kj�retid O(E)
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
