package areal;

import grensesnitt.Omraade;

public class Sirkel implements Omraade {
	private Punkt sentrum;
	private double radius;
	
	public Sirkel(Punkt sentrum, int radius){
		this.sentrum=sentrum;
		this.radius= radius;		
	}

	@Override
	public double areal() {
		return Math.PI*radius*radius;
	}

}
