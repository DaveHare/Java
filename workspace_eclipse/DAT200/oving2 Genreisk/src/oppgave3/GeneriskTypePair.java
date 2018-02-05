package oppgave3;

public class GeneriskTypePair {
	
	
	public static void main(String[] args){
		
		Pair<String> par1= new Pair<String>("hei", "hade");
		System.out.println(par1.getT1()+", "+ par1.getT2());
		par1.setT1("hallaisen");
		System.out.println(par1.getT1());

		
		Pair<Integer> par2= new Pair<Integer>(23 , 43);
		System.out.println(par2.getT1()+" , " + par2.getT2());
		par2.setT1(13);
		System.out.println(par2.getT1());
	}

}
