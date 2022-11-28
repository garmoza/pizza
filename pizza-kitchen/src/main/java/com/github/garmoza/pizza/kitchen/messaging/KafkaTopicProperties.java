package com.github.garmoza.pizza.kitchen.messaging;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = "pizza.kafka-topic")
public record KafkaTopicProperties(@DefaultValue("kitchen") String kitchen, @DefaultValue("ready") String app) {
}
