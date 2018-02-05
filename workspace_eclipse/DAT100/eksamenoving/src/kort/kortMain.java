package kort;

import java.util.ArrayList;

public class kortMain{

	public static void main(String[] args){
		Kortstokk stokken= new Kortstokk();
		stokken.stokk();

		ArrayList<Spillkort> spiller1= new ArrayList<Spillkort>();
		ArrayList<Spillkort> spiller2= new ArrayList<Spillkort>();	
		boolean i= true;
		do{
			Spillkort k1=stokken.trekk();
			Spillkort k2=stokken.trekk();
			System.out.println(k1.toString()+",  "+k2.toString());
			
			if(k1.bildeKort() && k2.bildeKort())i=true;
			else i=false;
			
			spiller1.add(k1);
			spiller2.add(k2);

		}while(i==true);
int a=kortSum(spiller1);
int b=kortSum(spiller2);
int sum;
int vinner;
		if(a>b){
			vinner=1;
			sum=a;
		}
		else{
			vinner=2;
			sum=b;
		}
		System.out.println("Vinnerern er spiller "+vinner+", med "+sum+" poeng." );

	}
	
	public static int kortSum(ArrayList<Spillkort> kortene){
		int resultat = 0;
		for(Spillkort kortet: kortene){
			resultat+=kortet.getVerdi();
		}
		return resultat;
	}

}
