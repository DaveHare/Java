package hendelse;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import stud5.Person;

class HendelseTest {
	Hendelse h1;
	Hendelse kolliderer;
	Hendelse kollidererIkke;

	@BeforeEach
	void setUp() throws Exception {
		h1 = new Hendelse(LocalDate.of(2017, 12, 22), LocalDate.of(2018, 01, 03), "Jul");
		kolliderer = new Hendelse(LocalDate.of(2017, 12, 31), LocalDate.of(2018, 01, 01), "Nytt�r");
		kollidererIkke = new Hendelse(LocalDate.of(2018, 01, 04), LocalDate.of(2018, 01, 06), "Undervisningsstart");
	}

	@Test
	void testGetBeskrivelse() {
		assertEquals("Jul", h1.getBeskrivelse());
		assertEquals("Undervisningsstart", kollidererIkke.getBeskrivelse());
	}

	@Test
	void testSetBeskrivelse() {
		assertEquals("Jul", h1.getBeskrivelse());
		h1.setBeskrivelse("Jula 2017");
		assertEquals("Jula 2017", h1.getBeskrivelse());		
	}

	@Test
	void testGetStartDato() {
		assertEquals(LocalDate.of(2017, 12, 22), h1.getStartDato());
		assertEquals(LocalDate.of(2018, 01, 04), kollidererIkke.getStartDato());
	}

	@Test
	void testSetStartDato() {
		assertEquals(LocalDate.of(2017, 12, 22), h1.getStartDato());
		h1.setStartDato(LocalDate.of(2017, 12, 23));
		assertEquals(LocalDate.of(2017, 12, 23), h1.getStartDato());		
	}

	@Test
	void testGetSluttDato() {
		assertEquals(LocalDate.of(2018, 01, 03), h1.getSluttDato());
		assertEquals(LocalDate.of(2018, 01, 01), kolliderer.getSluttDato());
	}

	@Test
	void testSetSluttDato() {
		assertEquals(LocalDate.of(2018, 01, 03), h1.getSluttDato());
		h1.setSluttDato(LocalDate.of(2017, 12, 28));
		assertEquals(LocalDate.of(2017, 12, 28), h1.getSluttDato());
	}

	@Test
	void testKollidererHendelseHendelse() {
		assertTrue(Hendelse.kolliderer(h1, kolliderer));
		assertFalse(Hendelse.kolliderer(h1, kollidererIkke));
		Hendelse foer = new Hendelse(LocalDate.of(2017, 12, 8), LocalDate.of(2017, 12, 9), "Eksamen");
		assertFalse(Hendelse.kolliderer(h1, foer));
		Hendelse starterFoer = new Hendelse(LocalDate.of(2017, 12, 15), LocalDate.of(2017, 12, 26), "Test");
		assertTrue(Hendelse.kolliderer(h1, starterFoer));
		Hendelse slutterEtter = new Hendelse(LocalDate.of(2017, 12, 28), LocalDate.of(2018, 1, 26), "Test2");
		assertTrue(Hendelse.kolliderer(h1, slutterEtter));
		Hendelse grenseFoer = new Hendelse(LocalDate.of(2017, 12, 15), LocalDate.of(2017, 12, 22), "Test");
		assertFalse(Hendelse.kolliderer(h1, grenseFoer));
		grenseFoer.setSluttDato(grenseFoer.getSluttDato().plusDays(1));
		assertTrue(Hendelse.kolliderer(h1, grenseFoer));
		Hendelse grenseEtter = new Hendelse(LocalDate.of(2018, 1, 3), LocalDate.of(2018, 1, 26), "Test2");
		assertFalse(Hendelse.kolliderer(h1, grenseEtter));
		grenseEtter.setStartDato(grenseEtter.getStartDato().minusDays(1));
		assertTrue(Hendelse.kolliderer(h1, grenseEtter));
		
	}

	@Test
	void testKollidererHendelse() {
		assertTrue(h1.kolliderer(kolliderer));
		assertFalse(h1.kolliderer(kollidererIkke));
		Hendelse foer = new Hendelse(LocalDate.of(2017, 12, 8), LocalDate.of(2017, 12, 9), "Eksamen");
		assertFalse(h1.kolliderer(foer));
		Hendelse starterFoer = new Hendelse(LocalDate.of(2017, 12, 15), LocalDate.of(2017, 12, 26), "Test");
		assertTrue(h1.kolliderer(starterFoer));
		Hendelse slutterEtter = new Hendelse(LocalDate.of(2017, 12, 28), LocalDate.of(2018, 1, 26), "Test2");
		assertTrue(h1.kolliderer(slutterEtter));
		Hendelse grenseFoer = new Hendelse(LocalDate.of(2017, 12, 15), LocalDate.of(2017, 12, 22), "Test");
		assertFalse(h1.kolliderer(grenseFoer));
		grenseFoer.setSluttDato(grenseFoer.getSluttDato().plusDays(1));
		assertTrue(h1.kolliderer(grenseFoer));
		Hendelse grenseEtter = new Hendelse(LocalDate.of(2018, 1, 3), LocalDate.of(2018, 1, 26), "Test2");
		assertFalse(h1.kolliderer(grenseEtter));
		grenseEtter.setStartDato(grenseEtter.getStartDato().minusDays(1));
		assertTrue(h1.kolliderer(grenseEtter));
	}
	
//	void testLeggtilPerson() {
//		assertTrue(h1.leggTilPerson(new Person("fa","gi",1995)));
//	}

}
