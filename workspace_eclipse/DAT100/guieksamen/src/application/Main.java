package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	private Label[] terninger;
	private CheckBox[] laaser;
	private Button kast;
	private Label korrekte;
	private Label verdiforskjell;
	private Label omgangLabel;
	private Terningssett mine;
	private Terningssett spillerens;
	private int omgang;
	private int antKorrekte;
	private int verdiForskjell;

	@Override
	public void start(Stage primaryStage) {
		try {
			mine = new Terningssett(5, 6);
			spillerens = new Terningssett(5, 6);
			System.out.println(mine.getTerningverdi(0)+","+mine.getTerningverdi(1)+","+mine.getTerningverdi(2)+","+mine.getTerningverdi(3)+","+mine.getTerningverdi(4));
			omgang = 1;
			antKorrekte=Terningssett.antallLike(mine, spillerens);
			VBox vbox=new VBox();
			GridPane ovre= new GridPane();
			GridPane nedre=new GridPane();

			terninger=new Label[5];
			laaser=new CheckBox[5];
			vbox.setPadding(new Insets(10,10,10,10));
			korrekte= new Label("Korrekte: "+ antKorrekte);
			verdiforskjell= new Label("Verdiforskjell: "+ verdiForskjell);
			omgangLabel= new Label("Omgang:"+ omgang);
			kast= new Button("Kast");




			for(int i =0; i<mine.getAntallTerninger();i++){
				final int hvilken = i;
				terninger[i]=new Label(""+spillerens.getTerningverdi(i));
				laaser[i]=new CheckBox();

				ovre.add(terninger[i], i, 0);
				ovre.add(laaser[i], i, 1);


				laaser[i].setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent event) {
						spillerens.flippLaas(hvilken);
					}
				});

				kast.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event){
						kastTerning();

					}
				});
			}
			ovre.add(new Label("Terninger"), 5, 0);
			ovre.add(new Label("Låser"), 5, 1);

			nedre.add(korrekte, 0, 0);
			nedre.add(verdiforskjell, 0, 1);
			nedre.add(omgangLabel, 0, 2);
			nedre.add(kast, 0, 3);


			Terningssett settet= new Terningssett(5,6);
			objektserialisering.skrivTilFil(settet, primaryStage);

			vbox.getChildren().add(ovre);
			vbox.getChildren().add(nedre);
			Scene scene = new Scene(vbox);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void kastTerning(){
		spillerens.kast();
		for(int i=0;i <spillerens.getAntallTerninger();i++){
			terninger[i].setText(""+ spillerens.getTerningverdi(i));
		}
		verdiForskjell= spillerens.sum()-mine.sum();
		verdiforskjell.setText("Verdiforskjell: "+ verdiForskjell);

		antKorrekte= Terningssett.antallLike(mine, spillerens);
		korrekte.setText("Korrekte: "+antKorrekte);
		
		omgangLabel.setText("Omgang: "+(omgang++));

		if(Terningssett.antallLike(mine, spillerens)==5){
			Alert melding= new Alert(AlertType.INFORMATION,"Du har vunnet! Du brukte "+omgang+" omganger!");
			melding.showAndWait();
		}
		
	}


	public static void main(String[] args) {
		launch(args);
	}

}
