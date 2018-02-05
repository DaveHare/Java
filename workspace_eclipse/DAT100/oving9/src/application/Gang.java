package application;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Gang extends LabyrintRute{
public Rectangle ruteType;

	public Gang(int korX, int korY) {
		super(korX, korY);
		ruteType= new Rectangle( Main.getCellestorrelse(), Main.getCellestorrelse(), Color.BLACK);
		ruteType.setStroke(Color.BLACK);
	}
	
	@Override
	public void flyttHit(Spiller spilleren) {
		spilleren.setPosisjonX(getKorX());
		spilleren.setPosisjonY(getKorY());		
	}

	@Override
	public Node getRuteType() {
		return ruteType;
	}

	
	

}
