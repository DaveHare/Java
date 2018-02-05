package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LeggTilNyHendelse implements EventHandler<MouseEvent> {
	public CharSequence beskrivelse1;
	private CharSequence startdato1;
	private CharSequence sluttdato1;
	private Stage stage;

	public LeggTilNyHendelse(CharSequence tekst, CharSequence startdato12, CharSequence sluttdato12,Stage stage) {
		this.beskrivelse1=tekst;
		this.startdato1= startdato12;
		this.sluttdato1= sluttdato12;
		this.stage= stage;
	}


	@Override
	public void handle(MouseEvent event) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
		//formatter.withLocale( Locale.GERMANY);
		System.out.println(LocalDate.parse(startdato1, formatter).toString());
		try{
		LocalDate startdato = LocalDate.parse(startdato1, formatter);
		LocalDate sluttdato=LocalDate.parse(sluttdato1, formatter);
		Hendelse hendelse = new Hendelse(beskrivelse1, startdato, sluttdato);
		Main.leggTilHendelse(hendelse);
		stage.close();
		}catch(NumberFormatException e){
			
		}
	
	}

}
