package application;
import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable{
	/*
	 * Lag en klasse «Person». En person har en ID, 
	 * et fornavn, et etternavn og et fødselsår. 
	 * Lag gettere for alle disse egenskapene. 
	 * Lag settere for de egenskapene som dette er 
	 * relevant for. Lag en toString metode som 
	 * lager en streng som inneholder alle 
	 * egenskapene til personen. 
	 */
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//instansvariabler
	private int ID;
	private CharSequence navn;
	private int fodeaar;
	private ArrayList<Hendelse> deltar;
	private String string;
	private static int nesteID=1;
	
	//konstruktrør
	public Person(CharSequence navn, int fodeaar) {
		ID = nesteID;
		nesteID++;
		this.navn = navn;
		this.fodeaar = fodeaar;
		deltar = new ArrayList<Hendelse>();
	}

	public Person(String string) {
		this.string = string;
		String[] del = string.split(", ");
		String part1 = del[0];
		navn=(CharSequence)part1;
		String part2 = del[1];
		fodeaar=Integer.parseInt(part2);
		String part3 = del[2];
		ID=Integer.parseInt(part3.substring(4));// for å fjerne "ID:"
	
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public CharSequence getNavn() {
		return navn;
	}

	public void setNavn(CharSequence navn) {
		this.navn = navn;
	}

	public int getFodeaar() {
		return fodeaar;
	}

	public void setFodeaar(int fodeaar) {
		this.fodeaar = fodeaar;
	}

	public String toString(){
		String info = navn +", "+fodeaar +", ID: "+ ID;
		return info;
	}

	public void skalDeltaPaa(Hendelse h){
		deltar.add(h);
	}

	public ArrayList<Hendelse> deltarPaa(){
		return deltar;
	}

}
