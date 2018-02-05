package tester;

import java.util.LinkedList;
import java.util.Queue;

import prioritetskoer.MinHaug;

public class Sikkerhetskontroll2017 {
	// Enum for typer hendelser. Ett innslag for hver type hendelse som er i systemet
	public static enum Hendelsestype {PASSASJER_KOMMER, PASSASJER_BEHANDLET};
	
	// Parametre for simuleringen. Man kan velge om disse skal være konstanter, slik som her,
	// eller om de skal overføres som parametre til konstruktøren slik som antall
	// boder.
	public static final double SJANSE_GRUPPE_FORTSETTER = 0.7;
	public static final int MIN_TID_MELLOM_GRUPPER = 10;
	public static final int MAKS_TID_MELLOM_GRUPPER = 120;
	public static final int TID_BEHANDLING = 30;
	public static final int TID_PAUSE = 500;
	
	// Hendelsen i dette enkle eksemplet trenger bare å inneholde
	// tidspunkt og type. I mer kompliserte eksempler kan det være
	// mer data her.
	public class Hendelse {
		int tidspunkt;
		Hendelsestype type;
		
		public Hendelse(int tidspunkt, Hendelsestype type) {
			this.tidspunkt = tidspunkt;
			this.type = type;
		}
	}
	
	MinHaug<Hendelse> hendelseskoe;		// Prioritetskø av hendelser
	Queue<Integer> personer;			// FIFO kø av personer
	
	/*
	 * Initialiserer simuleringen
	 */
	public Sikkerhetskontroll2017(int antallBoder) {
		hendelseskoe = new MinHaug<>();
		personer = new LinkedList<>();
		
		Hendelse hendelse1 = new Hendelse(0, Hendelsestype.PASSASJER_KOMMER);
		hendelseskoe.insert(0, hendelse1);
		for (int i=0;i<antallBoder;i++) {
			hendelse1 = new Hendelse(10 + 10*i, Hendelsestype.PASSASJER_BEHANDLET);
			hendelseskoe.insert(10, hendelse1);
		}
	}
	
	/*
	 * Behandler neste hendelse ved å ta den ut av køen, oppdatere tida,
	 * og kaller en metode basert på typen hendelse.
	 */
	public void behandleNesteHendelse() {
		int nvTid = 0;
		Hendelse nvHendelse = hendelseskoe.removeMin();
		nvTid = nvHendelse.tidspunkt;
		if (nvHendelse.type == Hendelsestype.PASSASJER_KOMMER) {
			haandterPassasjerKommer(nvTid);
		}
		if (nvHendelse.type == Hendelsestype.PASSASJER_BEHANDLET) {
			haandterPassasjerBehandlet(nvTid);
		}
	}
	
	/*
	 * Håndterer en hendelse av typen Passasjer kommer
	 */
	private void haandterPassasjerKommer(int nvTid) {
		// Legger passasjeren i FIFO køen
		personer.add(nvTid);
		
		// Passasjerer kommer ofte i grupper. Bruker tilfeldige tall for om neste
		// passasjer kommer sammen med nåværende eller ikke
		double gruppeFortsett = Math.random();
		int nyPersonTid;
		if (gruppeFortsett < SJANSE_GRUPPE_FORTSETTER) {
			nyPersonTid = nvTid + 2;
		} else {
			nyPersonTid = nvTid + MIN_TID_MELLOM_GRUPPER + 
					(int)(Math.random()*(MAKS_TID_MELLOM_GRUPPER - MIN_TID_MELLOM_GRUPPER));
		}
		
		// Lager hendelsen for at neste passasjer kommer og setter den inn i prioritetskøen.
		Hendelse hendelsen = new Hendelse(nyPersonTid, Hendelsestype.PASSASJER_KOMMER);
		hendelseskoe.insert(hendelsen.tidspunkt, hendelsen);
		
		// Skriver ut tidspunktet for at denne passasjeren kom.
		System.out.print(nvTid + "  ");
	}
	
	private void haandterPassasjerBehandlet(int nvTid) {
		System.out.println("\n Behandler neste passasjer. Tid = " + nvTid + " Køen er lengde: " + personer.size());;
		Integer nestePassasjer = personer.poll();
		Hendelse hendelsen;
		if (nestePassasjer == null) {
			hendelsen = new Hendelse(nvTid + TID_PAUSE, Hendelsestype.PASSASJER_BEHANDLET);
		} else {
			hendelsen = new Hendelse(nvTid + TID_BEHANDLING, Hendelsestype.PASSASJER_BEHANDLET);
		}
		hendelseskoe.insert(hendelsen.tidspunkt, hendelsen);
	}
	
	/*
	 * Kjører selve simuleringen
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
