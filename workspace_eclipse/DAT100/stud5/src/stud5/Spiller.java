package stud5;

public class Spiller {
	private int _ID;
	private String _navn;
	private int _poengsum;
	
	private static int nesteID = 1;
		
	public Spiller(String navn) {
		this._ID = nesteID;
		nesteID++;
		this._navn = navn;
		_poengsum = 0;
	}	

	public String getNavn() {
		return _navn;
	}

	public void setNavn(String navn) {
		if (navn.equals("")) {
			throw new IllegalArgumentException("Navn på spiller kan ikke være en tom streng!");
		}
		this._navn = navn;
	}

	public int getPoengsum() {
		return _poengsum;
	}

	public void setPoengsum(int poengsum) {
		if (poengsum < 0) {
			throw new IllegalArgumentException("Poengsum kan ikke være negativ!");
		}
		this._poengsum = poengsum;
	}

	public int getID() {
		return _ID;
	}
	
	public String toString() {
		return "Spiller, ID " + _ID + ", navn: " + _navn + 
				" og poeng: " + _poengsum;
	}
	
	public static Spiller hoyestePoengsum(Spiller s1, Spiller s2) {
		if (s2.getPoengsum() > s1.getPoengsum()) return s2;
		return s1;
	}
}
