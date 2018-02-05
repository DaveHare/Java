package lesere;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import personer.Student;

public class StudentLeser implements Comparator<Student>{

	public static TreeMap<String, List<Student>> studentMap;
	public static HashMap<Integer, Student> studentMapID;
	public static TreeMap<String, List<Student>> studentMapNavn;


	public static List<Student> resultat;

	public static void studentMap(){
		studentMap= new TreeMap<String, List<Student>>();
		studentMapID= new HashMap<Integer, Student>();
		studentMapNavn = new TreeMap<String, List<Student>>();
		List<Student> liste= new ArrayList<Student>();
		//		System.out.println(resultat);
		for(Student studenten: resultat){
			String nokkel= studenten.getFornavn()+" "+ studenten.getEtternavn();
			if(studentMap.containsKey(nokkel)){
				liste=studentMap.get(nokkel);
				liste.add(studenten);
			}else{
				liste= new ArrayList<Student>();
				liste.add(studenten);
			}			
			studentMap.put(nokkel, liste);
			studentMapID.put(studenten.getID(), studenten);
			studentMapNavn.put(nokkel, liste);
		}
	}

	public static Student oppslagStudent(int id){
		return (Student) studentMapID.get(id);
	}

	@Override
	public int compare(Student arg0, Student arg1) {
		if (arg0.getFornavn().equals(arg1.getFornavn())) return -1;
		if (arg0.getFornavn().equals(arg1.getFornavn())) return 1;
		if (arg0.getEtternavn().equals(arg1.getEtternavn())) return -1;		
		if (arg0.getEtternavn().equals(arg1.getEtternavn())) return 1;
		if (arg0.getID() < arg1.getID()) return -1;		
		if (arg0.getID() > arg1.getID()) return 1;
		return 0;
	}





	public Student lesStudent(String innStreng) {
		String[] komponenter = innStreng.split("\t");
		try {
			int id = Integer.parseInt(komponenter[0]);
			int fodselsaar = Integer.parseInt(komponenter[3]);
			int aarskurs = Integer.parseInt(komponenter[5]);
			Student studenten = new Student(id, komponenter[2], komponenter[1], fodselsaar);
			studenten.setStudieprogram(komponenter[4]);
			studenten.setAarskurs(aarskurs);
			return studenten;
		} catch (NumberFormatException e) {
			System.err.println("Strengen : " + innStreng + " er i feil format!");
			return null;
		}
	}

	public static List<Student> lesStudenterFraFil() {
		resultat = new ArrayList<>();

		try {
			Scanner filleser = new Scanner(new File("studenter.txt"));
			String linje;
			StudentLeser leser = new StudentLeser();
			while (filleser.hasNextLine()) {
				linje = filleser.nextLine();
				Student studenten = leser.lesStudent(linje);
				resultat.add(studenten);
			}
			studentMap();
			return resultat;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {

		try {
			Scanner filleser = new Scanner(new File("studenter.txt"));
			String linje;
			StudentLeser leser = new StudentLeser();
			while (filleser.hasNextLine()) {
				linje = filleser.nextLine();
				Student studenten = leser.lesStudent(linje);
				//	System.out.println(studenten);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
