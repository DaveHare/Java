package stud2;

import java.util.Scanner;

public class oppgE_enhetstestD {

	public static void main(String[] args) {
		Scanner inn= new Scanner(System.in);
		
		for(int i =0; i<5;i++) {
			System.out.println("Skriv inn en dato:");
			System.out.println("Er tallet en gyldig dag i måneden: "+
					oppgD_gyldigdag.gyldigDag(inn.nextInt()));
		}
	}
}
