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
		testGetCosteTicketMedioStream(pasajeros);
		testGetExistePasajeroStream(pasajeros,"Tricia Panting");
		testGetListaFiltradaSupervivientesStream(pasajeros,true);
		testGetEdadMaxima(pasajeros);
		testGetListaFiltradaSexoOrdenadaEdad(pasajeros,"female");
		testGetDiccionarioSegunPuertaEmbarqueStream(pasajeros);
		testGetDiccionarioTicketPriceSegunPuertaEmbarque(pasajeros);
		testGetDiccionarioEdadMinimaSegunGenero(pasajeros);
		testGetDiccionarioOrdenadoConLosNMayoresEdadesSegunSupervivencia(pasajeros,3);
		testGetPuertaEmbarqueConTicketMasCaro(pasajeros);
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
	private static void testGetCosteTicketMedioStream(Pasajeros pasajeros) {
		try {
			String msg = String.format(
					"El coste medio del ticket es: "+ pasajeros.getCosteTicketMedioStream());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepci�n inesperada: " + e.getMessage());
		}		
	}
	private static void testGetExistePasajeroStream(Pasajeros pasajeros,String name) {
		try {
			String msg = String.format(
					"¿Se encuentra el pasajero de nombre: " +name+  " ? "+ pasajeros.getEstaPasajeroStream(name));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepci�n inesperada: " + e.getMessage());
		}		
	}
	private static void testGetListaFiltradaSupervivientesStream(Pasajeros pasajeros,Boolean f) {
		try {
			String msg = String.format(
					"La lista Filtrada segun si survived = "+f+" es: "+ pasajeros.getListaFiltradaSupervivientesStream(f));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepci�n inesperada: " + e.getMessage());
		}		
	
	}
	private static void testGetEdadMaxima(Pasajeros pasajeros) {
		try {
			String msg = String.format(
					"La edad maxima en el naufragio: "+ pasajeros.getEdadMaxima());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepci�n inesperada: " + e.getMessage());
		}		
	
	}
	private static void testGetListaFiltradaSexoOrdenadaEdad(Pasajeros pasajeros, String sexo) {
		try {
			String msg = String.format(
					"La lista filtrada segun el sexo "+sexo+" y ordenada por edad es: "+ pasajeros.getListaFiltradaSexoOrdenadaEdad(sexo));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepci�n inesperada: " + e.getMessage());
		}		
	
	}
	private static void testGetDiccionarioSegunPuertaEmbarqueStream(Pasajeros pasajeros) {
		try {
			String msg = String.format(
					"El diccionario ordenado segun la puerta de embarque es: "+ pasajeros.getDiccionarioSegunPuertaEmbarqueStream());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepci�n inesperada: " + e.getMessage());
		}		
	}
	private static void testGetDiccionarioTicketPriceSegunPuertaEmbarque(Pasajeros pasajeros) {
		try {
			String msg = String.format(
					"El diccionario con los valores de los tickets segun la puerta de embarque es: "+ pasajeros.getDiccionarioTicketPriceSegunPuertaEmbarque());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepci�n inesperada: " + e.getMessage());
		}		
	}
	private static void testGetDiccionarioEdadMinimaSegunGenero(Pasajeros pasajeros) {
		try {
			String msg = String.format(
					"El diccionario con el valor de la edad minima segun el genero es: "+ pasajeros.getDiccionarioEdadMinimaSegunGenero());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepci�n inesperada: " + e.getMessage());
		}		
	}
	private static void testGetDiccionarioOrdenadoConLosNMayoresEdadesSegunSupervivencia(Pasajeros pasajeros,Integer n) {
		try {
			String msg = String.format(
					"El diccionario ordenado con los "+n+" personas con mayor edad en funcion de si han sobrevivido o no es: "+ pasajeros.getDiccionarioOrdenadoConLosNMayoresEdadesSegunSupervivencia(n));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepci�n inesperada: " + e.getMessage());
		}		
	}
	private static void testGetPuertaEmbarqueConTicketMasCaro(Pasajeros pasajeros) {
		try {
			String msg = String.format(
					"La puerta de Embarque con el Ticket mas caro es: "+ pasajeros.getPuertaEmbarqueConTicketMasCaro());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepci�n inesperada: " + e.getMessage());
		}		
	}
}
