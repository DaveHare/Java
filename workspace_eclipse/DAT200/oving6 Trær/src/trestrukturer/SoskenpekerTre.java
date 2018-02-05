package trestrukturer;

/*
 * En alternativ måte å representere et generelt tre på.
 * 
 * Sammenliknet med generelt tre:
 * - sparer plass
 * - mer komplisert å navigere
 * 
 */
public class SoskenpekerTre <T> {
	private T objekt;
	private SoskenpekerTre<T> venstreBarn;
	private SoskenpekerTre<T> hoyreSosken;
}
