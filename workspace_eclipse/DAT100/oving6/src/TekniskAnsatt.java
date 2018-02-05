import java.util.ArrayList;

public class TekniskAnsatt extends Ansatt {

	
	private ArrayList<Rom> ansvarForRom;
	
	
	public TekniskAnsatt( String fornavn, String etternavn, int fodeaar) {
		super( fornavn, etternavn, fodeaar);
		ansvarForRom=new ArrayList<Rom>();
		
	}
	
	

	public ArrayList<Rom> getAnsvarForRom() {
		return ansvarForRom;
	}

	public void setAnsvarForRom(ArrayList<Rom> ansvarForRom) {
			this.ansvarForRom = ansvarForRom;
	}
	
	public void leggTilRom(Rom ... rommene){
		for(Rom rom:rommene){
			ansvarForRom.add(rom);
		}
		setAnsvarForRom(ansvarForRom);
	}

	public String toString(){
		String resultat=super.toString()+"\nHar ansvar for rom: \n";
		for (Rom rom:ansvarForRom){
			resultat +=rom.toString();
		}
		
		
		return resultat;
		
	}
	

}
