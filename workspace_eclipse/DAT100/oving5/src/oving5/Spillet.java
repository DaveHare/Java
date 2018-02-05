package oving5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

//import oving3.Spiller;



public class Spillet {

	//private static final Spiller[] Object = null;
	static ArrayList<Spiller>  spillere;
	static ArrayList<Spiller>  ferdig;
	Scanner inn= new Scanner(System.in);

	public Spillet() {
		spillere =new ArrayList<Spiller>();
		ferdig =new ArrayList<Spiller>();
	}
	public Spiller lesInnSpiller(Scanner inn){
		System.out.println("Navn: ");
		String navn=inn.next();
		int poengsum=0;
		for(int i=1;i<=3;i++){
			Terning nyttKast= new Terning();
			poengsum+= nyttKast.getTall();
		}

		Spiller spilleren= new Spiller(navn, poengsum);
		return spilleren;
	}


	public void leggTilSpiller(Spiller enSpiller){
		spillere.add(enSpiller);
	}

	public void omgang(Spiller spilleren){
		Scanner inn= new Scanner(System.in);

		int poengsum=spilleren.getPoengsum();
		System.out.println("--------------------------------------------");
		System.out.println("Det er " + spilleren.getNavn() + " sin tur, med poengsum: " + poengsum);
		System.out.println(" Vil du kaste engang til? (j/n) :");
		String svar= inn.nextLine();


		if ((svar.equals("j")) ||(svar.equals("ja"))){
			Terning nyttKast= new Terning();
			poengsum += nyttKast.getTall();
			spilleren.setPoengsum(poengsum);
			Boolean sjekkTap=harManTapt(spilleren);
			if (sjekkTap==false){
				System.out.println(spilleren.getNavn()+" kastet en "+nyttKast.getTall()+"er."
						+ " Ny score er "+ spilleren.getPoengsum());
			}
			else{
				System.out.println(spilleren.getNavn() + " har mer en 21 poeng og har derfor tapt.");
			}
		}

		if ((svar.equals("n")) ||(svar.equals("nei"))){
			ferdig.add(spilleren);
			System.out.println(spilleren.getNavn()+ " har gitt seg med"+ spilleren.getPoengsum()+ " poeng.");
			spillere.remove(spilleren);
			
		}


	}

	public Boolean harManTapt(Spiller spilleren){
		int poengsum= spilleren.getPoengsum();
		if (poengsum>=22){
			spillere.remove(spilleren);
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * sjekker  om Array ferdig  har ett element
	 * @param ferdig: Array av deltakere som har gitt seg.
	 * @return
	 */
	public Spiller sjekkVinner(ArrayList<Spiller> ferdig){
		if (ferdig.size()==1){
			return ferdig.get(0);
		}

		else 
		{
			for (int i = 0; i>=ferdig.size();i++){
				ferdig.remove(Spiller.MinstScore(ferdig.get(0), ferdig.get(1)));
				if (ferdig.size()==1){
					break;// for loop
				}
			}
			return ferdig.get(0);				
		}
	}






	public ArrayList<Spiller> enRunde(){
		for (int i =0; i<spillere.size();i++) {
			omgang(spillere.get(i));
		}
		return spillere;
	}


	public static void main(String[] args){

		Spillet spillet = new Spillet();

		Scanner inn= new Scanner(System.in);
		System.out.println("Hvor mange spillere skal være med? :");
		int antallSpillere= inn.nextInt();

		for(int i=1;i<=antallSpillere;i++){			
			Spiller enSpiller= new Spiller();
			enSpiller= spillet.lesInnSpiller(inn);
			spillere.add(enSpiller);
		}
		Spiller vinner= new Spiller();

		while(true){
			spillet.enRunde();
			if (spillere.size()==0){
				vinner=spillet.sjekkVinner(ferdig);
				break;
			}
		}
		System.out.println( vinner.getNavn() +" har vunnet med "+ vinner.getPoengsum() +" poeng.");
	}

}
