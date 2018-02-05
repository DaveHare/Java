package oving3;

public class Spiller {

	public String navn;
	public int ID;
	public int poengsum;

	public Spiller(String navn, int ID) {
		this.navn=navn;
		this.ID=ID;
		poengsum=0;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getPoengsum() {
		return poengsum;
	}

	public void setPoengsum(int poengsum) {
		if(poengsum<0)poengsum=0;
		else this.poengsum = poengsum;	
		
	}

	public int getID() {
		return ID;
	}
	public String toString(){
		return  "Spiller "+ID+", "+navn+", har "+poengsum+" poeng";
	}
}
