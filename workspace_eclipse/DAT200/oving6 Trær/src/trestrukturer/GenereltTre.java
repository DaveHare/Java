package trestrukturer;

import java.util.ArrayList;
import java.util.List;

/*
 * Enkel Java versjon av et generelt tre
 */
public class GenereltTre <T> {
	private T objekt;
	private List<GenereltTre<T>> barn = new ArrayList<>();
	
	public void setObjekt(T objekt) {
		this.objekt = objekt;
	}
	
	public void leggTilTre(GenereltTre<T> treet) {
		barn.add(treet);
	}
}
