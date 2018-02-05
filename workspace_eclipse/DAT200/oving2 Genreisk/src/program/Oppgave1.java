package program;


import java.util.ArrayList;



import student.Student;


public class Oppgave1 {

	public static ArrayList<Student>  sjekkFornavnListe(ArrayList<Student> studentliste, String fornavn){
		
		ArrayList<Student> sammeFornavnListe= new ArrayList<Student>();
		
		for(int i =0;i<studentliste.size();i++){
			if(fornavn.equals(studentliste.get(i).getFornavn())){
				sammeFornavnListe.add(studentliste.get(i));
			}
		}
		
		return sammeFornavnListe;
	}
	
	public static void main(String[] args) {
	ArrayList<Student> studentliste= Utskrift.lesInnStudenter();
	System.out.println(studentliste+"\n");
	
	studentliste=sjekkFornavnListe(studentliste, "Anne");
	System.out.println(studentliste);
	}
	

	}


