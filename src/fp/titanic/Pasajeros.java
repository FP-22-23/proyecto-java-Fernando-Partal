package fp.titanic;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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
}

