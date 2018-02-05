package oving2;
import java.util.Scanner;

public class SjekkHeltall {
	/*
	 * Lag en metode som tar to heltall som parametre.  Metoden skal sjekker 
	 * om det ene tallet er delelig med det andre. (Hint: Bruk modulo (%) operatoren). 
	 * Metoden skal returnere svaret som en boolsk verdi. 
	 */

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);

		System.out.println("Skriv inn det første heltallet: ");
		int forste = input.nextInt();
		System.out.println("Skriv inn det andre heltall: ");
		int andre = input.nextInt();

		boolean svar= heltallTest(forste, andre);

		if (svar== true){
			System.out.printf("%d er delelig med %d.", forste, andre);
		}
		else {
			System.out.printf("%d er ikke delelig med %d.", forste, andre);
		}
	}

	public static boolean heltallTest( int a, int b){

		boolean output=false;
		if ((a % b)==0){
			output=true;
		}

		return output;
	}

}
