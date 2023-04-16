package fp.titanic.test;

import java.time.LocalDate;

import common.AlturaPeso;
import fp.titanic.Puerta;
import fp.titanic.Pasajero;

public class TestTitanic {

	public static void main(String[] args) {
		Pasajero t1 = new Pasajero("Tricia Panting","female","1");
		Pasajero t2 = new Pasajero("Elden Klessmann","male",78.292,Puerta.Q,LocalDate.of(1881, 04, 16),"1","1","clock/wallet/hat",new AlturaPeso(71.0,150));
		System.out.println("t1: "+t1);
		System.out.println("t2: "+t2);
		t1.setName("Luka Perkovic");
		t1.setTicketPrice(59.3);
		System.out.println("t1 editado: "+ t1);
		System.out.println("¿Son t1 y t2 iguales? "+t1.equals(t2));
		System.out.println("HashCode de t1: "+t1.hashCode());
		System.out.println("HashCode de t2: "+t2.hashCode());
		Pasajero t3 = new Pasajero("Gasparo MacCumeskey","male","0");
		Pasajero t4 = new Pasajero("Ogdon Nevin","male","1");
		Pasajero t5 = t3;
		System.out.println("¿Son t3 y t4 iguales?: "+t3.equals(t4));
		System.out.println("¿Son t3 y t5 iguales?: "+t3.equals(t5));
		System.out.println("Calculo del criterio de orden entre t3 y t4: "+t3.compareTo(t4));
		System.out.println("Calculo del criterio de orden entre t3 y t5: "+t3.compareTo(t5));
	}

}
