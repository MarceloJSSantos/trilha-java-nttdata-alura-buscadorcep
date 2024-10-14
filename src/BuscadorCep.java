import br.com.alura.mjss.buscadorcep.modelos.Endereco;
import br.com.alura.mjss.buscadorcep.utilitarios.BuscaCep;
import br.com.alura.mjss.buscadorcep.utilitarios.GeraArquivoJson;

import java.io.IOException;
import java.util.Scanner;

public class BuscadorCep {
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
