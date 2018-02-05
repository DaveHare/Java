import java.util.Scanner;

public class fallendeObjekt {
	public static void main(String args[]){	

		Scanner inn= new Scanner(System.in);
		System.out.println("Skriv inn et heltall [Tid] :");
		int sekunder=inn.nextInt();

		double fart,distanse;

		while(true)
		{
			if (sekunder>0)
		
			{
				fart=9.81*sekunder;
				distanse= 0.5*fart*sekunder;
				break;
			}
			else 
			{
				System.out.println("Heltallet må være positivt, prøv igjen: ");
				sekunder=inn.nextInt();
			}	
		}

		System.out.println("Etter "+ sekunder+ " s har objektet oppnådd en fart  på "+ fart + " m/s, og den \nhar tilbakelagt en strekning på "+ distanse+ " m.");	

	}
}
