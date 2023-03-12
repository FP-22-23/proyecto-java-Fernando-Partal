# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2022/23)
Autor/a: Fernando Partal García   uvus:VYP4652

## Estructura de las carpetas del proyecto

* **/src**: Directorio con el código fuente.
  * **fp.titanic**: Paquete que contiene los tipos del proyecto.
  * **fp.titanic.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
  * **common**:  Paquete que contiene la clase del tipo auxiliar.
* **/data**: Contiene el dataset del proyecto.
  * **titanic_train.csv**: Archivo csv que contiene datos de los diferentes pasajeros del titanic.
    
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

### Tipo Base - Titanica
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
- C2: Crea un objeto de tipo **Titanic** a partir de los siguientes parámetros: name , sex y survived. Todos los demás parametros pasan a tomar el valor "null", menos portEmbarked que es de serie = Q..

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


- AlturaPeso: Está compuesto por el peso del pasajero, de tipo Double (en kg) y por la aultura, de tipo Integer, en (cm)..

