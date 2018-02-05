import java.util.ArrayList;

public class Bok {
	public String tittel;
	public ArrayList<String> forfattere;
	public String forlag;
	public int utgivelsesaar;
	
	public Bok(String tittel, ArrayList<String> forfattere, String forlag, int utgivelsesaar){
		this.tittel=tittel;
		this.forfattere= forfattere;
		this.forlag= forlag;
		this.utgivelsesaar= utgivelsesaar;
	}

	public String getTittel() {
		return tittel;
	}

	public ArrayList<String> getForfattere() {
		return forfattere;
	}

	public String getForlag() {
		return forlag;
	}

	public int getUtgivelsesaar() {
		return utgivelsesaar;
	}
	
	public String toString(){
		String resultat="('"+ getTittel()+"' av "+getForfattere()
				+","+getForlag()+","+getUtgivelsesaar()+")";
		return resultat; 
	}
	
	public boolean equals(Object o){
		if(o instanceof Bok){
			Bok boken= (Bok)o;
			
			if(tittel.equals(boken.tittel) && 
					forfattere.equals(boken.forfattere))return true;
		
		}
		return false;
	}
	
	
}
