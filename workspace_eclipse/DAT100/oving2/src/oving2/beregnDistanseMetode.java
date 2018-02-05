package oving2;


public class beregnDistanseMetode {
	
	public static double beregnDistanse(double sekund) {
		
		double distanse= (double)0.5*9.8* Math.pow(sekund,2) ;	
		return distanse;
	}

}
