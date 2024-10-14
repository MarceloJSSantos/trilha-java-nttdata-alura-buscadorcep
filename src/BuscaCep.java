import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Endereco;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class BuscaCep {
    static Endereco endereco;
    public static Endereco buscaEndereco(String cep){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        var uri = URI.create("http://viacep.com.br/ws/" + URLEncoder.encode(cep, StandardCharsets.UTF_8) + "/json/");

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponde = response.body();
            endereco = gson.fromJson(jsonResponde, Endereco.class);

        } catch (Exception e){
           throw new RuntimeException();
        }
        return endereco;
    }
}
