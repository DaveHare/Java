package funksjoner;

public class EksponentialFunksjon implements Funksjon{
public double a;
	public EksponentialFunksjon(double a){
		this.a=a;
	}
	public double beregn(double verdi){
		return Math.pow(a, verdi);
	}

}
