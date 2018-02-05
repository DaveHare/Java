package stud2;

import java.util.Scanner;

public class oppgG_perfektTall {
	/*
	 * perfekte tall er: 6, 28, 496
	 */
	public static boolean perfektTall(int tallet){
		int tallsum=1;
		for(int i=2; i<=tallet/2; i++) {
			if(oppgF_deleligPaaHverandre.delelig(i, tallet)) {
				tallsum+=i;
			}
		}
		if(tallet==tallsum)return true;
		return false;
	}
	public static void main(String[] args) {
Scanner inn= new Scanner(System.in);
		
		for(int i =0; i<5;i++) {
			System.out.println("Skriv inn et tall:");
			System.out.println("Er tallet perfekt: "+
					perfektTall(inn.nextInt()));
		}
	}
}
