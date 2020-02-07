package ru.nemodev.kafka.producer.transport.kafka.producer.message.builder;

import ru.nemodev.kafka.producer.transport.kafka.producer.message.KafkaMessage;

/**
 * created by simanov-an
 */
public interface KafkaMessageBuilder {
    KafkaMessage build();
}
