import java.util.ArrayList;

public class ArvingDemo {



	public static void main(String[] args) {

		ArrayList<Person> universitetsRegister; 
		universitetsRegister=new ArrayList<Person>();

		Rom rom1 = new Rom('K', 2, 12, 20);
		Rom rom2 = new Rom('A',3,06,22);
		Rom rom3 = new Rom('G', 1, 23, 11);

		Emne emne1 = new Emne("MAT100", "Matematiskemetoder 1", 'V');
		Emne emne2 = new Emne("MAT200", "Matematiskemetoder 2", 'H');
		Emne emne3 = new Emne("FYS100", "Fysikk", 'V');
		Emne emne4 = new Emne("SOS200", "Sosialfag", 'H');
		

		// Teknisk Ansatt
		TekniskAnsatt ansatt1=new TekniskAnsatt("Sondre", "Andreassen", 1986);
		ansatt1.setAarslonn(1000000);
		ansatt1.setStilling("Elektriker");
		ansatt1.leggTilRom(rom1,rom2);
		universitetsRegister.add(ansatt1);

		TekniskAnsatt ansatt2=new TekniskAnsatt("Siri", "Mykland", 1996);
		ansatt2.setAarslonn(340000);
		ansatt2.setStilling("Lab ansatt");
		ansatt2.leggTilRom(rom3);
		universitetsRegister.add(ansatt2);


		//Vitenkaplig Ansatt
		VitenskapligAnsatt ansatt3= new VitenskapligAnsatt("Simen","Daland", 1990);
		ansatt3.setAarslonn(1500000);
		ansatt3.setFagfelt("Mattematikk");
		ansatt3.leggTilEmne(emne1, emne2);
		ansatt3.setStilling("Proffessor i Mattematikk");
		universitetsRegister.add(ansatt3);

		VitenskapligAnsatt ansatt4= new VitenskapligAnsatt("Marcus","Moen", 1990);
		ansatt4.setAarslonn(2000000);
		ansatt4.setFagfelt("Mattematikk");
		ansatt4.leggTilEmne(emne3, emne2);
		ansatt4.setStilling("Proffessor i Mattematikk");
		universitetsRegister.add(ansatt4);

		
		// student
		Student student1= new Student("Silje","Rugsveen",1997);
		student1.setAarskurs(1);
		student1.setStudieretning("Ingeniørfag - Data");
		student1.setTarEmne(emne1, emne2, emne3);
		universitetsRegister.add(student1);

		Student student2= new Student("Anne","Håland",1994);
		student2.setAarskurs(3);
		student2.setStudieretning("Barnevern");
		student2.setTarEmne(emne4);
		universitetsRegister.add(student2);

		
		//studentassistent
		Studentassistent studass1= new Studentassistent("Hanne","Leifen", 1994);
		studass1.setStilling("Studentassistent");
		studass1.setTimelonn(154);
		studass1.setTimer(22);
		studass1.leggTilEmne(emne1, emne2);
		universitetsRegister.add(studass1);
		
		skriveUt(universitetsRegister);
	}

	public static void skriveUt(ArrayList<Person> liste){
		for(Person person:liste){
			System.out.println(person +"\n");
		}
	}


}
