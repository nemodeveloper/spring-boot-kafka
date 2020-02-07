package ru.nemodev.kafka.producer.transport.kafka.consumer;

import ru.nemodev.kafka.producer.api.dto.WorkerDto;

import java.util.List;

/**
 * created by simanov-an
 */
public interface KafkaMessageConsumer<T> {
    void onMessage(T message);
    void onMessage(List<T> messages);
}
