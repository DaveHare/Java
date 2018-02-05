package terning;


public class ProsentTerning extends Terning {
	public ProsentTerning() {
		super(100);
	}
	
	public int getTiere(){
		int resultat= getVerdi();
		return resultat/10;
	}
	
	public int getEnere(){
		int resultat= getVerdi();
		return resultat%10;
	}
	public int getFlipped(){
		return 10*getEnere() + getTiere();
	}
	
}
