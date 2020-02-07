package ru.nemodev.kafka.producer.transport.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;

/**
 * created by simanov-an
 */
public abstract class SimpleKafkaMessageConsumerImpl<T> implements KafkaMessageConsumer<T> {

    @Override
    @KafkaListener(id = "${spring.kafka.consumer.id.single}",
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "#{'${spring.kafka.consumer.topic}'.split(',')}",
            containerFactory = "singleFactory")
    public void onMessage(T message) {
        doOnMessage(message);
    }

    @Override
    @KafkaListener(id = "${spring.kafka.consumer.id.batch}",
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "#{'${spring.kafka.consumer.topic}'.split(',')}",
            containerFactory = "batchFactory")
    public void onMessage(List<T> messages) {
        messages.forEach(this::doOnMessage);
    }

    protected abstract void doOnMessage(T message);
}
