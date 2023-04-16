package fp.titanic;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import common.AlturaPeso;
import utiles.Checkers;

public class FactoriaTitanic {
	/**
	 * Crea un pasajero a partir de todos los parametros necesarios.
	 */
	public static Pasajero creaPasajero(String name, String sex, Double ticketPrice, 
			Puerta portEmbarked, LocalDate dateOfBirth,
			String survived, String rich, String highestPriceBelongings, AlturaPeso alturaPeso){
		return new Pasajero(name, sex, ticketPrice, portEmbarked, dateOfBirth, survived, rich, highestPriceBelongings,alturaPeso);
}
	/**
	 * Recibe una linea del csv y devulve un tipo Pasajero, a partir de los parametros que se encuentran en esta.
	 */
	public static Pasajero parseaPasajero(String t){
		Checkers.checkNoNull(t);
		String [] trozos = t.split(",");
		Checkers.check("Formato no válido", trozos.length == 10);
		String name= trozos[0].trim();
		String sex = trozos[1].trim();                
		Double ticketPrice = Double.parseDouble(trozos[2].trim());
		Puerta portEmbarked = Puerta.valueOf(trozos[3].trim().toUpperCase());
		LocalDate dateOfBirth = LocalDate.parse(trozos[4].trim(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String survived = trozos[5].trim();
		String rich = trozos[6].trim();
		String highestPriceBelongings = trozos[7].trim();
		Double Peso = Double.parseDouble(trozos[8].trim());
		Integer Altura = Integer.parseInt(trozos[9].trim());
		return new Pasajero(name, sex, ticketPrice,portEmbarked, dateOfBirth,
				survived, rich, highestPriceBelongings, new AlturaPeso(Peso,Altura));
}
	/**
	 * Recibe una ruta de un archivo csv y devuelve una lista de tipo Pasajeros ,con todos los pasajeros que aparecen en el csv. 
	 */
	public static Pasajeros leerPasajeros(String registro) {
		Pasajeros res = null; 
		try {
		List<Pasajero> pasajeros =Files.lines(Paths.get(registro)).skip(1).map(FactoriaTitanic::parseaPasajero).collect(Collectors.toList());
			res = new PasajerosImpl(pasajeros);
			} catch(IOException e) {
			System.out.println("Fichero no encontrado: ");
			e.printStackTrace();
		}
		return res;
	}
}

	
	