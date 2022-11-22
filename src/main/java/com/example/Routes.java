package com.example;

import io.micronaut.http.annotation.Controller;

import javax.ws.rs.GET;


@Controller("/do_work")
public class Routes {

  final InternalApiWrapper internalApiWrapper;

  Routes(final InternalApiWrapper internalApiWrapper) {
    this.internalApiWrapper = internalApiWrapper;
  }

  @GET
  public void syncConnection() {
    internalApiWrapper.doWork();
  }
}
