
# Conversor de Monedas

Este proyecto es una aplicación sencilla de conversión de monedas desarrollada en Java. La aplicación permite al usuario convertir una cantidad de dinero de una moneda a otra usando datos de tipo de cambio obtenidos de una API de tasas de cambio.


## Características

- Conversión de monedas en tiempo real utilizando la API de Exchange Rate.
- Interfaz de usuario basada en **JOptionPane** para una experiencia de usuario interactiva.
- Manejo de errores comunes, como entradas no válidas y problemas de conexión a la API.



## Instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/tuusuario/conversor-de-monedas.git
   cd conversor-de-monedas
   ```

2. Asegúrate de tener la biblioteca Gson en tu proyecto. Puedes añadir el archivo `gson.jar` a tu proyecto o, si usas Maven, incluir la dependencia en tu archivo `pom.xml`:

   ```xml
   <dependency>
       <groupId>com.google.code.gson</groupId>
       <artifactId>gson</artifactId>
       <version>2.8.8</version>
   </dependency>
   ```

3. Obtén una clave de API de [Exchange Rate API](https://www.exchangerate-api.com/) y reemplaza **YOUR_API_KEY** en **ConsultarDivisa.java** con tu clave de API.

## Requisitos
- Java 11 o superior
- Biblioteca externa [Gson](https://github.com/google/gson) para procesar el formato JSON.
- IDE de su preferencia que soporte el Lenguaje Java, por ejemplo NetBeans, Intellij IDEA, etc.
## Uso

1. Ejecuta el programa:
   
   ```bash
   javac Principal.java
   java Principal
   ```

2. Sigue las instrucciones en la interfaz para seleccionar la moneda de origen, la moneda de destino y la cantidad a convertir.

## Estructura del Código

- **Principal.java**: Clase principal que ejecuta el menú principal y llama al método para realizar conversiones.
- **ConsultarDivisa.java**: Se encarga de conectarse a la API y obtener los datos de conversión.
- **Monedas.java**: Clase `record` que almacena la información de las tasas de conversión obtenidas.
- **ConvertidorJsonAObjeto.java**: Usa Gson para convertir la respuesta JSON de la API en un objeto Java.

## Ejemplo de Conversión

- Selecciona la opción 1 en el menú para realizar una conversión.
- Ingresa el código de la moneda de origen (por ejemplo, USD).
- Ingresa el código de la moneda de destino (por ejemplo, EUR).
- Ingresa la cantidad a convertir (por ejemplo, 100).

La aplicación mostrará el resultado de la conversión en la interfaz.



## Licencia

Este proyecto está disponible bajo la Licencia [MIT](https://choosealicense.com/licenses/mit/)



## Referencia de API

Para obtener una clave de API, visita el sitio de [Exchange Rate API](https://www.exchangerate-api.com/) y reemplaza **YOUR_API_KEY** en **ConsultarDivisa.java** con tu clave de API.