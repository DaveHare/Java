import java.util.Scanner;

public class fallendeObjekt2 {
	
	public static void main(String[] args) {
		programMetode();
	}
	public static void programMetode() { //main(String args[]){	

		Scanner inn= new Scanner(System.in);
		System.out.println("Skriv inn lengden på intervallet i sekunder :");
		int tidsIntervall=inn.nextInt();
		System.out.println("Skriv inn antall intervallet :");
		int antIntervall= inn.nextInt();

		while(true)
		{
			if (tidsIntervall>0 && antIntervall>0)
			{
				for (int forsok=1;forsok<antIntervall+1; forsok++)
				{
					double fart=9.81*tidsIntervall*forsok;
					double akselerasjon= 2*fart/tidsIntervall;
					System.out.println("TidsIntervall: "+ forsok*tidsIntervall + " ;  Fart: "+ fart+"m/s ; Akselerasjon: "+ akselerasjon+ "m/s^2 ;");
				}
				break;
			}	
			else 
			{
				System.out.println("Heltallet må være positivt, prøv igjen");
				System.out.println("Skriv inn lengden på intervallet i sekunder :");
				tidsIntervall=inn.nextInt();
				System.out.println("Skriv inn antall intervallet :");
				antIntervall= inn.nextInt();
			}
		}	

	}
}

