package oppgave2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import emner.Eksamensresultat;
import emner.Emne;
import lesere.EmneLeser;
import lesere.ResultatLeser;
import lesere.StudentLeser;
import personer.Student;

public class testmetoder {

	private static TreeMap<String, List<Student>> studentMapNavn;
	private static HashMap<String, Emne> emneMap;
	private static HashMap<Student,List<Eksamensresultat>> resultatMapNavn;
	//	

	//	punkt 1
	public static void sortertStudent(TreeMap<String,List<Student>> studentMapNavn){
		for(Entry<String,List<Student>> navnNokkel: studentMapNavn.entrySet()){
			System.out.println(navnNokkel.getValue());
		}
		System.out.println("\n \n");
	}

	public static String  skrivInn(){
		Scanner inn = new Scanner(System.in);
		System.out.print("\nFornavn: ");
		String fornavn = inn.nextLine();
		fornavn = fornavn.substring(0, 1).toUpperCase() + fornavn.substring(1).toLowerCase();
		System.out.print("Etternavn: ");
		String etternavn = inn.nextLine();
		etternavn = etternavn.substring(0, 1).toUpperCase() + etternavn.substring(1).toLowerCase();
		return fornavn + " " + etternavn;
	
	}
	//	punkt 2
	public static List<Student> omStudent(){
		String navn= skrivInn();
		try{
			List<Student> studenten=studentMapNavn.get(navn);
			//			System.out.println(studenten);
			return studenten;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	private static List<Character> getKarakterer() {
		try {
			List<Student> studentliste= omStudent();
			List<Character> karakterer= new ArrayList<>();
			if (studentliste.isEmpty()) {
				System.out.println("Ingen karakterer registrert på denne studenten.");
			} else {
				for(Student studenten: studentliste){
					//					System.out.println(resultatMapNavn.get(studenten));

					List<Eksamensresultat> resultatliste = resultatMapNavn.get(studenten);
					//					System.out.println(resultatliste.toString());
					if (resultatliste.isEmpty()){
						System.out.println("Ingen karakterer registrert.");
					}else {
						for(Eksamensresultat resultatet: resultatliste) {

							karakterer.add(resultatet.getKarakter());
							//							System.out.println(resultatet.getKarakter());
						}
					}
				}
			}
			return karakterer;
		} catch (NullPointerException e) {
			System.err.println("Ingen student med dette navnet funnet!");
			e.printStackTrace();
		}
		return null;
	}	
	public static String  skrivInn2(){
		Scanner inn = new Scanner(System.in);
		System.out.print("\nEmnekode: ");
		String emnet = inn.nextLine();
		emnet= emnet.toUpperCase();
		return emnet;
	
	}
	private static Emne getEmneobjekt() {
		String string= skrivInn2();
		try{
			Emne emnet= emneMap.get(string);
			return emnet;	
		} catch (NullPointerException e) {
			System.err.println("Ingen emne med denne emnekoden funnet!");
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		ResultatLeser leser= new ResultatLeser();
		//		List<Eksamensresultat> resultatene = new ArrayList<Eksamensresultat>(leser.lesResultaterFraFil());
		//StudentLeser.lesStudenterFraFil();
		studentMapNavn=StudentLeser.studentMapNavn;
		emneMap=EmneLeser.emneMap;
		resultatMapNavn=ResultatLeser.resultatMapNavn;

		if(!studentMapNavn.isEmpty()){
			System.out.println("har innhold");
		}
		if(!emneMap.isEmpty()){
			System.out.println("har innhold");
		}
		if(!resultatMapNavn.isEmpty()){
			System.out.println("har innhold");
		}


		sortertStudent(studentMapNavn);

		List<Student> studenter = omStudent();
		Student studenten = studenter.get(0);
		System.out.println(studenten);

		List<Character> karakterer=getKarakterer();
		System.out.println(karakterer.toString());

		Emne emnet = getEmneobjekt();
		System.out.println(emnet.getEmnenavn());


	}




}
