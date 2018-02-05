package oving3;

import java.util.Scanner;

public class SpillerTest {
	
	
	public static Spiller lesInnSpiller(Scanner inn){
	
		System.out.println("Navn: ");
		String navn=inn.nextLine();
		Spiller spilleren= new Spiller(navn);
		return spilleren;

	}

	public static void main(String[] args) {
		
		Scanner inn= new Scanner(System.in);
		
		System.out.println("Registrer spiller 1: ");
		Spiller Spiller1=lesInnSpiller(inn);
	
		System.out.println("Registrer spiller 2: ");
		Spiller Spiller2 = lesInnSpiller(inn); //nytt objekt for spiller 2
			
		System.out.println("Skriv inn poengsum for spiller 1: ");
		int poengsum= inn.nextInt();
		Spiller1.setPoengsum(poengsum);
		
		System.out.println("Skriv inn poengsum for spiller 2: ");
		poengsum= inn.nextInt();
		Spiller2.setPoengsum(poengsum);
		
		//vinner
		Spiller vinner= Spiller.HoyestScore(Spiller1, Spiller2);
		System.out.println("S"
				+ "pilleren med høyest score er: ");
		vinner.SkrivUtSpiller();
		
	}

}
