
public class TilbakeTilStart extends 
AbstraktRute implements Rute{



		public TilbakeTilStart(int posisjon) {
		super(posisjon);
		
	}

		public void flyttHit(Spiller spilleren){
			System.out.print(spilleren.getNavn()+ " traff rute: "+ spilleren.getPoengsum()
			+" som er en 'Tilbake til start'-rute! ");
			spilleren.setPoengsum(0);
			System.out.println("Du ryker desverre tilbake til start."
					+ "Nåværende rute: " + spilleren.getPoengsum()+".");
		}
}
