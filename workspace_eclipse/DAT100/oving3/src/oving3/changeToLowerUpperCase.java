package oving3;

import java.util.Scanner;

public class changeToLowerUpperCase {

	public static void main(String[] args) {
		/* a )
		 * Lag et program eller metode som leser inn en streng, gj�r f�rste bokstav stor og resten sm�,
		 * og skriver ut den resulterende strengen. Hint: Bruk String.substring(start, slutt) for � hente ut
		 * f�rste bokstav og String.substring(start) for � hente ut resten. Disse brukes p� samme m�te
		 * som String.toUppercase(), som ble demonstrert i forelesningene. Konverter f�rste bokstav til
		 * store bokstaver og resten til sm� bokstaver og sl� sammen strengen igjen etterp�.
		 */

		Scanner input= new Scanner(System.in);
		
		System.out.println("Skriv en setning: ");
		// .nextLine() isteden for .next(); fordi next ignorerer mellomrom i stringen
		String setning= input.nextLine();
		
		String setningUpper= setning.substring(0,1);
		String setningLower= setning.substring(1, setning.length());
		
		setning= setningUpper.toUpperCase() + setningLower.toLowerCase();
		
		
		
		System.out.println("Du skrev: " + setning);
		
	
	}

}
