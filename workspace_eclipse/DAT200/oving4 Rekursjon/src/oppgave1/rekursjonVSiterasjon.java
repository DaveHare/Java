package oppgave1;

public class rekursjonVSiterasjon {
/*
 * Lag en rekursiv metode som finner det n-te elementet 
 * A(n) i formelen A(n) = A(n-1) + 1/n, A(1)=1. 
 * Metoden skal ta tallet n som parameter.
 */	public static double sum=0;
	public static int i=0;
	
	
	/*
	 * T(n)=T(n-1)+1
	 * T(n-1)=T(n-2)+1
	 * T(n-2)=T(n-3)+1
	 * T(n-3)=T(n-4)+1
	 * 
	 * T(n)=T(n-k)+k
	 * k=n-1
	 * T(n)=T(1)+n-1
	 */
	
	/*Kj�rtid:
	 *	O(n)
	 */
	
	public static double nteRek(double n){
		i++;
		if (n==1){
			return sum+1;
		}else{	
			
		sum+= nteRek(n-1) + 1/n;
		}
		return sum;
	}/*
	 * O(n)
	 */
	public static double nteIte(double n){
		i=0;
		sum=0;
		do{
			sum+= 1/n;
			n--;
			i++;
		}while((n>=1));
		return sum;
	}
	
	public static void main(String[] args){
		System.out.println("Rekrusiv: "+ nteRek(100)+", fors�k: " + i);
		System.out.println("Iterativ: "+ nteIte(100) +", fors�k: "+ i );	
	}
	
	
}
