## Executar MoonDream no Java usando Ollama

### Requisitos
- [Java 11 ou superior](https://www.oracle.com/br/java/technologies/downloads/)
- [Ollama](https://ollama.com/)
- [Maven](https://maven.apache.org/)

### Processo

#### 1. Baixar o Ollama
Acesse o site [Ollama](https://ollama.com/) e faça o download.

#### 2. Verificar se o Ollama está rodando
Abra o navegador e acesse [http://localhost:11434](http://localhost:11434).

Se estiver tudo certo, você verá **Ollama is running**. Caso contrário, significa que o Ollama não está em execução, então certifique-se de abri-lo após o download.

#### 3. Baixar o modelo Moondream
No terminal, execute o seguinte comando para baixar o modelo Moondream:

```bash
 ollama run moondream
 ```

Para descobrir mais modelos abra o [Link](https://ollama.com/library)

Caso você queira descobrir mais comandos do Ollama digite no terminal
``` bash 
ollama 
```

#### 4. Criar um projeto Maven e adicionar dependências
Crie um novo projeto Maven no seu IDE e adicione as seguintes dependências ao seu `pom.xml`:

```xml 
<dependency>
    <groupId>io.github.ollama4j</groupId>
    <artifactId>ollama4j</artifactId>
    <version>1.0.82</version>
</dependency>

<dependency>
<groupId>org.slf4j</groupId>
<artifactId>slf4j-jdk14</artifactId>
<version>2.0.9</version>
</dependency>
```
        
        
#### 5. Conectar o Java com o modelo do Ollama
Utilize o seguinte código Java para se conectar ao modelo Moondream usando o Ollama:

```java
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
                        new File("\\Caminho\\imagem\\demo-1.jpg")), //Caminho da imagem
                new OptionsBuilder().build()
        );
        System.out.println(result.getResponse()); //Imprimir resposta
    }
}

```
#### 6. Executar o programa
Ao rodar o programa, inicialmente será exibido o JSON da requisição:

```plaintext
ago. 31, 2024 8:32:00 PM io.github.ollama4j.models.request.OllamaEndpointCaller callSync
INFO: Asking model: {
"model" : "moondream",
"options" : { },
"stream" : false,
"prompt" : "What is she doing?",
"images" : [ "Um monte de caracteres" ],
"raw" : false
}
```


Após um tempo retornara uma resposta

```plaintext
ago. 31, 2024 8:33:21 PM io.github.ollama4j.models.request.OllamaEndpointCaller callSync
INFO: Model response: {
"response" : "The girl in the image is sitting at a table and eating a large hamburger. She appears to be enjoying her meal, possibly even making a funny face as she takes bites of it.",
"httpStatusCode" : 200,
"responseTime" : 81243
}

The girl in the image is sitting at a table and eating a large hamburger. She appears to be enjoying her meal, possibly even making a funny face as she takes bites of it.
```
**Observação**
Se você encontrar o seguinte erro:

```plaintext
Exception in thread "main" java.net.http.HttpTimeoutException: request timed out
```

### Documentação
- [Ollama](https://ollama.com/)
- [Ollama4j](https://ollama4j.github.io/ollama4j/)
- [MoonDream](https://moondream.ai/)

