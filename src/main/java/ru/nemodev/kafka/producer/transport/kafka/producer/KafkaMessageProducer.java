package ru.nemodev.kafka.producer.transport.kafka.producer;

import ru.nemodev.kafka.producer.transport.kafka.producer.message.KafkaMessage;

/**
 * created by simanov-an
 */
public interface KafkaMessageProducer {
    void send(KafkaMessage message);
}
