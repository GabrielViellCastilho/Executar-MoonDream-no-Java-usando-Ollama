package org.example;




import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws OllamaBaseException, IOException, URISyntaxException, InterruptedException {
        String host = "http://localhost:11434/"; //URL do Ollama
        OllamaAPI ollamaAPI = new OllamaAPI(host);
        ollamaAPI.setRequestTimeoutSeconds(100); //Tempo de espera para obter resposta

        OllamaResult result = ollamaAPI.generateWithImageFiles("moondream", //Nome do modelo de IA
                "What is she doing?", //O comando
                List.of(
                        new File("Caminho\\imagem\\demo-1.jpg")), //Caminho da imagem
                new OptionsBuilder().build()
        );
        System.out.println(result.getResponse()); //Imprimir resposta
    }
}