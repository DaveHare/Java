package oving2;
import java.util.Scanner;

public class MinsteDeleligHeltall {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		/*
		 * Lag en metode som tar inn et tall som parameter. Metoden skal returnere 
		 * hva som er det minste heltallet som dette tallet er delelig med. Dette 
		 * kan gjøres med en for-loop som bruker metoden fra forrige oppgave på 
		 * stadig større tall og starter med 2. 
		 */
		System.out.println("Skriv inn et heltall: ");
		int tall= input.nextInt();

		int svar= DeleSjekk(tall);

		System.out.printf("Tallet %d er delelig på %d", tall, svar);
		
	}

	public static int DeleSjekk(int tallet){
		int teller;
		SjekkHeltall  HeltallObjekt= new SjekkHeltall();
		for(teller=2 ; teller< tallet+1; teller++)
		{
			boolean output = HeltallObjekt.heltallTest(tallet, teller);
			if 	(output==true)
			{
				break;
			}
		}
		return teller;
	}

}
