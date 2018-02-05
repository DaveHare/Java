package application;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PilLytter implements EventHandler<KeyEvent> {
	private Main main;
	public PilLytter(Main main) {
		this.main=main;
	}

	@Override
	public void handle(KeyEvent arg0) {
	
		KeyCode kode= arg0.getCode();
		
		if(kode==KeyCode.UP){
			main.FlyttSpiller(0,-1);
//			System.out.println("opp");
			
		}if(kode==KeyCode.DOWN){
			main.FlyttSpiller(0,1);
//			System.out.println("ned");
			
		}if(kode==KeyCode.LEFT){
			main.FlyttSpiller(-1,0);
//			System.out.println("venstre");
			
		}if(kode==KeyCode.RIGHT){
			main.FlyttSpiller(1,0);
//			System.out.println("høyre");
			
		}
		
	}

}
