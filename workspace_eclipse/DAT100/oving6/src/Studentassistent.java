import java.util.ArrayList;

public class Studentassistent extends Ansatt{

	private int timelonn;
	private int timer;
	private ArrayList<Emne> assistentI;
	private int aarslonn;

	public Studentassistent(String fornavn, String etternavn, int fodeaar) {
		super( fornavn, etternavn, fodeaar);
		timelonn=0;
		timer=0;
		assistentI=new ArrayList<Emne>();
	}

	public int getTimelonn() {
		return timelonn;
	}

	public void setTimelonn(int timelonn) {
		this.timelonn = timelonn;
	}

	public double getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public ArrayList<Emne> getAssistentI() {
		return assistentI;
	}

	public void setAssistentI(ArrayList<Emne> assistentI) {
		this.assistentI = assistentI;
	}
	public void leggTilEmne(Emne ... emnene){
		for(Emne emne: emnene){
			assistentI.add(emne);
		}
		setAssistentI(assistentI);
	}

	public int getAarslonn() {
		return aarslonn;
	}

	@Override public void setAarslonn(int aarslonn){
		this.aarslonn= timer *timelonn;
	}

	public String toString(){
		String resultat= super.toString()+" \n"+getFornavn() +" er studass i: \n";
		for(Emne emne: assistentI){
			resultat+= emne.getEmnenavn()+",\n";
		}
		resultat+= "og har jobbet "+ timer+ " timer med en timeslonn på "+ timelonn+ ".\n"
				+ "Dette tilsvarer en årslønn på "+ aarslonn;
		return resultat;
	}




}
