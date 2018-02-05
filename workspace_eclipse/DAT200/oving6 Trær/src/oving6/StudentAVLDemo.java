package oving6;


import personer.Student;
/*
 * Lag et AVL treeMap objekt hvor du kan leite etter studenter 
 * basert på etternavn. Bruk klassen fra timene eller din egen 
 * AVL treemap klasse. Skriv en main() metode som demonstrerer 
 * dette. Bruk studentklassen fra utdelt kode.
 */

public class StudentAVLDemo {

	public static void main(String[] args) {
		Student student1= new Student(1,"Silje","Mugsveen",1997);
		student1.setAarskurs(1);
		student1.setStudieprogram("Ingeniørfag - Data");

		
		AVLTre<String, Student> studentliste = new AVLTre<>();
		studentliste.put(student1.getEtternavn(), student1);
		studentliste.put("Olsen", new Student(2, "Hanne", "Olsen", 1992));
		studentliste.put("Alsen", new Student(3, "Anne", "Alsen", 1994));
		studentliste.put("Tolsen", new Student(4, "Janne", "Tolsen", 1993));
		studentliste.put("Bolsen", new Student(5, "Kanne", "Bolsen", 1996));
		studentliste.put("Polsen", new Student(6, "Sanne", "Polsen", 1992));
		studentliste.put("Håland", new Student(7,"Anne","Håland",1994));
		System.out.println("--------------------------------------");
		studentliste.skrivUtTre();
	}

}
