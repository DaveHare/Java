package application;

import javafx.scene.Node;

abstract class LabyrintRute {
	public int korX;
	public int korY;
	
	public LabyrintRute(int korX, int korY) {
		this.korX=korX;
		this.korY=korY;
	}

	public int getKorX() {
		return korX;
	}

	public int getKorY() {
		return korY;
	}
	public abstract void flyttHit(Spiller spilleren);
	
	public abstract Node getRuteType();

}
