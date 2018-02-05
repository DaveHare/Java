package stud2;

import java.util.Scanner;

public class OppgaveB_distFallt {
	/*
	 * oppgave b
	 */
	public static double distanse=0.0;
	
	public static void distanseFalt(int sekunder) {
		distanse = 0.5*9.8*Math.pow(sekunder, 2);		
	}

	public static void main(String[] args) {
		/*
		 * oppgave c
		 */
		
		Scanner inn= new Scanner(System.in);
		int sekunder= inn.nextInt();
		distanseFalt(sekunder);
		System.out.println(distanse);
	}

}
