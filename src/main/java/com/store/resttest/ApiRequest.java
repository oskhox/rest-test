package com.store.resttest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.resttest.model.Root;
import com.store.resttest.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
@Component //så att spring vet att den kan använda detta när programmet körs
public class ApiRequest {

    //1. hämta in repository
    ProductRepository productRepository;
    public ApiRequest(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void fetchAndSaveProducts() throws Exception {

        //2. api-infon från fakestore-api rakt av, skapa get connection
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL("https://fakestoreapi.com/products");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();

        //3. hämta all data, skapa objekt en efter en, spara i databasen en efter en
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }

            Root[] products = mapper.readValue(sb.toString(), Root[].class);

            for (Root p : products) {
                productRepository.save(p);
                System.out.println("Saved product: " + p.getTitle());
            }
        }
    }
}