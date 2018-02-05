package terning;

public class ProsentTerning2 extends Terning{
	public ProsentTerning2(int sider){
		super(100);		
	}
	
	public int getEnere(){
		return getVerdi() % 10;
	}
	public int getTiere(){
		return (int)(getVerdi()/10);
	}
	
	public int flipp(){
		return 10*getEnere()+getTiere();
		
	}
	
	
}
