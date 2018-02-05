package kort;

import java.util.ArrayList;

public class MainKort implements  {
	public static Kortstokk kortstokk;
	public static void main(String[] args) {
		kortstokk= new Kortstokk();
		
		
	}


	public int kortSum(ArrayList<Spillkort> kortene){
		int sum=0;
		for(Spillkort kortet: kortene){
			sum+=kortet.getVerdi();
		}
		return sum;
	}

}
