package stud2;

import java.util.Scanner;

public class oppgF_deleligPaaHverandre {

	public static boolean delelig(int a, int b) {
		if (a%b==0 || b%a==0)return true;
		return false;
	}
	public static void main(String[] args) {
		Scanner inn= new Scanner(System.in);
		
		for(int i =0; i<5;i++) {
			System.out.println("Skriv inn to heltall avslutt med enter etter hvert tall: ");
			System.out.println("Er tallene delelig med hverandre: "+
					delelig(inn.nextInt(),inn.nextInt()));
		}

	}
}
