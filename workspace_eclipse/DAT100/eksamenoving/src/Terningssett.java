

import terning.Terning;

public class Terningssett{
	private boolean[] laast;
	private Terning[] terninger;
	public Terningssett(int antSider, int antTerninger){
		terninger= new Terning[antTerninger];
		laast= new boolean[antTerninger];

				for(int i =0;i<antTerninger;i++){
					terninger[i]= new Terning(antSider);
					laast[i]= false;
				}	
	}
	public void omkast(){

		for(int a=0; a< terninger.length; a++){
			if(laast[a]== false){
				terninger[a].kast();
			}
		}
	}

	/*
	 * Skriv en metode som tar inn to terningssett og sjekker hvor mange av plassene i
	 * terningssettet som har samme verdi. Hvis de to terningssettene er ulikt lange, bruk
	 * lengden til det korteste. 
	 */
	public static int antallLike(Terningssett t1, Terningssett t2){
		int lengde;
		int likPlasser = 0;
		if(t1.terninger.length>=t2.terninger.length)lengde=t1.terninger.length;
		else lengde=t2.terninger.length;
		for(int i =0; i<lengde;i++){
			if(t1.terninger[i].getVerdi()==t2.terninger[i].getVerdi())likPlasser++;		
		}
		return likPlasser;
		
		
	}

}