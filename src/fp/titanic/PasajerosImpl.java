package fp.titanic;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class PasajerosImpl implements Pasajeros {

	private List<Pasajero> pasajeros;

	public PasajerosImpl() {
		pasajeros = new ArrayList<Pasajero>();
	}
	public PasajerosImpl(Collection<Pasajero> pasajeros) {
		this.pasajeros = new ArrayList<Pasajero>(pasajeros);
	}
	public PasajerosImpl(Stream<Pasajero> pasajeros) {
		this.pasajeros = pasajeros.collect(Collectors.toList());
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
	 * Devuelve el coste medio del Ticket
	 */
	public Double getCosteTicketMedioStream() {
		return pasajeros.stream().mapToDouble(x -> x.getTicketPrice()).average().getAsDouble();
	}
	/**
	 * Devuelve True o False dependiendo de si se encuentra el pasajero o no pasado como parametro.
	 */
	public Boolean getEstaPasajeroStream(String name) {
		return pasajeros.stream().anyMatch(x->x.getName().equals(name));
	}
	/**
	 * Filtra la lista dejando solo aquellos pasajeros que hayan sobrevivido o aquellos que no.
	 */
	public List<Pasajero> getListaFiltradaSupervivientesStream(Boolean s){
		return pasajeros.stream().filter(x->x.getRich().equals(s)).collect(Collectors.toList());
	}
	/**
	 * Devuelve el pasajero más mayor del naufragio
	 */
	public Integer getEdadMaxima() {
		return pasajeros.stream().mapToInt(x->x.getEdad()).max().getAsInt();
	}
	/**
	 * Devuelve la Lista filtrada por el sexo que se le pasa como parametro y ordenada por la edad de los pasajeros
	 */
	public List<Pasajero> getListaFiltradaSexoOrdenadaEdad(String sexo){
		return pasajeros.stream().filter(x->x.getSex().equals(sexo)).sorted(Comparator.comparing(Pasajero::getEdad).thenComparing(Comparator.naturalOrder())).collect(Collectors.toList());
	}
	/**
	 * Devuelve un diccionario con el csv diferenciando segun que puerta de embarque hayan utilizado.
	 */
	public Map<Puerta,List<Pasajero>> getDiccionarioSegunPuertaEmbarqueStream(){
		return pasajeros.stream().collect(Collectors.groupingBy(Pasajero::getPortEmbarked));
		
	}
	/**
	 * Devuelve un diccionario con todos los precios de los tikcets, diferenciando segun por que puerta entraron
	 */
	public Map<Puerta,List<Double>> getDiccionarioTicketPriceSegunPuertaEmbarque() {
		return pasajeros.stream().collect(Collectors.groupingBy(Pasajero::getPortEmbarked,Collectors.mapping(Pasajero :: getTicketPrice, Collectors.toList())));
	}
	/**
	 * Devuelve un diccionario la clave los 2 generos y valor la edad minima de un pasajero con dicho genero.
	 */
	public Map<String, Integer> getDiccionarioEdadMinimaSegunGenero(){
		return pasajeros.stream().collect(Collectors.toMap(Pasajero::getSex,Pasajero::getEdad,Integer::min));
	}
	/**
	 * Devuelve un diccionario con dos claves True o False en funcion de si han sobrevivido o no, y de valor los "n" nombres mas mayores.
	 */
	public SortedMap<Boolean, List<String>> getDiccionarioOrdenadoConLosNMayoresEdadesSegunSupervivencia(Integer n){
		return pasajeros.stream().collect(Collectors.groupingBy(Pasajero::getSurvived,TreeMap::new,Collectors.collectingAndThen(Collectors.toList(), x ->funcionAuxiliar(x,n))));
	}
	
	private static List<String> funcionAuxiliar(List<Pasajero> x ,Integer n){
		Comparator<Pasajero> comparador = Comparator.comparing(Pasajero::getEdad);
		return x.stream().sorted(Collections.reverseOrder(comparador)).limit(n).map(Pasajero::getName).collect(Collectors.toList());
	}
	/**
	 * Devuelve la puerta a la cual le corresponde el ticket mas caro de todos los pasajeros
	 */
	public Puerta getPuertaEmbarqueConTicketMasCaro() {
		return pasajeros.stream().max(Comparator.comparing(Pasajero::getTicketPrice)).map(Pasajero::getPortEmbarked).orElse(null);
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
