package fp.titanic.test;

import fp.titanic.FactoriaTitanic;
import fp.titanic.Pasajeros;

public class TestFactoriaTitanic {

	public static void main(String[] args) {
		testLeerPasajeros("data/titanic.csv");
		//FactoriaTitanic.parseaPasajero("Tricia Panting,female,72.05,Q,30/11/1882,0,0,monocle/suit/clock,76.4,194");

	}
	private static void testLeerPasajeros(String registro) {
		System.out.println("\nTestLeerPartidas:");
		Pasajeros pasajeros = FactoriaTitanic.leerPasajeros(registro);
		System.out.println("   Pasajeros: "+ pasajeros);
}
	
}
