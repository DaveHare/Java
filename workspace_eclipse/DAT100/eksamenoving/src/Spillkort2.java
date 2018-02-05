

import java.util.ArrayList;

public class Spillkort2 {

	public enum Korttype {HJERTER, RUTER, KLOVER, SPAR};
	private final int verdi; // Tallverdien på kortet. 11=knekt, 12=dame, 13=konge
	private final Korttype korttype;
	public int getVerdi() {
		return verdi;
	}
	public Korttype getKorttype() {
		return korttype;
	}
	public Spillkort2(int verdi, Spillkort2.Korttype spar) {
		this.verdi = verdi;
		korttype = spar;
	}
	public String toString() {
		String resultat = "";
		switch (korttype) {
		case HJERTER:
			resultat = "Hjerter ";
			break;
		case RUTER:
			resultat = "Ruter ";
			break;
		case KLOVER:
			resultat = "Kløver ";
			break;
		case SPAR:
			resultat = "Spar ";
			break;
		}
		if (verdi <= 10) {
			resultat += verdi;
		}
		if (verdi == 11) {
			resultat += "knekt";
		}
		if (verdi == 12) {
			resultat += "dame";
		}
		if (verdi == 13) {
			resultat += "konge";
		}
		return resultat;
	}

	public boolean bildeSjekk(Spillkort2 kortet){
		if(kortet.getVerdi()>10)return true;
		return false;
	}

	public static int sammenligneKort(Spillkort2 k1,Spillkort2 k2){
		if(k1.getVerdi()>k2.getVerdi())return 1;
		else if(k1.getVerdi()<k2.getVerdi())return -1;
		else return 0;
	}
	
	public int kortSum(ArrayList<Spillkort2> kortene){
		int resultat = 0;
		for(Spillkort2 kortet: kortene){
			resultat+=kortet.getVerdi();
		}
		return resultat;
	}
}
