package oppgave3;

public class Pair<T> {
	
	/*
	 * Lag en generisk type Pair<T>, som representerer et par med objekter 
	 * hvor begge objektene skal ha samme type. Et Pair objekt skal ha en 
	 * konstruktør samt gettere og settere for første og andre element i paret. 
	 * Lag også en main metode som demonstrerer bruken av Pair klassen gjennom 
	 * å lage og bruke Pair instanser med i alle fall to ulike typeparametre, 
	 * for eksempel String og Integer.
	 */
	
	
	public T t1;
	public T t2;

public Pair(T t1,T t2){
	this.t1=t1;
	this.t2=t2;
	 
 }

public T getT1() {
	return t1;
}

public void setT1(T t1) {
	this.t1 = t1;
}

public T getT2() {
	return t2;
}

public void setT2(T t2) {
	this.t2 = t2;
}

}
