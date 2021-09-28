package com.example.java817presentation.httpClient;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HttpClientPresentation {
    HttpRequest creatingRequest() throws URISyntaxException {
       return HttpRequest.newBuilder(new URI("google.com"))
               .build();
    }
    HttpRequest getRequest() throws URISyntaxException {
        return HttpRequest.newBuilder(new URI("google.com"))
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .build();
    }
    HttpRequest postRequest() throws URISyntaxException {
        return HttpRequest.newBuilder(new URI("google.com"))
                .version(HttpClient.Version.HTTP_2)
                .headers("Content-Type", "text/plain;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString("Some body"))
                .build();
    }
    HttpResponse response() throws URISyntaxException, IOException, InterruptedException {
        HttpResponse response =HttpClient.newBuilder()
                .proxy(ProxySelector.getDefault())
                .build()
                .send(getRequest(),HttpResponse.BodyHandlers.ofString());
        response.headers();
        response.body();
        response.version();
        response.statusCode();
        return response;
    }
    CompletableFuture<HttpResponse<String>> asyncResponse() throws URISyntaxException{
        CompletableFuture<HttpResponse<String>> response = HttpClient.newBuilder()
                .build()
                .sendAsync(getRequest(), HttpResponse.BodyHandlers.ofString());
        return response;
    }

}
