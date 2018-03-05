import stud7.Rute;
import stud7.Spiller;

public abstract class AbstraktRute implements Rute {

	private int posisjon;
	
	public AbstraktRute(int posisjon){
		this.posisjon=posisjon;

	}
	public int getPosisjon(){
		return posisjon;
	}
	
	@Override
	public void flyttHit(Spiller spilleren) {
		// TODO Auto-generated method stub

	}

}
