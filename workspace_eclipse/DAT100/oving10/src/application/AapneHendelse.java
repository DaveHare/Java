package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class AapneHendelse implements EventHandler<MouseEvent> {
	private ListView<Hendelse> listView;
	private static ArrayList<Person> invitert= null;
	private ArrayList<Person> personliste;
	private static ObservableList<Person> gjesteListe= null;
	public static ListView<Person> listView2;
	public static Hendelse hendelsen;


	public AapneHendelse(ListView<Hendelse> listView, ArrayList<Person> personliste) {
		this.listView= listView;
		this.personliste= personliste;

	}

	@Override
	public void handle(MouseEvent event) {
		GridPane root = new GridPane();
		Stage stage = new Stage();
		root.setPadding(new Insets(20,20,20,20));


		int idx= listView.getSelectionModel().getSelectedIndex();
		hendelsen= listView.getItems().get(idx);
		System.out.println(hendelsen.toString());

		Label label = new Label("Inviterte til "+ hendelsen.getBeskrivelse()+":");
		label.setStyle("-fx-font: 18 auto;");

		invitert=hendelsen.getInviterte();
		System.out.println(invitert);

		listView2 = new ListView<>();

		System.out.println(FXCollections.observableList(invitert));
		gjesteListe = FXCollections.observableList(invitert);
//		}else{
//			gjesteListe=null;
//		}
		listView2.setItems(gjesteListe);
		listView2.setPlaceholder(new Label("Ingen er inviterte"));
		listView2.setMaxSize( 200, (invitert.size()+3) *24);

		HBox hbox = new HBox();
		hbox.setPadding(new Insets(20,20,20,20));
		hbox.setAlignment(Pos.BOTTOM_LEFT);

		Button inviter = new Button("Endre på gjestelisten");

		HBox.setHgrow(inviter, Priority.ALWAYS);

		inviter.setMaxWidth(Double.MAX_VALUE);
		hbox.getChildren().addAll(inviter);
		root.add(label,0,0);
		root.add(listView2,0,1);
		root.add(hbox, 0,2);

		stage.setTitle("Gjesteliste");
		stage.setScene(new Scene(root));
		stage.show();

		EndreInviterte inviterLytter= new EndreInviterte(listView,personliste);
		inviter.setOnMouseClicked(inviterLytter);

	}

	public static void setNyListe(ArrayList<Person> inviterte){
		invitert=inviterte;
		gjesteListe=FXCollections.observableList(inviterte);
		listView2.setItems(gjesteListe);
		hendelsen.setNyInviterte(invitert);
		Main.oppdaterListe(hendelsen, inviterte);
	}
}
