package funksjoner;

public class TesteDiff {

	public static void main(String[] args) {
		Funksjon g= new KvadratiskFunksjon(0.5, 0.2, 0);
		Funksjon h= new EksponentialFunksjon(1);
		
		
		for(int verdi= 1; verdi<11 ; verdi++){
			Funksjon f = new DifferanseFunksjon(g,h);
			System.out.println(g.beregn(verdi) +"    "+ h.beregn(verdi) +"    "+ f.beregn(verdi));
			
		}

	}

}
