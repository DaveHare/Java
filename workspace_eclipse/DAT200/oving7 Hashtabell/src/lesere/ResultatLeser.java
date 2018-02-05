package lesere;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

import emner.Eksamensresultat;
import emner.Emne;
import personer.Student;

public class ResultatLeser {
	private static List<Student> studentene;
	private static List<Emne> emnene;
	private static List<Eksamensresultat> resultat;

	private HashMap<Integer, Student> studentMapID;
	private TreeMap<String, List<Student>> studentMap;
	private TreeMap<String, List<Student>> studentMapNavn;
	private HashMap<String, Emne> emneMap;
	private static HashMap<Character,Eksamensresultat> resultatMap;
	public static HashMap<Student, List<Eksamensresultat>> resultatMapNavn;





	public static void resultatMap(){

		resultatMap= new HashMap<>();
		resultatMapNavn= new HashMap<>();
		List<Eksamensresultat> liste;
		for(Eksamensresultat resultatet : resultat){
			Student nokkel= resultatet.getStudenten();
			
			if(resultatMapNavn.containsKey(nokkel)){
				liste= resultatMapNavn.get(nokkel);
				liste.add(resultatet);
//				System.out.println(" "+ liste.size());
			}else{
				liste= new ArrayList<Eksamensresultat>();
				liste.add(resultatet);
//				System.out.println(resultatet.getKarakter());
			}
			
			resultatMap.put(resultatet.getKarakter(), resultatet);
			resultatMapNavn.put(resultatet.getStudenten(), liste);
		}
		
	}


	public ResultatLeser() {
		studentene = new StudentLeser().lesStudenterFraFil();
		studentMapID = StudentLeser.studentMapID;
		studentMap = StudentLeser.studentMap;
		studentMapNavn = StudentLeser.studentMapNavn;
		//		System.out.println(studentMap);
		emnene = new EmneLeser().lesEmnerFraFil();
		emneMap=EmneLeser.emneMap;

		resultat = new ArrayList<>();
		resultat= lesResultaterFraFil();
//		resultatMapNavn=resultatMapNavn;
	}

	/*
	 * O(n) kjøretid placeholder. Implementer en mer effektiv versjon her!
	 */
	private static Student finnStudent(int id) {
		for (Student studenten: studentene) {
			if (studenten.getID() == id) return studenten;
		}
		return null;
	}

	private static Student finnStudent1(int id){
		return StudentLeser.oppslagStudent(id);
	}

	/*
	 * O(n) kjøretid placeholder. Implementer en mer effektiv versjon her!
	 */
	private static Emne finnEmne(String emnekode) {
		for (Emne emnet: emnene) {
			if (emnet.getEmnekode().equals(emnekode)) return emnet;
		}
		return null;
	}

	private static Emne finnEmne1(String emnekode) {
		return EmneLeser.oppslagEmne(emnekode);
	}



	private static Eksamensresultat lesResultat(String innStreng) {
		String[] komponenter = innStreng.split("\t");
		Student student = finnStudent1(Integer.parseInt(komponenter[0]));
		Emne emnet = finnEmne1(komponenter[1]);
		Eksamensresultat resultatet = new Eksamensresultat(student, emnet, komponenter[2].charAt(0));

		return resultatet;
	}

	public static List<Eksamensresultat> lesResultaterFraFil() {
		resultat = new ArrayList<>();
		try {
			Scanner filleser = new Scanner(new File("karakterer.txt"));
			String linje;
			while (filleser.hasNextLine()) {
				linje = filleser.nextLine();
				Eksamensresultat resultatet = lesResultat(linje);
				resultat.add(resultatet);
			}
			resultatMap();
			return resultat;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		ResultatLeser leser = new ResultatLeser();
		List<Eksamensresultat> resultatene = leser.lesResultaterFraFil();
		for (Eksamensresultat resultatet: resultatene) {
			System.out.println(resultatet.getStudenten().getEtternavn() + 
					", " + resultatet.getStudenten().getFornavn() + 
					" har fått " + resultatet.getKarakter() + " i " + 
					resultatet.getEmnet().getEmnenavn());
		}
	}
}
