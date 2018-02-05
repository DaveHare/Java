package application;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EndreInviterte implements EventHandler<MouseEvent> {
	public ListView<Hendelse> listView;
	public ListView<Person> listView1;
	public ListView<Person> listView2;
	public ArrayList<Person> inviterte=null;
	public ArrayList<Person> personliste;
	public ArrayList<Person> ikkeInviterte=null;
	public Hendelse hendelsen;
	public EndreInviterte(ListView<Hendelse> listView, ArrayList<Person> personliste) {
		this.listView=listView;
		this.personliste= personliste;
	}

	@Override
	public void handle(MouseEvent arg0) {



		int idx= listView.getSelectionModel().getSelectedIndex();
		hendelsen= listView.getItems().get(idx);

		inviterte= new ArrayList<Person>(hendelsen.getInviterte());
		System.out.println(inviterte.toString());

		// lager listen med folk som ikke er inviterte
		Collection<Person> similar = new HashSet<Person>(personliste);
		Collection<Person> different = new HashSet<Person>();
		different.addAll( personliste );
		different.addAll( inviterte );
		similar.removeAll( inviterte );
		different.retainAll( similar );
		System.out.println( similar.toString());
		ikkeInviterte= new ArrayList<Person>(similar);


		GridPane root= new GridPane();
		root.setPadding(new Insets(20,20,30,20));
		Stage stage= new Stage();
		HBox hbox= new HBox();
		hbox.setPadding(new Insets(0, 0, 10,0));
		Label label = new Label("Merk personen og bruk knappene til å invitere.");
		label.setStyle("-fx-font: 18 auto;");

		hbox.getChildren().add(label);
		VBox vbox= new VBox(); 
		vbox.setPadding(new Insets(50, 10,0,10));
		Button leggtil= new Button("\u2190");
		leggtil.setStyle("-fx-font: 16 auto;");
		Button fjern= new Button("\u2192");
		fjern.setStyle("-fx-font: 16 auto;");
		vbox.getChildren().addAll(leggtil, fjern);
		listView1= new ListView<>();
		listView2= new ListView<>();

		ObservableList<Person> invitertListe = FXCollections.observableList(inviterte);
		ObservableList<Person> ikkeInvitertListe = FXCollections.observableList(ikkeInviterte);
		listView1.setItems(invitertListe);
		listView2.setItems(ikkeInvitertListe);

		root.add(hbox,1,0,3,1);
		root.add(listView1,1,1);
		root.add(vbox,2,1);
		root.add(listView2,3,1);
		
		listView1.setPlaceholder(new Label("Ingen er inviterte"));
		listView1.setMaxHeight(150);
		listView1.setMaxSize(170, 150);
		listView2.setPlaceholder(new Label("Alle er inviterte"));
		listView2.setMaxSize( 170, 150);

		
		stage.setTitle("Inviter personer");
		stage.setScene(new Scene(root));
		stage.show();


		AddPerson addP= new AddPerson(listView1,listView2,inviterte, ikkeInviterte);
		leggtil.setOnMouseClicked(addP);
		FjernPerson fjernP= new FjernPerson(listView1,listView2,inviterte, ikkeInviterte);
		fjern.setOnMouseClicked(fjernP);

	}



}
