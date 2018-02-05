package personer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import emner.Emne;

// Oppgave c)
public class Student extends Person {
	private String studieprogram;
	private int aarskurs;
	private ArrayList<Emne> oppmeldtI;
	
	/* Oppgave j:
	 * Hvis en student skal bli studentassistent og studentassistent er en egen
	 * klasse, må et nytt objekt av typen studentassistent lages for studenten.
	 * Det nye objektet må erstatte det gamle alle steder hvor det gamle
	 * objektet er brukt! Dette krever mye administrasjon og kode og er
	 * sårbart for feil.
	 * 
	 * Bedre løsning:
	 * Legg til egenskapene for studentassistent i studentklassen og la dem
	 * ha nullverdier for studenter som ikke er studentassistenter. Nullverdier
	 * tar ikke opp så mye plass at det er et problem for moderne datamaskiner.
	 * I mindre systemer som de dere vil jobbe med i ELE210 Datamaskinarkitektur
	 * kan det være viktig å optimalisere minnebruk.
	 * */
	
	public Student(int ID, String fornavn, String etternavn, int fodselsaar) {
		super(ID, fornavn, etternavn, fodselsaar);
		oppmeldtI = new ArrayList<>();
	}
	
	public void meldOppStudet(Emne emnet) {
		oppmeldtI.add(emnet);
	}
	
	public boolean avmeldStudent(Emne emnet) {
		return oppmeldtI.remove(emnet);
	}

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

	public List<Emne> getOppmeldtI() {
		return Collections.unmodifiableList(oppmeldtI);
	}

	// Oppgave f)
	@Override public String toString() {
		return "Student " + getID() + ": " + 
				getNavnestreng() + " studerer " +
				studieprogram + " og er i " + aarskurs +
				" årakurs";
	}
}
