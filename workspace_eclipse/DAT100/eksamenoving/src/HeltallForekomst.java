
public class HeltallForekomst {

	public static void main(String[] args) {
		int[] tall= new int[]{4,2,4,2,2,7,6,5,6,10,9};

		forekomst(tall);
	}


	public static void forekomst(int[] heltall){
		for(int i = 1;i<11;i++){
			int ant =0;
			for(int j=0; j<heltall.length; j++){
				if(i==heltall[j]){
					ant++;
				}
			}
			System.out.println("Tallet "+ i+ " forekommer "+ant+" ganger.");
		}
	}


}
