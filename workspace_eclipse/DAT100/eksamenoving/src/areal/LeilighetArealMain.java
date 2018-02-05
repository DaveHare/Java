package areal;

import java.util.Scanner;

import javafx.scene.shape.Rectangle;

public class LeilighetArealMain {
	public static Scanner inn= new Scanner(System.in);
	public static double arealSum=0;
	public static void main(String[] args) {
		int antRom= antallRom();
		for(int i = 0 ; i < antRom; i++ ){
			arealSum += romRunde(i+1);	
		}
		System.out.println("Arealet til leiligheten er "+ arealSum);


	}

	public static double romRunde(int romNr) {
		System.out.println("Rom "+(romNr)+":");
		System.out.print("Lengde:");
		double lengde= inn.nextDouble();
		System.out.print("Bredde:");
		double bredde= inn.nextDouble();
		double areal= arealRom(lengde, bredde);
		
		return areal;
	}

	private static double arealRom(double bredde, double lengde) {
		double areal= bredde*lengde;
		return areal;
	}

	public static int antallRom(){
		System.out.println("Hvor mange rom er det i leiligheten");
		int antRom= inn.nextInt();
		return antRom;

	}

	Rectangle r= new Rectangle(0,0);
	Canvas c= new Canvas();
}
