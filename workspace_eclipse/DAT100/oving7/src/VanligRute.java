
public class VanligRute extends 
AbstraktRute implements Rute{

	public VanligRute(int posisjon) {
		super(posisjon);
	}
	public void flyttHit(Spiller spilleren){

		System.out.println(spilleren.getNavn()+ " har truffet en vanlig rute! "
				+ "N�v�rende rute: " +spilleren.getPoengsum()+".");
		//spiller.setPoengsum(this.posisjon)
	}



}
