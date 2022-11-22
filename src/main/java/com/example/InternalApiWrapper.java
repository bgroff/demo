package com.example;

import io.micronaut.http.HttpResponse;
import jakarta.inject.Singleton;

@Singleton
public class InternalApiWrapper {
  private final ConfigApiClient client;

  public InternalApiWrapper(final ConfigApiClient client) {
    this.client = client;
  }

  public HttpResponse<String> doWork() {
    final HttpResponse<String> res = client.doWork();
    return res;
  }
}
