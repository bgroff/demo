package com.example;

import dev.speakeasyapi.micronaut.EnableSpeakeasyInterceptor;
import dev.speakeasyapi.micronaut.SpeakeasyFilter;
import io.micronaut.context.annotation.Import;
import io.micronaut.context.annotation.Value;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import jakarta.inject.Singleton;


@Singleton
@Import(classes = {SpeakeasyFilter.class, EnableSpeakeasyInterceptor.class},
        annotated = "*")
public class Application implements ApplicationEventListener<ServerStartupEvent> {

    @Value("${speakeasy.config.api-id}")
    String apiId;

    @Value("${speakeasy.config.version-id}")
    String versionId;

    public static void main(final String[] args) {
        Micronaut.run(Application.class, args);
    }

    @Override
    public void onApplicationEvent(final ServerStartupEvent event) {
        EnableSpeakeasyInterceptor.configure(
                apiId,
                versionId);
    }

}