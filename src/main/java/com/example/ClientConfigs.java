package com.example;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Requires;


@ConfigurationProperties(ClientConfigs.PREFIX)
@Requires(property = ClientConfigs.PREFIX)
public class ClientConfigs {

  public static final String PREFIX = "config-api";
  public static final String API_URL = "https://google.com/";

}
