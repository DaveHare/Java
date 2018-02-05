package oving5;

public class testMain {

	public static void main(String[] args) {
		System.out.println(minsteDivisor(180, 9));

	}
	
	public static int minsteDivisor(int tall1, int tall2){
		int divisor =-1;
		for (int i =2; i < tall1; i++){

		if ( tall1% i==0 && tall2 % i==0 ){
		divisor=i;
		break;
		}

		}
		
		return divisor;
		}



}
