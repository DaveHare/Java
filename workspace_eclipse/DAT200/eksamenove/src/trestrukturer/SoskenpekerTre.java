package trestrukturer;

/*
 * En alternativ m�te � representere et generelt tre p�.
 * 
 * Sammenliknet med generelt tre:
 * - sparer plass
 * - mer komplisert � navigere
 * 
 */
public class SoskenpekerTre <T> {
	private T objekt;
	private SoskenpekerTre<T> venstreBarn;
	private SoskenpekerTre<T> hoyreSosken;
}
