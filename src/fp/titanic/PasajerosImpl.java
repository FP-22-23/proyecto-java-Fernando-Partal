package fp.titanic;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class PasajerosImpl implements Pasajeros {

	private List<Pasajero> pasajeros;

	public PasajerosImpl() {
		pasajeros = new ArrayList<Pasajero>();
	}
	public PasajerosImpl(Collection<Pasajero> pasajeros) {
		this.pasajeros = new ArrayList<Pasajero>(pasajeros);
	}

	public int hashCode() {
		return Objects.hash(pasajeros);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PasajerosImpl other = (PasajerosImpl) obj;
		return Objects.equals(pasajeros, other.pasajeros);
	}
	public String toString() {
		return "PasajerosImpl [pasajeros=" + pasajeros + "]";
	}
	public void agregarPasajero(Pasajero t) {
		pasajeros.add(t);
	}
	public Integer getNumeroPasajeros() {
		return pasajeros.size();
	}
	public void agregarPasajeros(Collection<Pasajero> t) {
		pasajeros.addAll(t);
	}
	
	public void eliminarPasajero(Pasajero t) {
		pasajeros.remove(t);
	}
	/**
	 * Devuelve el coste medio del Ticket
	 */
	public Double getCosteTicketMedio() {
		Double res = 0.0;
		Double suma =0.0;
		Integer cont = 0;
		for (Pasajero t: this.pasajeros) {
				suma+= t.getTicketPrice();
				cont++;
			}
		if (cont>0) {
			res = suma/cont;
			}
		return res;
	}
	/**
	 * Devuelve True o False dependiendo de si se encuentra el pasajero o no pasado como parametro.
	 */
	public Boolean getEstaPasajero(String name) {
		Boolean res = false;
		for(Pasajero t: pasajeros) {
			if(t.getName().equals(name)) {
				res = true;
				break;
			}
		}
		return res;
	}
	/**
	 * Filtra la lista dejando solo aquellos pasajeros que hayan sobrevivido o aquellos que no.
	 */
	public List<Pasajero> getListaFiltradaSupervivientes(Boolean s){
		ArrayList<Pasajero> res = new ArrayList<>();
		for (Pasajero t: pasajeros) {
			if(t.getSurvived().equals(s)) {
				res.add(t);
			}
		}
		return res;
	}
	/**
	 * Devuelve un diccionario con el csv diferenciando segun que puerta de embarque hayan utilizado.
	 */
	public Map<Puerta,List<Pasajero>> getDiccionarioSegunPuertaEmbarque(){
		Map<Puerta,List<Pasajero>> res = new HashMap<Puerta,List<Pasajero>>();
		for(Pasajero t: pasajeros) {
			if(res.containsKey(t.getPortEmbarked())){
				res.get(t.getPortEmbarked()).add(t);
			}
			else {
				ArrayList<Pasajero> pasajeros= new ArrayList<>();
				pasajeros.add(t);
				res.put(t.getPortEmbarked(), pasajeros);
			}
		}
		return res;
	}
	/**
	 * Delvuenve la suma de los costes del ticket diferenciando entre los pasajeros que eran ricos y aquellos que no.
	 */
	public Map<Boolean,Double> getCosteDelTicketSegunSituacionEconomica(){
		Map<Boolean,Double> res = new HashMap<Boolean,Double>();
		for (Pasajero t: pasajeros) {
			if(res.containsKey(t.getRich())){
				res.put(t.getRich(), res.get(t.getRich())+t.getTicketPrice());
			}
			else {
				res.put(t.getRich(), t.getTicketPrice());
			}
		}
		return res;
	}
	
}
