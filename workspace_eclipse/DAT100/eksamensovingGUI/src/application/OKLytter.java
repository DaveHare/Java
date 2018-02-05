package application;

import java.time.LocalDate;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class OKLytter implements EventHandler<MouseEvent> {
private String brukernavn;
private String epost;
private LocalDate opprettet;
	public OKLytter(TextField brukernavn, TextField epost, LocalDate opprettet){
	this.brukernavn=brukernavn.getText();
	this.epost=epost.getText();
	this.opprettet=opprettet;
	}
	@Override
	public void handle(MouseEvent arg0) {
		
		Main.leggTilBruker(new Bruker(brukernavn, epost, opprettet));
		
	}

}
