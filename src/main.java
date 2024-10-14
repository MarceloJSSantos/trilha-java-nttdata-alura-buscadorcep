import com.google.gson.JsonSyntaxException;
import modelos.Endereco;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.println("Digite um CEP para buscar um endereço");
            String cep = entrada.next();
            Endereco endereco = BuscaCep.buscaEndereco(cep);
            GeraArquivoJson.salvaJson(endereco);
        } catch (RuntimeException e){
            System.out.println("Não foi possível obter um endereço com o CEP passado: '" +
                    e.getMessage() + "'");
        } catch (IOException e) {
            System.out.println("Não foi possível salvar o arquivo com o endereço: '" +
                    e.getMessage() + "'");
        }
    }
}
