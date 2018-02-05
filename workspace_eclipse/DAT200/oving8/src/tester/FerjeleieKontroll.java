package tester;

import java.util.LinkedList;
import java.util.Queue;
import prioritetskoer.MinHaug;

public class FerjeleieKontroll {
	
		// Enum for typer hendelser. Ett innslag for hver type hendelse som er i systemet
		public static enum Hendelsestype {KJORETOY_KOMMER, KJORETOY_FRAKTET};
		
		// Parametre for simuleringen. Man kan velge om disse skal v�re konstanter, slik som her,
		// eller om de skal overf�res som parametre til konstrukt�ren slik som antall
		// boder.
		public static final double SJANSE_GRUPPE_FORTSETTER = 0.7;
		public static final int MIN_TID_MELLOM_GRUPPER = 10;
		public static final int MAKS_TID_MELLOM_FERJE = 30;
		public static final int TID_BEHANDLING = 30;
		public static final int TID_PAUSE = 500;
		
		// Hendelsen i dette enkle eksemplet trenger bare � inneholde
		// tidspunkt og type. I mer kompliserte eksempler kan det v�re
		// mer data her.
		public class Hendelse {
			int tidspunkt;
			Hendelsestype type;
			
			public Hendelse(int tidspunkt, Hendelsestype type) {
				this.tidspunkt = tidspunkt;
				this.type = type;
			}
		}
		
		MinHaug<Hendelse> hendelseskoe;		// Prioritetsk� av hendelser
		Queue<Integer> personer;			// FIFO k� av personer
		
		/*
		 * Initialiserer simuleringen
		 */
		public FerjeleieKontroll() {
			hendelseskoe = new MinHaug<>();
			personer = new LinkedList<>();
			
			Hendelse hendelse1 = new Hendelse(0, Hendelsestype.KJORETOY_FRAKTET);
			hendelseskoe.insert(0, hendelse1);
			for (int i=0;i<antallBoder;i++) {
				hendelse1 = new Hendelse(10 + 10*i, Hendelsestype.KJORETOY_FRAKTET);
				hendelseskoe.insert(10, hendelse1);
			}
		}
		
		/*
		 * Behandler neste hendelse ved � ta den ut av k�en, oppdatere tida,
		 * og kaller en metode basert p� typen hendelse.
		 */
		public void behandleNesteHendelse() {
			int nvTid = 0;
			Hendelse nvHendelse = hendelseskoe.removeMin();
			nvTid = nvHendelse.tidspunkt;
			if (nvHendelse.type == Hendelsestype.KJORETOY_FRAKTET) {
				haandterPassasjerKommer(nvTid);
			}
			if (nvHendelse.type == Hendelsestype.KJORETOY_FRAKTET) {
				haandterPassasjerBehandlet(nvTid);
			}
		}
		
		/*
		 * H�ndterer en hendelse av typen Passasjer kommer
		 */
		private void haandterPassasjerKommer(int nvTid) {
			// Legger passasjeren i FIFO k�en
			personer.add(nvTid);
			
			// Passasjerer kommer ofte i grupper. Bruker tilfeldige tall for om neste
			// passasjer kommer sammen med n�v�rende eller ikke
			double gruppeFortsett = Math.random();
			int nyPersonTid;
			if (gruppeFortsett < SJANSE_GRUPPE_FORTSETTER) {
				nyPersonTid = nvTid + 2;
			} else {
				nyPersonTid = nvTid + MIN_TID_MELLOM_GRUPPER + 
						(int)(Math.random()*(MAKS_TID_MELLOM_GRUPPER - MIN_TID_MELLOM_GRUPPER));
			}
			
			// Lager hendelsen for at neste passasjer kommer og setter den inn i prioritetsk�en.
			Hendelse hendelsen = new Hendelse(nyPersonTid, Hendelsestype.KJORETOY_FRAKTET);
			hendelseskoe.insert(hendelsen.tidspunkt, hendelsen);
			
			// Skriver ut tidspunktet for at denne passasjeren kom.
			System.out.print(nvTid + "  ");
		}
		
		private void haandterPassasjerBehandlet(int nvTid) {
			System.out.println("\n Behandler neste passasjer. Tid = " + nvTid + " K�en er lengde: " + personer.size());;
			Integer nestePassasjer = personer.poll();
			Hendelse hendelsen;
			if (nestePassasjer == null) {
				hendelsen = new Hendelse(nvTid + TID_PAUSE, Hendelsestype.KJORETOY_FRAKTET);
			} else {
				hendelsen = new Hendelse(nvTid + TID_BEHANDLING, Hendelsestype.KJORETOY_FRAKTET);
			}
			hendelseskoe.insert(hendelsen.tidspunkt, hendelsen);
		}
		
		/*
		 * Kj�rer selve simuleringen
		 */
		public static void main(String[] args) {
			Sikkerhetskontroll2017 simulator = new Sikkerhetskontroll2017(2);
			while (true) {
				simulator.behandleNesteHendelse();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
			}
		}
	}
}
