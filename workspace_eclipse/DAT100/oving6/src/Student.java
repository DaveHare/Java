import java.util.ArrayList;

public class Student extends Person{
	
	private String studieretning;
	private int aarskurs;
	private ArrayList<Emne> tarEmne;
	
	public Student(String fornavn, String etternavn, int fodeaar) {
		super(fornavn, etternavn, fodeaar);
		studieretning=null;
		aarskurs=0;
		tarEmne=new ArrayList<Emne>();
		
	}
	
	public String getStudieretning() {
		return studieretning;
	}
	
	public void setStudieretning(String studieretning) {
		this.studieretning = studieretning;
	}
	
	public int getAarskurs() {
		return aarskurs;
	}
	
	public void setAarskurs(int aarskurs) {
		this.aarskurs = aarskurs;
	}
	
	public ArrayList<Emne> getTarEmne() {
		return tarEmne;
	}
	
	public void setTarEmne(Emne ...emner) {
		for(Emne emnet: emner){
			tarEmne.add(emnet);
		}
		
		this.tarEmne = tarEmne;
	}
	
	
	public String toString(){
		String resultat=super.toString() + "\nStuderer "+studieretning+" i årskurs "+aarskurs+" og tar emnene: \n";
		
		for(Emne emne: tarEmne){
			resultat +=emne.toString();
		}
		return resultat;
		
	}
	
	
}
