package oving4;

public class arrayDemo {

	public static float[] arrayDemo( float[] tallArray, float enkeltTall) {

		
		float[] resultat= new float[tallArray.length];
		 for(int i=0; i<tallArray.length;i++){
			 resultat[i]=tallArray[i]*enkeltTall;
		 }
		 
	return resultat;
	}
	
	
	public static void main(String[] args) {
		
		// Lager en ny array av int med fire elementer
		 float[] tallene = new float[4];
		
		tallene[0] = 5;
		tallene[1] = 3;
		tallene[2] = -33;
		tallene[3] = 9;
		
		float faktor=3;
		
		float[] nyArray= arrayDemo(tallene, faktor);
		
		for (int i=0;i<tallene.length;i++) {
			System.out.println("Element " + i + " er " + nyArray[i]);
		}
		

	}

}
