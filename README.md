# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2022/23)
Autor/a: Fernando Partal García   uvus:VYP4652

## Estructura de las carpetas del proyecto

* **/src**: Directorio con el código fuente.
  * **fp.titanic**: Paquete que contiene los tipos del proyecto.
  * **fp.titanic.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
  * **common**:  Paquete que contiene la clase del tipo auxiliar.
* **/data**: Contiene el dataset del proyecto.
  * **titanic.csv**: Archivo csv que contiene datos de los diferentes pasajeros del titanic.
    
## Estructura del *dataset*

El dataset original estaba compuesto por 10 columnas y 1000 datos. A partir de este he eliminado 4 sin contenido util, y he creado 4 colunmnas nuevas: "HIGHEST PRICE BELONGINGS" , "PESO" , "ALTURA" y "DATE OF BIRTH", para así tener las variables de tipo lista, auxiliar y fecha, respectivamente. Esto era lo unico que le faltaba al csv inicial. Además he dejado los datos en 420 para facilitar la lectura. 
* **name**: de tipo String,  indica el nombre del pasajero..
* **sex**: de tipo String, indica el sexo del pasajero.
* **ticketPrice**: de tipo Double, indica el coste del billete..
* **portEmbarked**: de tipo Puerta, enumerado que muestra la puerta por la que entró al barco. Puede tomar los valores Q, C o S..
* **dateOfBirth**: de tipo LocalDate, indica la fecha de nacimiento del pasajero..
* **survived**: de tipo Boolean, indica si el pasajero sobrevivio o no. 1 = true , 0 = false..
* **rich**: de tipo Boolean, indica si el pasajero era rico o no. 1 = true, 0 = false. 
* **highestPriceBelongings**: de tipo List, indica las pertenencias con mayor valor monetario del pasajero en cuestión..
* **weight**: de tipo Double, indica el peso del pasajero, (en KG).

* **height**: de tipo Integer, indica la altura del pasajero (en cm).
.
## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base - Pasajero
Representa un pasajero del titanic en concreto.
.
**Propiedades**:

- **name**, de tipo String, consultable y modificable. Indica el nombre del pasajero, (No puede estar vacio). 
- **sex**, de tipo String, consultable y modificable. Indica el sexo del pasajero..
- **ticketPrice**, de tipo Double, consultable y modificable. Indica el Precio del billete, (No puede tomar valores negativos)..
- **portEmbarked**, de tipo Puerta, consultable y modificable. Enumerado que indica la puerta de entrada al barco. Puede tomar los valores Q , S o C..
- **dateOfBirth**, de tipo LocalDate, consultable y modificable. Indica la fecha de nacimiento del pasajero..
- **survived**, de tipo Boolean, consultable y modificable. Indica si el pasajero sobrevivio o no. 1 = true, 0 = false..
- **rich**, de tipo Boolean, consultable y modificable. Indica si el pasajero era rico o no. 1 = true, 0 = false..
- **highestPriceBelongings**, de tipo List\<String\>, consultable y modificable. Lista de pertenencias con mayor valor del pasajero en cuestión..
- **edad**, de tipo Integer, consultable. Propiedad derivada, se obtiene a partir de la resta entre el año del hundimiento del titanic (1912), y el año de nacimiento del pasajero. .


**Constructores**:

- C1: Tiene un parámetro por cada propiedad básica del tipo..
- C2: Crea un objeto de tipo **Pasajero** a partir de los siguientes parámetros: name , sex y survived. Todos los demás parametros pasan a tomar el valor "null", menos portEmbarked que es de serie = Q..


**Restricciones** 
- R1: El nombre no puede estar vacio..
- R2: El precio del billete no puede ser menor que 0..

***Criterio de igualdad**: Dos pasajeros son iguales si su nombre y sexo los son..

**Criterio de ordenación**: Por nombre y sexo..

**Otras operaciones**

- List<String> parseaLista(String highestPriceBelongings): Toma un String, lo divide en función a "/" y devuelve los datos en una unica lista que es devuelta.

- Boolean parseaBoolean(String x): Toma un String, si este es 1, devuelve true, en cambio si no lo es devuelve false.

- Integer getEdad(): Toma el año de la propiedad dateOfBirth y se la resta al año del hundimiento del titanic. Devuelve el resultado de la operación.

