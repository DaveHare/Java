package application;

import java.time.LocalDate;
import java.util.ArrayList;


import application.Hendelse;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class Main extends Application {

	public static ArrayList<Hendelse> hendelser= null;
	public static ListView<Hendelse> listView;
	public Person siri= new Person("Siri Mykland", 1996);
	public Person rosita= new Person("Rosita", 1990);
	public Person mats= new Person("Mats", 1995);
	public Person fedda= new Person("Fedda", 1994);
	public Person kjell= new Person("Kjell", 1800);
	public static ArrayList<Person> personliste=null ;
public static ObservableList<Hendelse> hendelseListe;

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			root.setPadding(new Insets(20,20,20,20));
			Scene scene = new Scene(root);

			primaryStage.setTitle("Hendelser");

			//Sette opp liste
		
			personliste= new ArrayList<Person>();
			hendelser= new ArrayList<Hendelse>();
		




			Label beskrivelse = new Label("Her er en liste over hendelser. \nTrykk på en hendelse for å se \nhvem som er invitert.");
			beskrivelse.autosize();
			beskrivelse.setPadding(new Insets(0,0,10,0));
			beskrivelse.setStyle("-fx-font: 18 auto;");
			root.add(beskrivelse, 0, 0);
			listView = new ListView<>();
			hendelseListe = FXCollections.observableList(hendelser);
			listView.setItems(hendelseListe);
			listView.setMaxHeight((hendelser.size()+1) *48);
			root.add(listView,0,1);


			AapneHendelse aapneHendelse= new AapneHendelse(listView, personliste);//lytter
			listView.setOnMouseClicked(aapneHendelse);


			HBox hbox = new HBox();
			hbox.setPadding(new Insets(20,20,0,20));
			hbox.setAlignment(Pos.BOTTOM_LEFT);
			Button nyHendelse = new Button("Ny Hendelse");
			Button nyPerson = new Button("Ny person");
			Button lagre = new Button("Lagre data");
			Button lesInn = new Button("Les inn data");

			HBox.setHgrow(nyHendelse, Priority.ALWAYS);
			HBox.setHgrow(nyPerson, Priority.ALWAYS);

			nyHendelse.setMaxWidth(Double.MAX_VALUE);
			nyPerson.setMaxWidth(Double.MAX_VALUE);

			hbox.getChildren().addAll(nyHendelse, nyPerson, lagre, lesInn);
			root.add(hbox,0,2);

			NyHendelse nyhendelse= new NyHendelse(listView);
			nyHendelse.setOnMouseClicked(nyhendelse);
			NyPerson leggtilperson= new NyPerson(personliste);
			nyPerson.setOnMouseClicked(leggtilperson);
			LagreData lagredata= new LagreData(personliste, hendelser);
			lagre.setOnMouseClicked(lagredata);
			LesData lesdata= new LesData();
			lesInn.setOnMouseClicked(lesdata);



			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	//	public Hendelse hendelse0=new Hendelse("Partey hos kell", LocalDate.now(),LocalDate.now());
	//	public Hendelse hendelse1=new Hendelse("Lan", LocalDate.now(),LocalDate.now());
	//	public Hendelse hendelse2=new Hendelse("Familiemiddag", LocalDate.now(),LocalDate.now());
	//	public Hendelse hendelse3=new Hendelse("Hyttetur", LocalDate.now(),LocalDate.now());
	//	public Hendelse hendelse4=new Hendelse("Theas bursdag", LocalDate.now(),LocalDate.now());
	//
	//	public void opprettHendelser() {
	//		hendelser= new ArrayList<Hendelse>();
	//		hendelser.add(hendelse0);
	//		hendelser.add(hendelse1);
	//		hendelser.add(hendelse2);
	//		hendelser.add(hendelse3);
	//		hendelser.add(hendelse4);
	//	}





	//		public void leggTilIListe(){
	//			personliste= new ArrayList<Person>();
	//			personliste.add(fedda);
	//			personliste.add(kjell);
	//			personliste.add(siri);
	//			personliste.add(mats);
	//			personliste.add(rosita);
	//			
	//			
	//			skrivTilFil(rosita);
	//			
	//		}
	public void setPersonliste(ArrayList<Person> personliste1){
	personliste=personliste1;
	}

	public static void setHendelser(ArrayList<Hendelse> hendelser2){
		hendelser= hendelser2;
		hendelseListe = FXCollections.observableList(hendelser);
		listView.setItems(hendelseListe);
	}
	public static void leggPersonTilIListe(Person nyperson1) {
		personliste.add(nyperson1);
	}

	//		public void leggTilFolkIHendelser(){
	//			hendelse0.leggTilPerson(siri, rosita, mats);
	//			hendelse1.leggTilPerson(mats, fedda, siri);
	//			hendelse2.leggTilPerson(fedda, kjell, rosita);
	//			hendelse3.leggTilPerson(mats, fedda, rosita, kjell);
	//			hendelse4.leggTilPerson(kjell, siri);
	//		}
	public static void leggTilHendelse(Hendelse hendelse) {
		hendelser.add(hendelse);
		listView.setItems(FXCollections.observableList(hendelser));
	}
	public static void oppdaterListe(Hendelse hendelsen, ArrayList<Person> nyGjesteListe){
		hendelsen.setNyInviterte(nyGjesteListe);
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static ArrayList<Person> getPersonliste() {
		return personliste;
	}

}

