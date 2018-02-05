package oving3;

import java.util.Scanner;

public class changeToLowerUpperCase {

	public static void main(String[] args) {
		/* a )
		 * Lag et program eller metode som leser inn en streng, gjør første bokstav stor og resten små,
		 * og skriver ut den resulterende strengen. Hint: Bruk String.substring(start, slutt) for å hente ut
		 * første bokstav og String.substring(start) for å hente ut resten. Disse brukes på samme måte
		 * som String.toUppercase(), som ble demonstrert i forelesningene. Konverter første bokstav til
		 * store bokstaver og resten til små bokstaver og slå sammen strengen igjen etterpå.
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
