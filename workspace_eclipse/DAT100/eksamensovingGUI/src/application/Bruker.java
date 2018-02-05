package application;

import java.time.LocalDate;

public class Bruker {
private String brukernavn;
private String epost;
private LocalDate opprettetDato;
public Bruker(String navn, String epost, LocalDate dato) {
brukernavn = navn;
this.epost = epost;
opprettetDato = dato;
}
public String getBrukernavn() {
return brukernavn;
}
public void setBrukernavn(String brukernavn) {
this.brukernavn = brukernavn;
}
public String getEpost() {
return epost;
}
public void setEpost(String epost) {
this.epost = epost;
}
public LocalDate getOpprettetDato() {
return opprettetDato;
}
public void setOpprettetDato(LocalDate opprettetDato) {
this.opprettetDato = opprettetDato;
}
}
