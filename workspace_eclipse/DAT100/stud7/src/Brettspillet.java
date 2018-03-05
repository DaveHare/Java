import java.util.ArrayList;
import java.util.Scanner;

import stud7.Rute;
import stud7.Spiller;
import stud7.Terning;

public class Brettspillet {
	public static ArrayList<Spiller> spillere;
	public static ArrayList<Rute> brett;
	
	public static void nyttBrett(int lengde){
		brett=new ArrayList<Rute>();
		double ruteType;
		for(int i=0;i<lengde;i++) {
			ruteType=Math.random();
			
			if(ruteType>0.3) {
				brett.add(new VanligRute(i));
			}else {
				brett.add(new TilbakeTilStart(i));
			}
		}
	}
	public static void enRunde(Spiller spilleren) {
		Terning t= new Terning();
		int nyPosisjon=spilleren.getPoengsum()+t.getTall();
		spilleren.setPoengsum(nyPosisjon);
		if(nyPosisjon<brett.size()) {
			brett.get(nyPosisjon).flyttHit(spilleren);
		}
				
	}
	public static void spillet() {
		while(spillere.size()>1) {
			for(Spiller spilleren : spillere) {
				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {}
	
				enRunde(spilleren);
				if (spilleren.getPoengsum()>brett.size()) {
					System.out.println(spilleren.getNavn()+" har komt til mål med "+spilleren.getPoengsum()+"poeng!");
					spillere.remove(spilleren);
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		lagSpillere();
		nyttBrett(20);
		spillet();
		
		
		
	
	}
	public static void lagSpillere() {
		spillere= new ArrayList<Spiller>();
		Scanner inn= new Scanner(System.in);
		System.out.println("Hvor mange spillere?");
		int antall=inn.nextInt();
		inn.nextLine();
	
		for(int i =0; i<antall;i++) {
			System.out.println("Navn: ");
			spillere.add(new Spiller(inn.nextLine()));
		}
		inn.close();
	}

}
