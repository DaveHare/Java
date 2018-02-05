package funksjoner;

public class KvadratiskFunksjon implements Funksjon{

		private double a, b, c; // Funksjon f(x) = axx + bx + c
		
		public KvadratiskFunksjon(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
		}
		@Override
		public double beregn(double verdi) {
		return a*verdi*verdi + b*verdi + c;
		}
		
		public static Funksjon xplussaiandre(double a){
			return new KvadratiskFunksjon(1.0, 2.0*a,a*a);
		}
		
}
