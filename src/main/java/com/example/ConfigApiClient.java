package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

import static io.micronaut.http.HttpHeaders.ACCEPT;
import static io.micronaut.http.HttpHeaders.USER_AGENT;

@Client(ClientConfigs.API_URL)
@Header(name = USER_AGENT,
        value = "Micronaut HTTP Client")
@Header(name = ACCEPT,
        value = "application/json")
public interface ConfigApiClient {

  @Post(value = "test",
          processes = MediaType.APPLICATION_JSON)
  HttpResponse<String> doWork();
}