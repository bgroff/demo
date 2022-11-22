package com.example;

import dev.speakeasyapi.micronaut.implementation.SpeakeasyChannelDuplexHandler;
import io.micronaut.context.event.BeanCreatedEvent;
import io.micronaut.context.event.BeanCreatedEventListener;
import io.micronaut.http.netty.channel.ChannelPipelineCustomizer;
import io.micronaut.http.server.netty.NettyServerCustomizer;
import io.netty.channel.Channel;
import jakarta.inject.Singleton;

@Singleton
public class SpeakeasyNettyServerCustomizer implements BeanCreatedEventListener<NettyServerCustomizer.Registry> {

  @Override
  public NettyServerCustomizer.Registry onCreated(final BeanCreatedEvent<NettyServerCustomizer.Registry> event) {
    final NettyServerCustomizer.Registry registry = event.getBean();
    registry.register(new Customizer(null));
    return registry;
  }

  private class Customizer implements NettyServerCustomizer {

    private final Channel channel;

    Customizer(final Channel channel) {
      this.channel = channel;
    }

    @Override
    public NettyServerCustomizer specializeForChannel(final Channel channel, final ChannelRole role) {
      return new Customizer(channel);
    }

    @Override
    public void onStreamPipelineBuilt() {
      channel.pipeline().addBefore(ChannelPipelineCustomizer.HANDLER_HTTP_STREAM, "speakeasy",
          new SpeakeasyChannelDuplexHandler());
    }

  }

}
