package br.com.mf.service;

import br.com.mf.util.MyServiceClient;
import br.com.mf.util.RequestData;
import br.com.mf.util.ResponseData;
import com.google.gson.Gson;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Objects;

@Service
public class MyServiceClientImpl  {
    private final RestTemplate restTemplate;
    private final String baseUrl;
    Logger logger = LogManager.getLogger(MyServiceClientImpl.class);
    @Autowired
    public MyServiceClientImpl(RestTemplate restTemplate, @Value("${external.service.base-url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }


    @CircuitBreaker(name="backendC",fallbackMethod="fetchDataFallback")
    public HashMap<String, Object> fetchData(Long idClient) {
        String baseUrl = "http://localhost:8086";
        System.out.println("Entre no consulta");
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl + "/deadline/{idClient}")
                .queryParam("idClient", idClient)
                .toUriString();
        logger.debug("url:" + url);
        System.out.println(url);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String result = response.getBody();
        Gson gson = new Gson();
        return gson.fromJson(result, HashMap.class);

    }
    public HashMap<String, Object> fetchDataFallback(Long idClient,Throwable throwable) {
        // Este é o método de fallback que será chamado se ocorrer um erro
        HashMap<String, Object> fallbackData = new HashMap<>();
        fallbackData.put("message", "Erro ao buscar os dados, retornando valor padrão");
        fallbackData.put("idClient", idClient);
        fallbackData.put("defaultValue", true);
        return fallbackData;
    }
}
