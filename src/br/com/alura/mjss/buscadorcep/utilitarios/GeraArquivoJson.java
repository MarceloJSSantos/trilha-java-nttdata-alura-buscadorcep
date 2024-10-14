package br.com.alura.mjss.buscadorcep.utilitarios;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import br.com.alura.mjss.buscadorcep.modelos.Endereco;

import java.io.FileWriter;
import java.io.IOException;

public class GeraArquivoJson {
    public static void salvaJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        var nomeArquivo = endereco.cep() + ".json";
        FileWriter escrita = new FileWriter(nomeArquivo);
        escrita.write(gson.toJson(endereco));
        escrita.close();
        System.out.println("Arquivo '" + nomeArquivo + "' criado!" );
    }
}
