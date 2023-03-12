package fp.titanic;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import common.AlturaPeso;
import utiles.Checkers;

public class Titanic implements Comparable<Titanic>{
	private String name;
	private String sex;
	private Double ticketPrice;
	private Puerta portEmbarked;
	private LocalDate dateOfBirth;
	private Boolean survived;
	private Boolean rich;
	private List<String> highestPriceBelongings;
	private AlturaPeso alturaPeso;
	
	
	public Integer getEdad() {
		//LocalDate hundimiento = LocalDate.of(1912, 4, 14);
		Integer edad = null;
		if (this.dateOfBirth != null) {
			Integer hundimiento = 1912;
			edad = hundimiento - dateOfBirth.getYear();
		}
		return edad;
	}
	private List<String> parseaLista(String highestPriceBelongings){
		String[] pertenencias = highestPriceBelongings.split("/");
		return Arrays.asList(pertenencias);
	}
	private Boolean parseaBoolean(String x) {
		Boolean res = false;
		if (x == "1"){
			res = true;
		}
		return res;
	}
	
	public Titanic(String name, String sex, Double ticketPrice, Puerta portEmbarked, LocalDate dateOfBirth,
			String survived, String rich, String highestPriceBelongings, AlturaPeso alturaPeso) {
		Checkers.check("El nombre no puede estar vacio", name != "");
		Checkers.check("El precio del ticket no puede ser menor que 0", ticketPrice >= 0);
		this.name = name;
		this.sex = sex;
		this.ticketPrice = ticketPrice;
		this.portEmbarked = portEmbarked;
		this.dateOfBirth = dateOfBirth;
		this.survived = parseaBoolean(survived);
		this.rich = parseaBoolean(rich);
		this.highestPriceBelongings = parseaLista(highestPriceBelongings);
	}
	public Titanic(String name, String sex,String survived) {
		Checkers.check("El nombre no puede estar vacio", name != "");
		this.name = name;
		this.sex = sex;
		this.ticketPrice = null;
		this.portEmbarked = portEmbarked.Q;
		this.dateOfBirth = null;
		this.survived = parseaBoolean(survived);
		this.rich = null;
		this.highestPriceBelongings = null;
		this.alturaPeso = null;
	}
	
	
	public AlturaPeso getAlturaPeso() {
		return alturaPeso;
	}
	public void setAlturaPeso(AlturaPeso alturaPeso) {
		this.alturaPeso = alturaPeso;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		Checkers.check("El nombre no puede estar vacio", name != "");
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Double ticketPrice) {
		Checkers.check("El precio del ticket no puede ser menor que 0", ticketPrice >= 0);
		this.ticketPrice = ticketPrice;
	}

	public Puerta getPortEmbarked() {
		return portEmbarked;
	}

	public void setPortEmbarked(Puerta portEmbarked) {
		this.portEmbarked = portEmbarked;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Boolean getSurvived() {
		return survived;
	}

	public void setSurvived(Boolean survived) {
		this.survived = survived;
	}

	public Boolean getRich() {
		return rich;
	}

	public void setRich(Boolean rich) {
		this.rich = rich;
	}

	public List<String> getHighestPriceBelongings() {
		return highestPriceBelongings;
	}

	public void setHighestPriceBelongings(List<String> highestPriceBelongings) {
		this.highestPriceBelongings = highestPriceBelongings;
	}
	public String toString() {
		return "Titanic [name=" + name + ", sex=" + sex + ", ticketPrice=" + ticketPrice + ", portEmbarked="
				+ portEmbarked + ", dateOfBirth=" + dateOfBirth + ", survived=" + survived + ", rich=" + rich
				+ ", highestPriceBelongings=" + highestPriceBelongings + ", edad=" + getEdad() + "]";
	}
	
	public int hashCode() {
		return Objects.hash(name, sex);
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Titanic other = (Titanic) obj;
		return Objects.equals(name, other.name) && Objects.equals(sex, other.sex);
	}
	public int compareTo(Titanic t) {
		int res = this.getName().compareTo(t.getName());
		if (res == 0) {
			res = getSex().compareTo(t.getSex());
		}
		return res;
	}
	
	
	

}
