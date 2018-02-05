package application;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Vegg extends LabyrintRute{
private Rectangle ruteType;

	public Vegg(int korX, int korY) {
		super(korX, korY);	
		ruteType= new Rectangle(Main.getCellestorrelse(), Main.getCellestorrelse(), Color.BURLYWOOD);
		ruteType.setStroke(Color.BURLYWOOD);
	}

	@Override
	public void flyttHit(Spiller spilleren) {
			
	}
	@Override
	public Node getRuteType() {
		return ruteType;
	}



}
