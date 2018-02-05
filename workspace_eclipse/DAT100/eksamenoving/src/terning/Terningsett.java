package terning;


public class Terningsett{
	private Terning[] terningene;
	private boolean[] laast;
	public Terningsett(int antTerninger, int sider){
		terningene=new Terning[antTerninger];
		laast= new boolean[antTerninger];
		for(int i=0;i<terningene.length;i++ ){
			terningene[i]= new Terning(sider);
			laast[i]= false;
		}
	}
	
		public void omkast(){
			for(int i =0; i<terningene.length;i++){
				if(laast[i]=false){
					terningene[i].kast();
				}
			}
		}
		
		public static int sammenligneSett(Terningsett s1, Terningsett s2){
			int likePlasser=0;
			int lengde= s1.terningene.length;
			if(s2.terningene.length<lengde)lengde= s2.terningene.length;
			for(int i =0; i <lengde; i++){
				if(s1.terningene[1].getVerdi()==s2.terningene[i].getVerdi()){
					likePlasser++;
				}
			}
			return likePlasser;
		}
		
	
	

}
