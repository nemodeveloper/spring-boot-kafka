package ru.nemodev.kafka.producer.transport.kafka.producer.message.builder.factory;

import ru.nemodev.kafka.producer.transport.kafka.producer.message.builder.ObjectKafkaMessageBuilder;

/**
 * created by simanov-an
 */
public interface KafkaMessageBuilderFactory {
    ObjectKafkaMessageBuilder getObjectKafkaMessageBuilder();
}
