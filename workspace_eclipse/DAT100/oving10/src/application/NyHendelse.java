package application;


import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NyHendelse implements EventHandler<MouseEvent> {
	public ListView<Hendelse> listView;


	public NyHendelse(ListView<Hendelse> listView) {
		this.listView=listView;
	}

	@Override
	public void handle(MouseEvent arg0) {
		try {
			GridPane root= new GridPane();
			root.setPadding(new Insets(20,20,20,20));
			Label beskrivelse= new Label ("Beskrivelse:");
			Label startdato= new Label ("Startdato:");		 
			Label sluttdato= new Label ("Sluttdato");
			TextField beskrivelse1= new TextField();
			TextField startdato1= new TextField();		 
			TextField sluttdato1= new TextField("2017-nov-03");
			Button leggTil= new Button("Legg til"); 

			root.add(beskrivelse,0,0);
			root.add(startdato, 0, 1);
			root.add(sluttdato, 0, 2);
			root.add(beskrivelse1,1,0);
			root.add(startdato1, 1, 1);
			root.add(sluttdato1, 1, 2);
			root.add(leggTil, 1, 3);

			CharSequence tekst= beskrivelse1.getCharacters();
			CharSequence startdato11=startdato1.getCharacters();
			CharSequence sluttdato11= sluttdato1.getCharacters();

			Stage stage = new Stage();
			stage.setTitle("Ny Hendelse");
			stage.setScene(new Scene(root));
			stage.show();


			LeggTilNyHendelse leggtilLytter= new LeggTilNyHendelse(tekst, startdato11, sluttdato11, stage);
			leggTil.setOnMouseClicked(leggtilLytter);
		} catch (Exception e) {
			// Invalid double String.
		}

		//		Main.LeggTilHendelse();




	}

}
