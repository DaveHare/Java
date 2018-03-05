package stud6;

import java.util.ArrayList;

public class Student extends Person {

	private String studieprogram;
	private int aarskurs;
	private ArrayList<Emne> emner;
	
	public String getStudieprogram() {
		return studieprogram;
	}

	public void setStudieprogram(String studieprogram) {
		this.studieprogram = studieprogram;
	}

	public int getAarskurs() {
		return aarskurs;
	}

	public void setAarskurs(int aarskurs) {
		this.aarskurs = aarskurs;
	}

	public ArrayList<Emne> getEmner() {
		return emner;
	}

	public void setEmner(ArrayList<Emne> emner) {
		this.emner = emner;
	}

	public Student(String fornavn, String etternavn, int fodeaar) {
		super(fornavn, etternavn, fodeaar);
		
	}
	
	public String toString() {
		return super.toString() + " Går "+aarskurs+" år på studieprogram: "+ studieprogram+
				"og tar emnene: "+emner;
		
	}
	

}
