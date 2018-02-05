package application;


import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LeggTilNyPerson implements EventHandler<MouseEvent> {
	public CharSequence navn;
	public TextField fodeaar1;
	public int fodeaar;
	private TextField navn1;
	//private GridPane root;
	private Stage stage;



	public LeggTilNyPerson(TextField navn1, 
			TextField fodeaar1, ArrayList<Person> personliste, Stage stage){//GridPane root) {
		this.navn1= navn1;
		this.fodeaar1= fodeaar1;
		//this.root= root;
		this.stage= stage;
	}

	@Override
	public void handle(MouseEvent event) {
		navn=navn1.getCharacters();
		try{
			fodeaar=Integer.parseInt(fodeaar1.getCharacters().toString());
			Person nyperson = new Person(navn, fodeaar);	
			Main.leggPersonTilIListe(nyperson);
			stage.close();

		}catch(NumberFormatException e){
			System.out.println("feil ved parsing");	
		}




	}


}
