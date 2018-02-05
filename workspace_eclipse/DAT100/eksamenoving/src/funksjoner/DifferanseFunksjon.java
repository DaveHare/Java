package funksjoner;

public class DifferanseFunksjon implements Funksjon {
	public Funksjon g;
	public Funksjon h;
	
	public DifferanseFunksjon(Funksjon g, Funksjon h){
		this.g=g;
		this.h=h;
	}

	@Override
	public double beregn(double verdi) {
		return g.beregn(verdi)-h.beregn(verdi);
	}

}
