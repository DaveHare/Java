package oving3;

import java.util.Scanner;

public class Main {

	public static String storbokstav(String streng) {
		streng=streng.substring(0,1).toUpperCase()+streng.substring(1);

		if(streng.contains(" ")){

			int i = streng.indexOf(" ");
			System.out.println(i+"  "+ streng.charAt(i));

			do{
				if(streng.charAt(i)==' '){
					i++;
					streng= streng.substring(0,1).toUpperCase()+ 
							streng.substring(1,i)+
							streng.substring(i,i+1).toUpperCase()+
							streng.substring(i+1);

				}
				i++;
			}while(i<streng.length());
		}
		return streng;
	}

	public static void main(String[] args) {
		Scanner inn = new Scanner(System.in);

		System.out.println("Spiller 1");
		System.out.println("Skriv inn et navn, og ID: ");
		String navn= storbokstav(inn.nextLine());
		System.out.println("ID: ");
		int ID= inn.nextInt();
		Spiller spiller1 = new Spiller(navn, ID); 
		System.out.println(spiller1);
		System.out.println("skriv poengsum til spiller "+ ID+" :");
		spiller1.setPoengsum(inn.nextInt());

		inn.nextLine();


		System.out.println("Spiller 2");
		System.out.println("Skriv inn et navn: ");
		navn= storbokstav(inn.nextLine());
		System.out.println("ID: ");
		ID= inn.nextInt();
		Spiller spiller2 = new Spiller(navn, ID); 
		
		System.out.println("skriv poengsum til spiller "+ ID+" :");
		spiller2.setPoengsum(inn.nextInt());


		Spiller vinner= HoyestPoengsum(spiller1, spiller2);

		System.out.println(vinner.toString()+ " og har mest poeng!");
	}

	private static Spiller HoyestPoengsum(Spiller spiller1, Spiller spiller2) {
		if(spiller1.getPoengsum()>=spiller2.getPoengsum())return spiller1;
		return spiller2;
	}

}
