package stud2;

import java.util.Scanner;

public class oppgaveA {
	
	public static void main(String[] args) {
		Scanner inn= new Scanner(System.in);
		int a,b,y;
		System.out.println("Side 1:");
		a=inn.nextInt();
		System.out.println("Side 2:");
		b=inn.nextInt();
		System.out.println("Vinkelen melom dem:");
		y=inn.nextInt();
		double areal= 0.5*a*b*Math.toRadians(y);
		System.out.print(areal);
	}

}
