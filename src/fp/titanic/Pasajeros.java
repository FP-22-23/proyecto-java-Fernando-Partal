package fp.titanic;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public interface Pasajeros {
	void agregarPasajero(Pasajero t);
	Integer getNumeroPasajeros();
	void eliminarPasajero(Pasajero t);
	void agregarPasajeros(Collection<Pasajero> t);
	Double getCosteTicketMedio();
	Boolean getEstaPasajero(String name);
	List<Pasajero> getListaFiltradaSupervivientes(Boolean s);
	Map<Puerta,List<Pasajero>> getDiccionarioSegunPuertaEmbarque();
	Map<Boolean,Double> getCosteDelTicketSegunSituacionEconomica();
	Double getCosteTicketMedioStream();
	Boolean getEstaPasajeroStream(String name);
	List<Pasajero> getListaFiltradaSupervivientesStream(Boolean s);
	Integer getEdadMaxima();
	List<Pasajero> getListaFiltradaSexoOrdenadaEdad(String sexo);
	Map<Puerta,List<Pasajero>> getDiccionarioSegunPuertaEmbarqueStream();
	Map<Puerta,List<Double>> getDiccionarioTicketPriceSegunPuertaEmbarque();
	Map<String, Integer> getDiccionarioEdadMinimaSegunGenero();
	SortedMap<Boolean, List<String>> getDiccionarioOrdenadoConLosNMayoresEdadesSegunSupervivencia(Integer n);
	Puerta getPuertaEmbarqueConTicketMasCaro();
}

