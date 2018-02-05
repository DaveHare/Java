package lesere;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import emner.Emne;
import personer.Student;

public class EmneLeser {
	
	public static HashMap<String,Emne> emneMap;
	public static List<Emne> resultat;

	public static void emneMap(){	
		emneMap= new HashMap<>();
		for(Emne emnet:resultat){
			emneMap.put(emnet.getEmnekode(), emnet);
		}
	}
	
	public static Emne oppslagEmne(String emnekode){
		return (Emne) emneMap.get(emnekode);
		
		
	}

	public Emne lesEmne(String innStreng) {
		String[] komponenter = innStreng.split("\t");
		Emne emnet = new Emne(komponenter[0], komponenter[1], komponenter[2].charAt(0));
		emnet.setStudiepoeng(Integer.parseInt(komponenter[3]));
		return emnet;
	}

	public static List<Emne> lesEmnerFraFil() {
		resultat = new ArrayList<Emne>();
		try {
			Scanner filleser = new Scanner(new File("emner.txt"));
			String linje;
			EmneLeser leser = new EmneLeser();
			while (filleser.hasNextLine()) {
				linje = filleser.nextLine();
				Emne emnet = leser.lesEmne(linje);
				resultat.add(emnet);
			}
			emneMap();
			return resultat;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {
		
		try {
			Scanner filleser = new Scanner(new File("emner.txt"));
			String linje;
			EmneLeser leser = new EmneLeser();
			while (filleser.hasNextLine()) {
				linje = filleser.nextLine();
				Emne emnet = leser.lesEmne(linje);
				System.out.println(emnet);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
