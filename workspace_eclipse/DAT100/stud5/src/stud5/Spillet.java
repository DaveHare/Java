package stud5;

import java.util.ArrayList;
import java.util.Scanner;

public class Spillet {

	public static ArrayList<Spiller> spillere;
	public static ArrayList<Spiller> ferdige;
	public static Terning terningen;
	public static int kasteSum=0;

	public Spillet(int antSpillere){
		this.spillere= new ArrayList<Spiller>();
		this.ferdige= new ArrayList<Spiller>();
		
		antallSpillere();
	}

	public static Spiller lesInnSpiller() {
		Scanner inn = new Scanner(System.in);
		System.out.println("Skriv inn navn: ");
		Spiller spiller= new Spiller(inn.nextLine());
		spillere.add(spiller);
		int kasteSum = 0;

		for(int i=0 ; i<3;i++) {
			terningen= new Terning();
			kasteSum+=terningen.getTall();
		}
		spiller.setPoengsum(kasteSum);
		return spiller;
	}

	public static void kast(Spiller spiller) {
		Scanner inn = new Scanner(System.in);
		kasteSum=spiller.getPoengsum();
		System.out.println("Det er " + spiller.getNavn() +" sin tur.");
		System.out.println("       Spilleren har "+ kasteSum +" poeng.");
		System.out.println("       Vil du kaste igjen? j/n");
		if(inn.nextLine().equals("j")) {
			terningen=new Terning();
			kasteSum+= terningen.getTall();
			spiller.setPoengsum(kasteSum);
			if(kasteSum>21) {
				System.out.println("       TAP: Du har "+kasteSum+" av 21 mulige poeng og har derfor tapt.");
			}else System.out.println("       Du fikk "+ terningen.getTall()+" og har nå "+kasteSum+" poeng.");
		}

	}
	
	public static void enOmgang() {
		for(Spiller spilleren: spillere) {
			kast(spilleren);
		}
	}
	public static void antallSpillere() {
		
		System.out.print("Hvor mange spillere er med i spillet? ");
		for(int i=0; i<inn.nextInt();i++) {
			spillere.add(lesInnSpiller());
		}
	}
	
	public Spiller sjekkVinner() {
		Spiller vinner=ferdige.get(0);
		for(Spiller spilleren: ferdige) {
			if(spilleren.getPoengsum()< 21 && spilleren.getPoengsum()> vinner.getPoengsum()) {
				vinner=spilleren;
			}
		}
		return vinner;
	}
	public static void main(String[] args) {
		
		Spillet spillet= new Spillet();
		spillet 
	}
	
}
