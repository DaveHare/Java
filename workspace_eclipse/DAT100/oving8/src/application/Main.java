package application;

import java.util.InputMismatchException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;


public class Main extends Application {
	public String beskjed=null;
	public static Label tilbakemelding;
	public static Label forsokLabel;

	@Override
	public void start(Stage primaryStage) {
		try {

			GridPane layout = new GridPane();
			Scene scene = new Scene(layout);

			//layout.setGridLinesVisible(true);

			ColumnConstraints venstreKant = new ColumnConstraints();
			ColumnConstraints hoyreKant = new ColumnConstraints();
			venstreKant.setPercentWidth(10);
			hoyreKant.setPercentWidth(20);
			ColumnConstraints column1 = new ColumnConstraints();
			column1.setPercentWidth(50);
			ColumnConstraints column2 = new ColumnConstraints();
			column2.setPercentWidth(20);
			layout.getColumnConstraints().addAll(venstreKant, column1, column2, hoyreKant);

			Label label= new Label("Gjett et tall fra 1 til 1000: ");
			label.setFont(new Font("Verdana", 20));

			Line linje= new Line(0 ,0,primaryStage.getWidth(),0);

			TextField tekstfelt= new TextField();		

			Button button = new Button("Enter");
			button.setFont(new Font("Verdana", 16));

			Line linje1= new Line();

			tilbakemelding= new Label(beskjed);
			tilbakemelding.setFont(new Font("Verdana", 12));
			
			forsokLabel= new Label();


			layout.add(label,1,0);
			layout.add(linje, 0, 1);
			layout.add(tekstfelt, 1, 2);
			layout.add(button,2,2);
			layout.add(linje1, 0, 2);
			layout.add(tilbakemelding,1,3);
			layout.add(forsokLabel, 3, 3);


			int tilfeldigTall= (int) Math.round(1000* Math.random());
			System.out.println(tilfeldigTall);
			KnappLytter lytteren = new KnappLytter(tilfeldigTall,tekstfelt);

			button.setOnAction(lytteren);
			tekstfelt.setOnAction(lytteren);

			layout.autosize();
			primaryStage.setTitle("Gjett tallet");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static int konventereTall(TextField tekstfelt){
		int tall=0;
		String beskjed=null;
		try{
			
			tall = Integer.parseInt(tekstfelt.getText());
			
			if(tall < 1 || tall > 1000){
				throw new NumberFormatException("Heltallet er utfor grensen. ");
			}
		}catch(NumberFormatException e1){
			beskjed="Må være et tall";	
		}catch (InputMismatchException e2){
			beskjed="Dette er ikke et tall. ";
			tall=-1;
		}
		setTilbakemelding(beskjed);
		return tall;
		


	}

	public static void setTilbakemelding(String beskjed){
		tilbakemelding.setText(beskjed);
	}
	public static void setTilbakemelding(String beskjed, int forsok){
		tilbakemelding.setText(beskjed);
		String antForsok="Antall Forsok: "+ forsok;
		forsokLabel.setText(antForsok);
	}


	public static void main(String[] args) {
		launch(args);
	}

}
