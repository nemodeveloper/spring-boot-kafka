package ru.nemodev.kafka.producer.transport.kafka.producer.message.builder.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.nemodev.kafka.producer.transport.kafka.producer.message.builder.ObjectKafkaMessageBuilder;

/**
 * created by simanov-an
 */
public class KafkaMessageBuilderFactoryImpl implements KafkaMessageBuilderFactory {

    private final ObjectMapper objectMapper;

    public KafkaMessageBuilderFactoryImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public ObjectKafkaMessageBuilder getObjectKafkaMessageBuilder() {
        return new ObjectKafkaMessageBuilder(objectMapper);
    }
}
