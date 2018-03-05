package stud7;
public class Terning {
	private int tall;// Verdien til terningen
	
	/**
	 * En terning starter med en tilfeldig verdi
	 */
	public Terning() {
		kast();
	}
	
	public void kast() {
		tall = 1 + (int)(Math.random()*6);
	}
	
	public int getTall () {
		return tall;
	}
	
	public String toString() {
		return "Terning med verdi: " + tall;
	}

	/**
	 * Main metode for å teste Terning klassen
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Terning terning;
		terning = new Terning();
		System.out.println(terning.toString());
		terning.kast();
		System.out.println(terning.toString());
		terning.kast();
		System.out.println(terning.toString());
		terning.kast();
		System.out.println(terning.toString());
		terning.kast();
		System.out.println(terning.toString());
	}

}
