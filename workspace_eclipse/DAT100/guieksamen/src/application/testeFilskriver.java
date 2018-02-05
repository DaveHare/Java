package application;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class testeFilskriver {

	public static void main(String[] args) throws EOFException, FileNotFoundException, IOException {
		Terningssett settet= new Terningssett(5,6);
		objektserialisering.skrivTilFil(settet);

	}

}
