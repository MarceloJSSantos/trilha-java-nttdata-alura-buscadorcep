import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Endereco;

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
