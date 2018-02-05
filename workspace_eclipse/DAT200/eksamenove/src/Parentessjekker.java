package demoer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

import mine_lister.Stabel;

/*
 * Parentessjekker, slik den er i timene.
 * Denne versjonen har implementert noen men ikke
 * alle spesialtilfellene eller vekselvirkninger mellom
 * spesialtilfellene.
 * 
 * Kommentarer er for eksempel ikke tatt hensyn til.
 */
public class Parentessjekker {

	// Kommentar
	public static void main(String[] args) {
		Stabel<Character> parenteser = new Stabel<>();
		
		JFileChooser filVelger = new JFileChooser();
		File fila;
		
		String linja;
		char tegnet;
		
		char sisteParentes;
		
		int linjenr = 0;
		
		boolean erCharKonstant = false;
		boolean erStrengKonstant = false;
		
		int valg = filVelger.showOpenDialog(null);
		if (valg == JFileChooser.APPROVE_OPTION) {
			fila = filVelger.getSelectedFile();
			try (Scanner leser = new Scanner(fila)) {
				while (leser.hasNextLine()) {
					linja = leser.nextLine();
					linjenr++;
					for (int i = 0; i < linja.length(); i++) {
						tegnet = linja.charAt(i);
						
						// Spesialtilfelle: backslash
						if (tegnet == '\\') {
							i++;
							continue;
						}
						
						// Spesialtilfelle: char-konstant
						if (tegnet == '\'' && !erStrengKonstant) {
							erCharKonstant = !erCharKonstant;
						}
						if (erCharKonstant) continue;
						
						// Spesialtilfelle: strengkonstant
						if (tegnet == '"') {
							erStrengKonstant = !erStrengKonstant;
						}
						if (erStrengKonstant) continue;
						
						// Den generelle algoritmen:
						if (tegnet == '{') {
							parenteser.push('{');
						}
						if (tegnet == '(') {
							parenteser.push('(');
						}
						if (tegnet == '}') {
							sisteParentes = parenteser.pop();
							if (sisteParentes != '{') {
								System.out.println("Feil på linje: " + linjenr + " Forventet { men fant " + sisteParentes);
								return;
							}
						}
						if (tegnet == ')') {
							sisteParentes = parenteser.pop();
							if (sisteParentes != '(') {
								System.out
										.println("Feil på linje: " + linjenr + " Forventet ( men fant " + sisteParentes);
								return;
							}
						}

					} 
				}
				System.out.println( linjenr + " linjer sjekket. alt OK");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
