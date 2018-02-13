package person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import stud5.Person;

class PersonTest {
	Person testPerson1,testPerson2;
	@Test
	void test() {
		fail("Not yet implemented");
		
		assertEquals(true,testPerson1);
		assertEquals(true,testPerson2);
	}
	@BeforeEach
	void setUp() throws Exception{
		testPerson1= new Person("Siri", "Mykland", 1992);
		testPerson2= new Person("Frida", "Erdal", 1994);
	}
	

}
