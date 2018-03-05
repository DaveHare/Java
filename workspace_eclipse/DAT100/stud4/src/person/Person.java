package person;
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
	private int ID;
	private String fornavn;
	private String etternavn;
	private int fodeaar;
	private static int nesteID=1;



	

	//konstruktrør
	public Person(String fornavn, String etternavn, int fodeaar) {
		ID=nesteID;
		nesteID++;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.fodeaar = fodeaar;
		

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

	//	public void skalDeltaPaa(Hendelse h){
	//		deltar.add(h);
	//	}
	//
	//	public ArrayList deltarPaa(){
	//		return deltar;
	//	}




}
