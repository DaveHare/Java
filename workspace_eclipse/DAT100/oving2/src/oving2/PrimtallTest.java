package oving2;
import java.util.Scanner;

public class PrimtallTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		/*
		 * Frivillig: Lag en metode som sjekker om et tall er et primtall. 
		 * Et tall er et primtall hvis det bare er delelig med 1 og seg selv. 
		 * Dere kan bruke metodene fra oppgave d) og e) for å løse dette problemet
		 */
		System.out.println("Skriv inn et heltall: ");
		int tall= input.nextInt();

		boolean svar= PrimtallSjekk(tall);
		if(svar== false){

			System.out.printf("Tallet %d er et Primtall",tall);
		}
		else {
			System.out.printf("Tallet %d er ikke et Primtall",tall);
		}
	}

	public static boolean PrimtallSjekk(int tallet){
		int teller;
		boolean output = false;
		
		SjekkHeltall  HeltallObjekt= new SjekkHeltall();
		
		for(teller=2 ; teller< tallet; teller++)
		{
			output = HeltallObjekt.heltallTest(tallet, teller);
			if 	(output==true)
			{
				break;
			}
		}
		
		return output;
	}

}

