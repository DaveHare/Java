package tester;

import java.util.List;

import grafalgoritmer.Dijkstra;
import grafrepresentasjoner.Graf;
import grafrepresentasjoner.NoderNaboliste;

public class TestDijkstra {

	public static void main(String[] args) {
		Graf<String> grafen = new NoderNaboliste<String>();
		TestBreddeForstSok.byggGraf(grafen);
		Dijkstra<String> dijkstra = new Dijkstra<>(grafen, 0, 4);
		dijkstra.dijkstra();
		List<Integer> veiindekser = dijkstra.getShortestPath();
		System.out.println("Korteste vei er: ");
		for (int i: veiindekser) {
			System.out.print(grafen.getNodeObject(i) + " --> ");
		}
		System.out.print("\nOg har kostnad: ");
		System.out.println(grafen.getScore(4));
	}

}
