package application;
import java.util.ArrayList;

import javafx.collections.FXCollections;

import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class FjernPerson implements EventHandler<MouseEvent> {
	public ListView<Person> listViewInv;
	public ListView<Person> listViewIkke;
	public ArrayList<Person> inviterte;
	public ArrayList<Person> ikkeInviterte;
	
	public FjernPerson(ListView<Person> listViewInv,ListView<Person> listViewIkke, ArrayList<Person> inviterte, ArrayList<Person> ikkeInviterte) {
		this.listViewInv= listViewInv;
		this.listViewIkke= listViewIkke;
		this.inviterte=inviterte;
		this.ikkeInviterte= ikkeInviterte;
	}

	@Override
	public void handle(MouseEvent arg0) {
		int idx= listViewInv.getSelectionModel().getSelectedIndex();
		Person valgtPerson= listViewInv.getItems().get(idx);
		inviterte.remove(valgtPerson);
		ikkeInviterte.add(valgtPerson);
		listViewInv.setItems(FXCollections.observableList(inviterte));
		listViewIkke.setItems(FXCollections.observableList(ikkeInviterte));
		AapneHendelse.setNyListe(inviterte);
		
	}

}

