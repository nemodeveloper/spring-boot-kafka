package ru.nemodev.kafka.producer.transport.kafka.consumer;

import ru.nemodev.kafka.producer.api.dto.WorkerDto;

/**
 * created by simanov-an
 */
public class WorkerKafkaConsumer extends SimpleKafkaMessageConsumerImpl<WorkerDto> {

    @Override
    protected void doOnMessage(WorkerDto message) {
        System.out.println("Who - " + message.getName() + " What to do - " + message.getDesc());
    }
}
