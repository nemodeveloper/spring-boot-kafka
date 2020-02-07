package ru.nemodev.kafka.producer.service;

import ru.nemodev.kafka.producer.api.dto.WorkerDto;
import ru.nemodev.kafka.producer.transport.kafka.producer.KafkaMessageProducer;
import ru.nemodev.kafka.producer.transport.kafka.producer.message.builder.ObjectKafkaMessageBuilder;
import ru.nemodev.kafka.producer.transport.kafka.producer.message.builder.factory.KafkaMessageBuilderFactory;


/**
 * created by simanov-an
 */
public class WorkerServiceImpl implements WorkerService {

    private final KafkaMessageBuilderFactory kafkaMessageBuilderFactory;
    private final KafkaMessageProducer kafkaMessageProducer;

    public WorkerServiceImpl(KafkaMessageBuilderFactory kafkaMessageBuilderFactory, KafkaMessageProducer kafkaMessageProducer) {
        this.kafkaMessageBuilderFactory = kafkaMessageBuilderFactory;
        this.kafkaMessageProducer = kafkaMessageProducer;
    }

    @Override
    public void startWork(WorkerDto workerDto) {
        ObjectKafkaMessageBuilder messageBuilder = kafkaMessageBuilderFactory.getObjectKafkaMessageBuilder();
        messageBuilder.withMessageBody(workerDto);

        kafkaMessageProducer.send(messageBuilder.build());
    }

}
