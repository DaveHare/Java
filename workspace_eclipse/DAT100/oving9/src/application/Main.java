package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class Main extends Application {
	
	public String[][] labyrint;
	private LabyrintRute[][] labyrinten;
	public int lengde;
	public int bredde;
	public Spiller spilleren;
	public static double cellestorrelse;

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();

			lesLabyrint();
			//root.setGridLinesVisible(true);

			for(int x=0; x<bredde; x++){
				for(int y=0; y< lengde; y++){
					root.add(labyrinten[x][y].getRuteType(),x,y);
				}					
			}
			
			root.setStyle("-fx-background-color: #000000;");//setter bakgrunn

			root.add(spilleren.getRuteType(),spilleren.getPosisjonX(), spilleren.getPosisjonY());

			Scene scene = new Scene(root);
			scene.setOnKeyPressed(new PilLytter(this));
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void settOppCellestorrelse() {
		Screen skjermen = Screen.getPrimary();
		Rectangle2D skjermrektangel = skjermen.getBounds();
		double skjermbredde = skjermrektangel.getWidth();
		double skjermhoyde = skjermrektangel.getHeight();
		cellestorrelse = (Math.min(skjermhoyde, skjermbredde)*3)/4.0;
		cellestorrelse /= Math.max(bredde, lengde);
	}

	public void FlyttSpiller(int deltaX , int deltaY){
		
		int nyX=spilleren.getPosisjonX()+deltaX;
		int nyY=spilleren.getPosisjonY()+deltaY;
		labyrinten[nyX][nyY].flyttHit(spilleren);
	}

	public static double getCellestorrelse() {
		return cellestorrelse;
	}

	public void lesLabyrint(){
		int rad = 0;
		int kolonne = 0;
		String linje = null;
		char tegn;

//		File labyrintFil= new File("C:\\Users\\sirim\\workspace\\DAT100\\oving9\\src\\application\\testlabyrint_fra_oppgaveteksten.txt");
		File labyrintFil= new File("C:\\Users\\sirim\\workspace\\DAT100\\oving9\\src\\application\\testlabyrint_storre.txt");
		try(Scanner les= new Scanner(new FileReader(labyrintFil))){		

			bredde=les.nextInt();
			lengde=les.nextInt();

			settOppCellestorrelse();

			les.nextLine();
			labyrinten = new LabyrintRute[bredde][lengde];
			while (les.hasNext()) {
				linje = les.nextLine();
				for (kolonne = 0;kolonne < bredde;kolonne++) {
					tegn = linje.charAt(kolonne);
					switch(tegn){			
					case' ':
						labyrinten[kolonne][rad]= new Gang(kolonne,rad);
						break;
					case'-':
						labyrinten[kolonne][rad]= new Utgang(kolonne,rad);
						break;
					case '#':
						labyrinten[kolonne][rad]= new Vegg(kolonne,rad);
						break;
					case '*':
						labyrinten[kolonne][rad]= new Gang(kolonne,rad);
						spilleren= new Spiller(kolonne,rad);
						spilleren.posisjonX=kolonne;
						spilleren.posisjonY=rad;
						break;
					}

				}
				rad++;

			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(NumberFormatException e){
			e.printStackTrace();
		}

	}
}