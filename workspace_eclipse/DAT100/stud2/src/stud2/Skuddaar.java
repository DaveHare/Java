package stud2;

public class Skuddaar {
	
	// Oppgave i). Illustrerer at rekkef�lgen p� if-setningene er viktig
	public static boolean erSKuddaar(int aar) {
		if (aar % 400 == 0) return true;
		if (aar % 100 == 0) return false;
		if (aar % 4 == 0) return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(erSKuddaar(1900));
		System.out.println(erSKuddaar(2004));
	}

}
