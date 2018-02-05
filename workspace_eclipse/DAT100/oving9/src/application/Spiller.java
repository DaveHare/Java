package application;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Spiller {

	public int posisjonX;
	public int posisjonY;
	public Circle ruteType;
	
	public Spiller(int posisjonX,int posisjonY) {
		this.posisjonX=posisjonX;
		this.posisjonY=posisjonY;
		
		ruteType = new Circle(Main.getCellestorrelse()/2, Color.YELLOW);
		//ImageView bildet=new ImageView("pokal.png");
		
	}
	
	public int getPosisjonX() {
		return posisjonX;
	}
	
	public void setPosisjonX(int posisjonX) {
		this.posisjonX = posisjonX;
		GridPane.setColumnIndex(ruteType, posisjonX);
	}
	
	public int getPosisjonY() {
		return posisjonY;
	}
	
	public void setPosisjonY(int posisjonY) {
		this.posisjonY = posisjonY;
		GridPane.setRowIndex(ruteType, posisjonY);
	}

	public Node getRuteType() {
		return ruteType;
	}

	
	

}
