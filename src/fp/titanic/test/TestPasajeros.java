package fp.titanic.test;
import fp.titanic.FactoriaTitanic;
import fp.titanic.Pasajeros;

public class TestPasajeros {

	public static void main(String[] args) {
		Pasajeros pasajeros = FactoriaTitanic.leerPasajeros("data/titanic.csv");
		testGetCosteTicketMedio(pasajeros);
		testGetExistePasajero(pasajeros,"Tricia Panting");
		testGetListaFiltradaSupervivientes(pasajeros,true);
		testGetDiccionarioSegunPuertaEmbarque(pasajeros);
		testGetCosteDelTicketSegunSituacionEconomica(pasajeros);
	}
	private static void testGetCosteTicketMedio(Pasajeros pasajeros) {
		try {
			String msg = String.format(
					"El coste medio del ticket es: "+ pasajeros.getCosteTicketMedio());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepci�n inesperada: " + e.getMessage());
		}		
	}
	private static void testGetExistePasajero(Pasajeros pasajeros,String name) {
		try {
			String msg = String.format(
					"¿Se encuentra el pasajero de nombre: " +name+  " ? "+ pasajeros.getEstaPasajero(name));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepci�n inesperada: " + e.getMessage());
		}		
	}
	private static void testGetListaFiltradaSupervivientes(Pasajeros pasajeros,Boolean f) {
		try {
			String msg = String.format(
					"La lista Filtrada segun si survived = "+f+" es: "+ pasajeros.getListaFiltradaSupervivientes(f));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepci�n inesperada: " + e.getMessage());
		}		
	
	}
	private static void testGetDiccionarioSegunPuertaEmbarque(Pasajeros pasajeros) {
		try {
			String msg = String.format(
					"El diccionario ordenado segun la puerta de embarque es: "+ pasajeros.getDiccionarioSegunPuertaEmbarque());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepci�n inesperada: " + e.getMessage());
		}		
	}
	private static void testGetCosteDelTicketSegunSituacionEconomica(Pasajeros pasajeros) {
		try {
			String msg = String.format(
					"El diccionario ordenado con el coste del tikcet segun si eran ricos o no es: "+ pasajeros.getCosteDelTicketSegunSituacionEconomica());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepci�n inesperada: " + e.getMessage());
		}		
	}
}
