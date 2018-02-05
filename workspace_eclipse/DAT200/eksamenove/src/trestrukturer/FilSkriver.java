package trestrukturer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * Eksempler p� preorder og postorder traversering
 * av en trestruktur: Katalogstrukturen p� en PC
 */
public class FilSkriver {
	
	/*
	 * Preorder traversering: Tar noden (katalogen)
	 * selv f�rst og deretter barna.
	 */
	public static void skrivKatalog(File katalogen, int nivaa) {
		// H�ndterer noden selv
		for (int i=0;i<nivaa;i++) {
			System.out.print(" - ");
		}
		System.out.println(katalogen.getName());
		
		// H�ndterer barna
		if (katalogen.isDirectory()) {
			File[] filene = katalogen.listFiles();
			for (File fila: filene) {
				skrivKatalog(fila, nivaa+1);
			}
		}
	}
	
	/*
	 * Eksempel p� postorder traversering. Tar barna
	 * f�rst og deretter noden selv. Denne regner
	 * ut total plassbruk for alle filene
	 * i en katalog, inkludert underkataloger.
	 */
	public static long totalPlassbruk(File katalogen, int nivaa) {
		// H�ndterer barna
		long plassbruk = 0;
		if (katalogen.isDirectory()) {
			File[] filene = katalogen.listFiles();
			for (File fila: filene) {
				plassbruk += totalPlassbruk(fila, nivaa+1);
			}
		}
		
		// H�ndterer noden selv
		Path filepath = katalogen.toPath();
		try {
			plassbruk += Files.size(filepath);
		} catch (IOException e) {
			System.out.println("Problem med � finne st�rrelsen p� fila!");
			e.printStackTrace();
		}
		if (nivaa < 3) {
			for (int i=0;i<nivaa;i++) {
				System.out.print("- ");
			}
			System.out.println(katalogen.getName() + ": " + plassbruk + " bytes");
		}
		return plassbruk;
	}

	/*
	 * Main program som bruker de to metodene.
	 * 
	 */
	public static void main(String[] args) {
		File rot;
		Scanner inn = new Scanner(System.in);
		System.out.print("Katalog: ");
		String filnavn = inn.nextLine();
		rot = new File(filnavn);
		skrivKatalog(rot, 0);
		totalPlassbruk(rot, 0);
	}

}
