package kort;



public class Spillkort {
	public enum Korttype {HJERTER, RUTER, KLOVER, SPAR};
	private final int verdi; // Tallverdien på kortet. 11=knekt, 12=dame, 13=konge
	private final Korttype korttype;
	public int getVerdi() {
		return verdi;
	}
	public Korttype getKorttype() {
		return korttype;
	}
	public Spillkort(int verdi, Korttype type) {
		this.verdi = verdi; 
		korttype = type;
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
	public boolean bildeKort(){
	if(verdi>10)return true;		
		return false;	
	}
	public static int sammenligne(Spillkort s1, Spillkort s2){
		if (s1.getVerdi() > s2.getVerdi()) return 1;
		if(s1.getVerdi() < s2.getVerdi())return -1;
		return 0;
	}

	
}