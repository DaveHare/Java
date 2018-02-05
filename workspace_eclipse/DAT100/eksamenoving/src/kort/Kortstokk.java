package kort;

import java.util.ArrayList;
import java.util.Collections;

import kort.Spillkort.Korttype;

public class Kortstokk {
	private ArrayList<Spillkort> kortene; // kortene som er i stokken nå
	public Kortstokk() {
		kortene = new ArrayList<>();
		for (int a=1;a<=13;a++) {
			kortene.add(new Spillkort(a, Korttype.SPAR));
			kortene.add(new Spillkort(a, Korttype.RUTER));
			kortene.add(new Spillkort(a, Korttype.HJERTER));
			kortene.add(new Spillkort(a, Korttype.KLOVER));
		}
	}
	public void stokk() {
		Collections.shuffle(kortene);
	}
	public Spillkort trekk() {
		return kortene.remove(0);
	}
}