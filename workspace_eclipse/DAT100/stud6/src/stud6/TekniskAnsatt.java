package stud6;

public class TekniskAnsatt extends Ansatt {

	private Rom rom;
	public TekniskAnsatt(String fornavn, String etternavn, int fodeaar) {
		super(fornavn, etternavn, fodeaar);
	}
	
	
	public Rom getRom() {
		return rom;
	}


	public void setRom(Rom rom) {
		this.rom = rom;
	}


	public String toString() {
		return super.toString() + " Ansvarlig for Rom: "+ rom;
	}
	

}