#### Tipos auxiliares


- AlturaPeso: Está compuesto por el peso del pasajero, de tipo Double (en kg) y por la aultura, de tipo Integer, en (cm).

### Factoria:

 - Clase FactoriaTitanic para crear objetos de tipo Pasajeros.
 
 Constructores:
 
 	- parseaPasajero: Recibe una linea del csv y devuelve un objeto de tipo Pasajero.
 	
 	- leerPasajeros: Recibe una ruta de archivo csv y duvuelve una lista de tipo pasajeros, con cada uno de los pasajeros del csv.

### Tipo Contenedor:

 - Clase contenedora de los objetos de tipo Pasajero.

 **Propiedades:**
 
 	- pasajeros: de tipo List<Pasajero>, consultable. Lista de pasajeros del titanic.
	- agregarPasajero: de tipo void. Agrega un pasajero a la lista de pasajeros.
	- getNumeroPasajeros, de tipo int. Devuelve el tamaño de la lista.
	- agregarPasajeros, de tipo void. Agrega una colleccion de pasajeros a la lista.
	- eliminarPasajeros, de tipo void. Elimina un pasajero en concreto de la lista.

 **Constructores:**
 
 	- C1: Constructor por defecto, crea una lista vacia.
 	- C2: Constructor que recibe una coleccion de elementos y a partir de esta crea una lista.
 
 **Criterio de igualdad:** Dos pasajeros son iguales si los son sus propiedades.
 
 **Otras Operaciones:**
 	
 		- getCosteTicketMedio: De tipo Double, devuelve el Coste medio de los tickets.
 	
 		-getEstaPasajero: De tipo Boolean, devuelve true o false si el pasajero pasado como parametro está en la lista o no.
 	
 		-getListaFiltradaSupervivientes: De tipo List<Pasajero>, devuelve una lista filtrada con los pasajeros que hayan sobrevivido o no segun si se le pasa por parametro true o false.
 	
 		-getDiccionarioSegunPuertaEmbarque: De tipo Map<Puerta,List<Pasajero>>, devuelve un diccionario en el que ordena a los pasajeros segun por que puerta de embarque hayan entrado.
 	
 		-getCosteDelTicketSegunSituacionEconomica: De tipo Map<Boolean,Double>, devuelve un diccionario en el que diferencia el coste total del ticket de todos los pasajeros ricos y el de todos los que no lo son.
 		
 		-getCosteTicketMedioStream: De tipo Double, devuelve el Coste medio de los tickets.
 		
 		-getEstaPasajeroStream: De tipo Boolean, devuelve true o false si el pasajero pasado como parametro está en la lista o no.
 		
 		-getListaFiltradaSupervivientesStream: De tipo List<Pasajero>, devuelve una lista filtrada con los pasajeros que hayan sobrevivido o no segun si se le pasa por parametro true o false.
 		-getEdadMaxima: De tipo Integer, devuelve el valor numerico de la edad maxima entre los pasajeros del titanic.
 		
 		-getListaFiltradaSexoOrdenadaEdad: De tipo List<Pasajero>, devuelve una lista filtrada segun el sexo pasado como parametro y ordenada segun la edad de los pasajeros.
 		
 		-getDiccionarioSegunPuertaEmbarqueStream: De tipo Map<Puerta,List<Pasajero>>, devuelve un diccionario en el que ordena a los pasajeros segun por que puerta de embarque hayan entrado.
 		
 		-getDiccionarioTicketPriceSegunPuertaEmbarque: De tipo Map<Puerta,List<Double>> , devuelve un diccionario con los precios de los tickets segun la puerta de embarque utilizada.
 		
 		-getDiccionarioEdadMinimaSegunGenero: De tipo Map<String, Integer>, devuelve un diccionario con la edad minima segun el genero del pasajero.
 		
 		-getDiccionarioOrdenadoConLosNMayoresEdadesSegunSupervivencia: De tipo SortedMap<Boolean, List<String>>, devuelve un sorted map con los n nombres de los pasajeros mas mayores segun si sobrevivieron o no.
 		
 		-getPuertaEmbarqueConTicketMasCaro: De tipo Puerta, devuelve la Puerta a la que le corresponde el ticket mas caro.
	
 	