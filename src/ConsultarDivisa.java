import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class ConsultarDivisa {
    private static final String API_KEY = "fd91561aaf25ecbae2e4a6f0";

    public Monedas buscaMoneda(String divisa) {
        String apiUrl = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + divisa;
        URI url = URI.create(apiUrl);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                return gson.fromJson(response.body(), Monedas.class);
            } else if (response.statusCode() == 401) {
                System.out.println("Error: Clave de API invalida. Verifique su clave de API.");
            } else if (response.statusCode() == 404) {
                System.out.println("Error: Moneda no encontrada o URL incorrecta.");
            } else {
                System.out.println("Error en la respuesta de la API: " + response.statusCode());
            }

        } catch (java.net.UnknownHostException e) {
            System.out.println("Error: No se pudo establecer una conexion. Verifique su conexion a internet.");
        } catch (Exception e) {
            System.out.println("Ocurrio un error inesperado: " + e.getMessage());
        }

        return null;
    }
}


