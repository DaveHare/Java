package tester;

import java.util.List;

import grafalgoritmer.BellmanFord;
import grafalgoritmer.Dijkstra;
import grafrepresentasjoner.Graf;
import grafrepresentasjoner.NoderNaboliste;

public class TestBellmanFord {
	
	public static void byggGraf(Graf<String> grafen) {
		// Setter inn nodene
		grafen.addNode("A");
		grafen.addNode("B");
		grafen.addNode("C");
		grafen.addNode("D");
		grafen.addNode("E");
		grafen.addNode("F");
		grafen.addNode("G");
		grafen.addNode("H");
		
		// Setter inn kantene. Antar at grafen var tom før
		// metoden startet. Hvis ikke så vil ikke indeksene
		// som er brukt her stemme.
		grafen.addEdge(0, 1, 5);
		grafen.addEdge(1, 0, 5);
		grafen.addEdge(0, 2, 2);
		grafen.addEdge(0, 3, 2);
		grafen.addEdge(3, 0, 2);
		grafen.addEdge(1, 4, 5);
		grafen.addEdge(4, 1, 5);
		grafen.addEdge(1, 2, 4);
		grafen.addEdge(2, 1, 4);
		grafen.addEdge(2, 5, 2);
		grafen.addEdge(2, 6, 1);
		grafen.addEdge(6, 2, 3);
		grafen.addEdge(3, 6, -4);
		grafen.addEdge(6, 3, 5);
		grafen.addEdge(3, 7, 5);
		grafen.addEdge(7, 3, 5);
		grafen.addEdge(4, 5, 3);
		grafen.addEdge(5, 4, 3);
		grafen.addEdge(4, 6, 5);
		grafen.addEdge(6, 4, 5);
		grafen.addEdge(5, 6, 3);
		grafen.addEdge(6, 5, 3);
		grafen.addEdge(6, 7, 3);
		grafen.addEdge(7, 6, 3);
	}

	public static void main(String[] args) {
		Graf<String> grafen = new NoderNaboliste<String>();
		byggGraf(grafen);
		BellmanFord<String> bellmanFord = new BellmanFord<>(grafen, 0, 4);
		bellmanFord.bellmanFord();
		List<Integer> veiindekser = bellmanFord.getShortestPath();
		System.out.println("Korteste vei er: ");
		for (int i: veiindekser) {
			System.out.print(grafen.getNodeObject(i) + " --> ");
		}
		System.out.print("\nOg har kostnad: ");
		System.out.println(grafen.getScore(4));
	}

}
