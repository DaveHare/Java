package oving2;

import java.util.Scanner;

public class fallendeObjekt2 {
	public static void main(String args[]){	
		
		Scanner inn = new Scanner(System.in); // lager nytt objekt
		
		System.out.println("Skriv inn sekunder:");
		double sekunder= inn.nextDouble();
		
		beregnDistanseMetode beregnDist= new beregnDistanseMetode(); // nytt objekt fra annet script
		// kj�rer klassen som kj�rer metoden beregnDistanse, som returnerer distanse
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
				System.out.println("Heltallet m� v�re positivt, pr�v igjen: ");
				sekunder=inn.nextInt();
			}	
		}

		System.out.printf("Etter %3.0f s har objektet oppn�dd en fart  p� %4.1f m/s, og den %nhar tilbakelagt en strekning p� %4.1f m.", sekunder, fart, distanse);	

	}
}
