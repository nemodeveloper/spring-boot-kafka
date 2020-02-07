package ru.nemodev.kafka.producer.transport.kafka.producer.message.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.nemodev.kafka.producer.transport.kafka.producer.message.KafkaMessage;
import ru.nemodev.kafka.producer.transport.kafka.producer.message.KafkaMessageImpl;

/**
 * created by simanov-an
 */
public class ObjectKafkaMessageBuilder implements KafkaMessageBuilder {

    private final ObjectMapper objectMapper;
    private Object messageBody;

    public ObjectKafkaMessageBuilder(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ObjectKafkaMessageBuilder withMessageBody(Object messageBody) {
        this.messageBody = messageBody;
        return this;
    }

    @Override
    public KafkaMessage build() {
        try {
            return new KafkaMessageImpl(objectMapper.writeValueAsString(messageBody));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
