package stud6;

public class Ansatt extends Person {
	private int ansattID;
	private String stilling;
	private int aarslonn;
	
	
	public int getAnsattID() {
		return ansattID;
	}


	public void setAnsattID(int ansattID) {
		this.ansattID = ansattID;
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


	public Ansatt(String fornavn, String etternavn, int fodeaar) {
		super(fornavn, etternavn, fodeaar);
	}

	
	
	
	
	
	
	
}
