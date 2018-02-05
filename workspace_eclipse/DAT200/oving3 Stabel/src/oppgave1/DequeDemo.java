package oppgave1;

import java.util.Scanner;

public class DequeDemo {
	public static ArrayDeq1<String> deq;
//	public static MinArrayList<String> deq;

	public static void main(String[] args) {
	deq= new ArrayDeq1<String>(2,5);
	
	deq.add("en");System.out.println(deq.getAntElementer());
	deq.add("to");System.out.println(deq.getAntElementer());
	deq.addFirst("tre");System.out.println(deq.getAntElementer());
	deq.add("fire");System.out.println(deq.getAntElementer());
	deq.addLast("fem");System.out.println(deq.getAntElementer());
	deq.add("seks");System.out.println(deq.getAntElementer());
	deq.addFirst("syv");System.out.println(deq.getAntElementer());
	deq.addFirst("åtte");System.out.println(deq.getAntElementer());
	deq.addFirst("ni");System.out.println(deq.getAntElementer());
		
	System.out.println(deq.toString()); 
	deq.remove(0);
	System.out.println(deq.toString());
//	
	
	leggTil();

	}

	private static void leggTil() {
		Scanner inn= new Scanner(System.in);
		System.out.println("Skriv inn fire ord: ");
		
		System.out.print("Legges forran: ");
		deq.addFirst(inn.next());
		System.out.println(deq.toString()); 
		
		System.out.print("Legges Bak: ");
		deq.addLast(inn.next());
		System.out.println(deq.toString()); 
		
		System.out.print("Legges på index 2: ");
		deq.add( 2,inn.next());
		System.out.println(deq.toString()); 
		
		System.out.print("Legges bak ");
		deq.addLast(inn.next());	
		System.out.println(deq.toString()); 
		
	}

}
