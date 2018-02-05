package oving2;

import java.util.Scanner;

public class fallendeObjekt2 {
	public static void main(String args[]){	
		
		Scanner inn = new Scanner(System.in); // lager nytt objekt
		
		System.out.println("Skriv inn sekunder:");
		double sekunder= inn.nextDouble();
		
		beregnDistanseMetode beregnDist= new beregnDistanseMetode(); // nytt objekt fra annet script
		// kjører klassen som kjører metoden beregnDistanse, som returnerer distanse
		double distanse= beregnDistanseMetode.beregnDistanse(sekunder);

		double fart;

		while(true)
		{
			if (sekunder>0)
		
			{
				fart=9.81*sekunder;
				break;
			}
			else 
			{
				System.out.println("Heltallet må være positivt, prøv igjen: ");
				sekunder=inn.nextInt();
			}	
		}

		System.out.printf("Etter %3.0f s har objektet oppnådd en fart  på %4.1f m/s, og den %nhar tilbakelagt en strekning på %4.1f m.", sekunder, fart, distanse);	

	}
}
