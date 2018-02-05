package application;
import java.util.ArrayList;

import javafx.collections.FXCollections;

import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class AddPerson implements EventHandler<MouseEvent> {
	public ListView<Person> listViewInv;
	public ListView<Person> listViewIkke;
	public ArrayList<Person> inviterte;
	public ArrayList<Person> ikkeInviterte;
	//	public Hendelse hendelsen;
	public AddPerson(ListView<Person> listViewInv,ListView<Person> listViewIkke, ArrayList<Person> inviterte, ArrayList<Person> ikkeInviterte) {
		this.listViewInv= listViewInv;
		this.listViewIkke= listViewIkke;
		this.inviterte=inviterte;
		this.ikkeInviterte= ikkeInviterte;
		//		this.hendelsen= hendelsen;
	}

	@Override
	public void handle(MouseEvent arg0) {
		int idx= listViewIkke.getSelectionModel().getSelectedIndex();
		Person valgtPerson= listViewIkke.getItems().get(idx);
		inviterte.add(valgtPerson);
		ikkeInviterte.remove(valgtPerson);
		listViewInv.setItems(FXCollections.observableList(inviterte));
		listViewIkke.setItems(FXCollections.observableList(ikkeInviterte));
		//oppdaterer gjestelista i vindu nr 2
		AapneHendelse.setNyListe(inviterte);
		System.out.println(listViewInv.hasProperties()==false);

		
	}

}
