package application;

import java.io.Serializable;

public class Terningssett implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Terning[] terningene;
	private boolean[] laast;
	public Terningssett(int antall, int sider) {
		terningene = new Terning[antall];
		laast = new boolean[antall];
		for (int a=0;a<antall;a++) {
			terningene[a] = new Terning(sider);
			laast[a] = false;
		}
		kast();
	} 
	public void setLaas(int hvilkenTerning, boolean skalVaereLaast) {
		laast[hvilkenTerning] = skalVaereLaast;
	}
	public void flippLaas(int hvilkenTerning) {
		laast[hvilkenTerning] = !laast[hvilkenTerning];
	}
	public boolean getLaas(int hvilkenTerning) {
		return laast[hvilkenTerning];
	}
	public void kast() {
		for(int a=0;a<terningene.length;a++) {
			if (!laast[a]) terningene[a].kast();
		}
	}
	public int sum() {
		int sum = 0;
		for(int a=0;a<terningene.length;a++) {
			sum += terningene[a].getVerdi();
		}
		return sum;
	}
	public int antallMedVerdi(int verdi) {
		int antall = 0;
		for(int a=0;a<terningene.length;a++) {
			if (terningene[a].getVerdi() == verdi) antall++;
		}
		return antall;
	}
	public int getAntallTerninger() {
		return terningene.length;
	}
	public int getTerningverdi(int hvilken) {
		return terningene[hvilken].getVerdi();
	}
	public static int antallLike(Terningssett mine, Terningssett spillerens) {
		int antall = 0;
		for (int i=0;i<5;i++) {
			if (mine.getTerningverdi(i) == spillerens.getTerningverdi(i)) {
				antall++;
			}
		}
		return antall;
	}
}