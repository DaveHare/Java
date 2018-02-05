package grafalgoritmer;

import java.util.ArrayList;
import java.util.List;

import grafrepresentasjoner.Graf;

/*
 * Representerer en graf som ei liste med noder med nabolister
 * 
 * Plassbruk: O(V + E)
 */
public class NoderNaboliste <T> implements Graf<T> {
	private ArrayList<Node> nodene;
	
	private class Node {
		T element;
		int score;
		boolean handled;
		List<Edge> kanter;
	}
	
	private class Edge {
		int vekt;
		Node tilNode;
		int tilNodeindeks;
		
		public Edge(Node tilnode, int tilNodeindeks, int vekt) {
			tilNode = tilnode;
			this.tilNodeindeks = tilNodeindeks;
			this.vekt = vekt;
		}
	}
	
	public NoderNaboliste() {
		nodene = new ArrayList<>();
	}
	
	// Kjøretid O(1)
	public int addNode(T element) {
		Node nynode = new Node();
		nynode.element = element;
		nynode.score = INGEN_SCORE;
		nynode.handled = false;
		nynode.kanter = new ArrayList<>();
		nodene.add(nynode);
		return nodene.size() - 1;
	}
	
	// Kjøretid O(1)
	public void addEdge(int fra, int til, int vekt) {
		Node fraNode = nodene.get(fra);
		Node tilNode = nodene.get(til);
		fraNode.kanter.add(new Edge(tilNode, til, vekt));
	}

	// Kjøretid O(antall kanter fra noden)
	@Override
	public int getWeight(int fra, int til) {
		Node fraNode = nodene.get(fra);
		Node tilNode = nodene.get(til);
		for (Edge e: fraNode.kanter) {
			if (e.tilNode == tilNode) {
				return e.vekt;
			}
		}
		return INGEN_KANT;
	}

	/*
	 * Kjøretid O(antall naboer til noden)
	 */
	@Override
	public List<Integer> getNeighbours(int nodeindeks) {
		Node fraNode = nodene.get(nodeindeks);
		List<Integer> naboliste = new ArrayList<>();
		for (Edge e: fraNode.kanter) {
			naboliste.add(e.tilNodeindeks);
		}
		return naboliste;
	}

	// Kjøretid O(1)
	@Override
	public T getNodeObject(int nodeindeks) {
		return nodene.get(nodeindeks).element;
	}

	// Kjøretid O(1)
	@Override
	public int getScore(int nodeindeks) {
		return nodene.get(nodeindeks).score;
	}

	// Kjøretid O(1)
	@Override
	public int setScore(int nodeindeks, int nyScore) {
		return nodene.get(nodeindeks).score = nyScore;
	}
	
	@Override public String toString() {
		StringBuilder resultat = new StringBuilder();
		resultat.append("Graf med noder og kantliste representasjon: \n");
		for (Node noden: nodene) {
			resultat.append("Node: " + noden.element + "\n");
			resultat.append("Score: " + noden.score + "\n");
			resultat.append("Kanter: \n");
			for (Edge kanten: noden.kanter) {
				resultat.append("    Til: " + kanten.tilNode.element + " med vekt: " + 
						kanten.vekt + "\n");
			}
		}
		return resultat.toString();
	}

	//Kjøretid O(v)
	@Override
	public void resetScores() {
		for (Node node: nodene) {
			node.score = INGEN_SCORE;
			node.handled = false;
		}
	}
	
	public boolean isHandled(int nodeindeks) {
		return nodene.get(nodeindeks).handled;
	}

	public void setHandled(int nodeindeks, boolean handled) {
		nodene.get(nodeindeks).handled = handled;
	}

	public int noNodes() {
		return nodene.size();
	}

}
