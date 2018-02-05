package application;

public class Terning {
	private int antallSider;
	private int verdi;
	public Terning(int antallSider) {
		this.antallSider = antallSider;
	}
	public void kast() {
		verdi = (int)(Math.random()*antallSider) + 1;
	}
	public int getVerdi() {
		return verdi;
	}
	public int getAntallSider() {
		return antallSider;
	}
}