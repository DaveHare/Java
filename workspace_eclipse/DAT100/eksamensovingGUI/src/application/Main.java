package application;
	
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	public static ArrayList<Bruker> brukere;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			GridPane root= new GridPane();
			Scene scene = new Scene(root);
			
			Label brukernavn= new Label("Brukernavn");
			Label epost= new Label("Epost");
			Label opprettet= new Label("Opprettet Dato:");
			
			TextField brukernavn1= new TextField();
			TextField epost1= new TextField();
			LocalDate newDate=LocalDate.now();
			
			TextField opprettet1= new TextField(newDate.getYear()+"-"+ newDate.getMonth()+"-"+ newDate.getDayOfMonth());
			Button ok=new Button("OK");
			Button clear = new Button("Clear");
			 root.add(brukernavn, 0,1);
			 root.add(epost, 0,2);
			 root.add(opprettet, 0,3);
			 root.add(ok, 0, 4);
			 root.add(brukernavn1, 1,1);
			 root.add(epost1, 1,2);
			 root.add(opprettet1, 1,3);
			 root.add(clear, 1, 4);
			 root.setPadding(new Insets(10,10,10,10));
			 //OKLytter OK= new OKLytter(brukernavn1, epost1, newDate);
			 // lambda notasjon
			 ok.setOnMouseClicked(e -> leggTilBruker( new Bruker(brukernavn1.getText(),epost1.getText(), newDate)));
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void leggTilBruker(Bruker brukeren){
		brukere= new ArrayList<Bruker>();
		brukere.add(brukeren);
		System.out.println(brukeren.getBrukernavn());
	}
}
