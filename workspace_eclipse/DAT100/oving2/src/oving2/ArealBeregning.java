package oving2;
import java.util.Scanner;
public class ArealBeregning {

	public static void main(String[] args) {
		Scanner inn= new Scanner(System.in);
		
		double a,b,y,Areal=0;
		System.out.println("Skriv inn lengden til side a: ");
		a=inn.nextDouble();
		System.out.println("Skriv inn lengden til side b: ");
		b=inn.nextDouble();
		System.out.println("Skriv inn vinkelen til y i grader: ");
		y=Math.toRadians(inn.nextDouble());
		
		Areal= a*b*Math.sin(y);
		
		System.out.println("Arealet til trekaneten er: " + Areal);
		

	}

}
