import java.util.ArrayList;
import java.util.Scanner;

public class Person {
	/*
	 * Lag en klasse «Person». En person har en ID, 
	 * et fornavn, et etternavn og et fødselsår. 
	 * Lag gettere for alle disse egenskapene. 
	 * Lag settere for de egenskapene som dette er 
	 * relevant for. Lag en toString metode som 
	 * lager en streng som inneholder alle 
	 * egenskapene til personen. 
	 */
	
	
	//instansvariabler
	int ID;
	String fornavn;
	String etternavn;
	int fodeaar;
	ArrayList deltar;

	//konstruktrør
	public Person(int ID, String fornavn, String etternavn, int fodeaar) {
		this.ID = ID;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.fodeaar = fodeaar;
		deltar = new ArrayList();
	
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public int getFodeaar() {
		return fodeaar;
	}

	public void setFodeaar(int fodeaar) {
		this.fodeaar = fodeaar;
	}

	public String toString(){
		String info = fornavn + " "+ etternavn+", "+fodeaar +", ID: "+ ID;
		return info;
	}

	public void skalDeltaPaa(Hendelse h){
		deltar.add(h);
	}

	public ArrayList deltarPaa(){
		return deltar;
	}




}
