package demoer;

import java.util.ArrayList;
import java.util.Scanner;

import mine_lister.MinArrayList;
import mine_lister.Stabel;

public class Postfixkalkulator {
	static Stabel<String> stabelen = new Stabel<>();
	
	private static int tolkParameter(String parameter) {
		int tall;
		try {
			tall = Integer.parseInt(parameter);
		} catch (NumberFormatException e) {
			tall = kjorOperasjon(parameter);
		}
		return tall;
	}
	
	public static int pluss() {
		String forste = stabelen.pop();
		int forsteTall = tolkParameter(forste);

		String andre = stabelen.pop();
		int andreTall = tolkParameter(andre);

		return forsteTall + andreTall;
	}

	public static int minus() {
		String forste = stabelen.pop();
		int forsteTall = tolkParameter(forste);

		String andre = stabelen.pop();
		int andreTall = tolkParameter(andre);

		return forsteTall - andreTall;
		
	}

	public static int kjorOperasjon(String parameter) {
		if (parameter.charAt(0) == '+') {
			return pluss();
		}
		if (parameter.charAt(0) == '-') {
			return minus();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner inn = new Scanner(System.in);
		String verdi;
		int tall;
		do {
			System.out.println("Skriv inn neste verdi, avslutt med tom linje:");
			verdi = inn.nextLine();
			stabelen.push(verdi);
		} while (!verdi.equals(""));
		
		stabelen.pop();
		System.out.println(kjorOperasjon(stabelen.pop()));
	}

}
