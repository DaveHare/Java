import stud7.Rute;
import stud7.Spiller;

public class TilbakeTilStart extends AbstraktRute implements Rute {

	public TilbakeTilStart(int posisjon) {
		super(posisjon);
		// TODO Auto-generated constructor stub
	}
	
	public void flyttHit(Spiller spilleren){
		int fikk= spilleren.getPoengsum();
		spilleren.setPoengsum(0);
		
		System.out.println(spilleren.getNavn()+" har truffet rute "+fikk+" som er en tilbake-til-start-Rute, /n		"
				+ "og flytter tilbake til start! "
				+ "Nåværende rute: "+spilleren.getPoengsum()+".");
	
	}
	

}
