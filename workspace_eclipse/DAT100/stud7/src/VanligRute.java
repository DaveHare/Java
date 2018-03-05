import stud7.Rute;
import stud7.Spiller;

public class VanligRute extends AbstraktRute implements Rute {

	public VanligRute(int posisjon) {
		super(posisjon);
		
	}
	public void flyttHit(Spiller spilleren) {
		System.out.println(spilleren.getNavn()+ " har truffet en vanlig rute! "
				+ "Nåværende rute: " +spilleren.getPoengsum()+".");
	}

}
