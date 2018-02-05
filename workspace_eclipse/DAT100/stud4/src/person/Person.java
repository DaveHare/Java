package person;

import java.util.ArrayList;

import hendelse.Hendelse;

public class Person {
	public int ID;
	public String fornavn;
	public String etternavn;
	public int fodselsaar;
	public static int nextID=0;
	public ArrayList<Hendelse> deltarPaa;
	
	public Person(String fornavn, String etternavn, int fodselsaar) {
		ID= nextID;
		nextID++;
		this.fornavn=fornavn;
		this.etternavn= etternavn;
		this.fodselsaar=fodselsaar;	
		deltarPaa=new ArrayList();
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

	public int getFodselsaar() {
		return fodselsaar;
	}

	public void setFodselsaar(int fodselsaar) {
		this.fodselsaar = fodselsaar;
	}

	public int getID() {
		return ID;
	}
	public String toString() {
		return ID +", "+ fornavn +" "+ etternavn+", "+ fodselsaar;
	}
	
	public void skalDeltaPaa(Hendelse hendelsen) {
		deltarPaa.add(hendelsen);
		}
	
}
