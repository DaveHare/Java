
public class Ansatt extends Person{
	
	private int ansattnummer; 
	private String stilling;
	private int aarslonn;
	public static int nesteAnsattnummer=340001;
	
	public Ansatt(String fornavn, String etternavn, int fodeaar) {
		super(fornavn, etternavn, fodeaar);
		ansattnummer=nesteAnsattnummer;
		nesteAnsattnummer++;
		stilling=null;
		aarslonn=0;
	}


	
	
	public int getAnsattnummer() {
		return ansattnummer;
	}
	
	public void setAnsattnummer(int ansattnummer) {
		this.ansattnummer = ansattnummer;
	}
	
	public String getStilling() {
		return stilling;
	}
	
	public void setStilling(String stilling) {
		this.stilling = stilling;
	}
	
	public int getAarslonn() {
		return aarslonn;
	}
	

	public void setAarslonn(int aarslonn) {
		this.aarslonn = aarslonn;
	}

	


	public String toString(){
		
		String resultat=super.toString()+" \nHar ansattnummer "+ansattnummer +", stilling som "+stilling +" med årslønn "+aarslonn +".";
		return resultat;
		
	}




	
}
