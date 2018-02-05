package personer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import emner.Emne;
import lesere.StudentLeser;

public class Student extends Person {
	private String studieprogram;
	private int aarskurs;
		
	
	public Student(int ID, String fornavn, String etternavn, int fodselsaar) {
		super(ID, fornavn, etternavn, fodselsaar);
		studieprogram = "Ikke definert";
		aarskurs = 1;
	}
	
//	public static Student TreeMap(){
//		
//		Student studenten= null;
//		
//		
//		return studenten;
//	}
	
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

	// Oppgave f)
	@Override public String toString() {
		return "Student " + getID() + ": " + 
				getNavnestreng() + " studerer " +
				studieprogram + " og er i " + aarskurs +
				" årskurs";
	}
}
