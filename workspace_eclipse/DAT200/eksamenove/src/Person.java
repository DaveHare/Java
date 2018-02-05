package finnelement;

public class Person implements Comparable<Person> {
	private int id;
	private String etternavn;
	private String fornavn;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEtternavn() {
		return etternavn;
	}
	
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	
	public String getFornavn() {
		return fornavn;
	}
	
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	@Override
	public int compareTo(Person o) {
		int sammenlikning = etternavn.compareTo(o.etternavn);
		if (sammenlikning != 0) return sammenlikning;
		sammenlikning = fornavn.compareTo(o.fornavn);
		return sammenlikning;
	}
	
}
