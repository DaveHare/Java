package hendelse;

public class oppgA {

	public static float[] multiplisereArray(float[] tab, int faktor) {
		for(int i =0; i< tab.length; i++) {
			tab[i]*=faktor;
		}
		return tab;
	}
	public static void main(String[] args) {

		float[] tab = new float[5];
		tab[0]=(float) 8.5;
		tab[1]=(float) 8.9;
		tab[2]=(float) 3.6;
		tab[3]=(float) 4.5;

		tab= multiplisereArray(tab,2);
		for (int i=0;i<tab.length;i++) {
			System.out.println("Element " + i + " er " + tab[i]);
		}
		
	}

}
