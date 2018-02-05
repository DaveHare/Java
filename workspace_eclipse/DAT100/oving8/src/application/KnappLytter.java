package application;

import java.util.InputMismatchException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class KnappLytter implements EventHandler<ActionEvent> {

	private TextField tekstfelt;
	private int tilfeldigTall;
	private int tall=0;
	private int forsok=0;
	private String beskjed=null;


	public KnappLytter(int tilfeldigTall,TextField tekstfelt) {

		this.tekstfelt= tekstfelt;
		this.tilfeldigTall=tilfeldigTall;

	}

	@Override
	public void handle(ActionEvent arg0) {

		try{
			tall=Main.konventereTall(tekstfelt);
			if((tall<=1000)&&(tall>=1)){

				forsok++;
				System.out.println(tall);
				System.out.println(forsok);

				if (tall>tilfeldigTall){
					beskjed= "Tallet "+tall+" er større en tallet vårt";

				}
				if (tall<tilfeldigTall){
					beskjed= "Tallet "+tall+" er mindre en tallet vårt";
				}



				if (tall==tilfeldigTall){
					beskjed= "Du vant!";
					Alert seier= new Alert(AlertType.CONFIRMATION);
					seier.setTitle("Beskjed");
					seier.setHeaderText("Melding:");
					seier.setContentText("Du vant med "+forsok+" forsøk!");

					ImageView image = new ImageView("https://frostaporten.files.wordpress.com/2015/10/pokal.png");
					image.setFitHeight(10);
					image.setFitWidth(10);

					seier.setGraphic(image);
					seier.showAndWait();
				}
			}else if(tall==-1){
				throw new InputMismatchException();
			}else{
				throw new NumberFormatException();
			}
			Main.setTilbakemelding(beskjed, forsok);
		}catch(NumberFormatException e){
			Main.setTilbakemelding("Tallet er ugydig, skriv et heltall mellom 1 og 1000.");
			Alert feilmelding= new Alert(AlertType.WARNING);
			feilmelding.setTitle("Feilmelding");
			feilmelding.setHeaderText("Beskjed:");
			feilmelding.setContentText("Tallet er ugydig, skriv et heltall mellom 1 og 1000.");
			feilmelding.showAndWait();
		}catch(InputMismatchException e2){
			Alert feilmelding= new Alert(AlertType.WARNING);
			feilmelding.setTitle("Feilmelding");
			feilmelding.setHeaderText("Beskjed:");
			feilmelding.setContentText("Inputverdien er ikke et tall.");
			feilmelding.showAndWait();
		}


		tekstfelt.setText("");//clearer tekstfelt
	}
}
