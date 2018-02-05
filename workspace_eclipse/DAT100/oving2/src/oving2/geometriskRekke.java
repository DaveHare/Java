package oving2;

import java.util.Scanner;

public class geometriskRekke {
	
/* 
 * Skriv en metode for å regne ut summen av de n første elementene av ei geometrisk rekke. 
 * Formelen er Sum = a0 + a0*r + a0*r2 + … + a0*rn. Metoden skal returnere summen som et flyttall. 
 * Metoden skal ta a0, r og n som parameter. Hint: Dere kan bruke en for-loop til å regne ut 
 * hvert ledd ved å gange forrige verdi med r, og legge den til en løpende sum.  
 */
	
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		
		System.out.println("Skriv inn det første tall: ");
		float forste = input.nextFloat();
		System.out.println("Skriv inn det andre tall: ");
		float andre = input.nextFloat();
		System.out.println("Skriv inn det tredje tall: ");
		float tredje = input.nextFloat();

		
		float Sum = geoRekke(forste, andre, tredje);
		
		
		System.out.println("Summen av rekken er : "+ Sum);
		
	}
	
	public static float geoRekke (float a0, float r, float n ){
		
		float sum=a0;
		
		for (int i=1;i<n; i++ ){
			sum += a0*Math.pow(r, n);
		}
		return sum;	
	}
	
}
