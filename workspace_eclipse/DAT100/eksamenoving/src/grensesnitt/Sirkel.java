package grensesnitt;

public class Sirkel implements Omraade{
	private Punkt sentrum;
	private double radius;
	 public Sirkel(Punkt sentrum, double radius){
		 this.sentrum=sentrum;
		 this.radius= radius;
	 }

	@Override
	public double areal() {
		double areal= Math.PI*radius*radius;
		return areal;
	}

}
