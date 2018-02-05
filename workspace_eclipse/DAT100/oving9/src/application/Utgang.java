package application;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Utgang extends LabyrintRute{
public Rectangle ruteType;
	public Utgang(int korX, int korY) {
		super(korX, korY);
		ruteType= new Rectangle( Main.getCellestorrelse(), Main.getCellestorrelse(), Color.GREEN);
	}
	
	@Override
	public void flyttHit(Spiller spilleren) {
		spilleren.setPosisjonX(getKorX());
		spilleren.setPosisjonY(getKorY());
		
		
		Alert ferdig = new Alert(AlertType.CONFIRMATION);
		ferdig.setTitle("Beskjed");
		ferdig.setHeaderText("Beskjed");
		ferdig.setContentText("Du har vunnet");
		ferdig.showAndWait();
		
		
//		try {
//			Thread.sleep(1500);
//		} catch (InterruptedException e) {}
		System.exit(0);
		
				
		
	}
	@Override
	public Node getRuteType() {
		return ruteType;
	}
	
	
}
