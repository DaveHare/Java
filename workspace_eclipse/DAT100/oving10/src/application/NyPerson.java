package application;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NyPerson implements EventHandler<MouseEvent> {


	public ArrayList<Person> personliste;
	public NyPerson(ArrayList<Person> personliste) {
		this.personliste=personliste;
	}

	@Override
	public void handle(MouseEvent event) {
		try{
			GridPane root= new GridPane();
			root.setPadding(new Insets(20,20,20,20));
			Label navn= new Label ("Navn:");
			Label fodeaar= new Label ("Fødeår:");		 

			TextField navn1= new TextField();
			TextField fodeaar1= new TextField();		 

			Button leggTil= new Button("Legg til"); 

			root.add(navn,0,0);
			root.add(fodeaar, 0, 1);
			root.add(navn1,1,0);
			root.add(fodeaar1, 1, 1);
			root.add(leggTil, 1, 2);

			Stage stage = new Stage();
			stage.setTitle("Ny Hendelse");
			stage.setScene(new Scene(root));
			stage.show();

			LeggTilNyPerson leggTilPerson= new LeggTilNyPerson(navn1, fodeaar1,personliste,stage);
			leggTil.setOnMouseClicked(leggTilPerson);

		} catch(Exception e) {
			e.printStackTrace();
		}
		


	}

}
