package stud6;

import java.util.ArrayList;

public class VitenskapligAnsatt extends Ansatt {
	
	public VitenskapligAnsatt(String fornavn, String etternavn, int fodeaar) {
		super(fornavn, etternavn, fodeaar);
		
	}

	private String fagfelt;
	private ArrayList<Emne> underviser;
	
	public String getFagfelt() {
		return fagfelt;
	}

	public void setFagfelt(String fagfelt) {
		this.fagfelt = fagfelt;
	}

	public ArrayList<Emne> getUnderviser() {
		return underviser;
	}

	public void setUnderviser(ArrayList<Emne> underviser) {
		this.underviser = underviser;
	}
	public String toString() {
		return super.toString() + " Fagfelt: "+ fagfelt +
				"Underviser i: "+underviser;
		
	}
	

}
