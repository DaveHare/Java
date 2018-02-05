import java.util.ArrayList;

public class VitenskapligAnsatt extends Ansatt {
	private String fagfelt;
	
	private ArrayList<Emne> underviserI;


	public VitenskapligAnsatt(String fornavn, String etternavn, int fodeaar) {
		super(fornavn, etternavn, fodeaar);
		fagfelt=null;
		underviserI= new ArrayList<Emne>();
		

	}



	public String getFagfelt() {
		return fagfelt;
	}

	public void setFagfelt(String fagfelt) {
		this.fagfelt = fagfelt;
	}

	public ArrayList<Emne> getUnderviserI() {
		return underviserI;
	}

	public void setUnderviserI(ArrayList<Emne> underviserI) {
		this.underviserI = underviserI;
	}
	public void  leggTilEmne(Emne ... emner){
		for(Emne emne : emner){
			underviserI.add(emne);
		}
		setUnderviserI(underviserI);

	}
	
	public String toString(){
		String resultat=super.toString()+"\nJobber med fagfeltet "+fagfelt+" og underviser i \n";
		for(Emne emne: underviserI){
			resultat+=emne.toString();
		}

		return resultat;

	}






	

}
