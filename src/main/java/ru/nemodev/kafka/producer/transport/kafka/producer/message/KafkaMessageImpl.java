package ru.nemodev.kafka.producer.transport.kafka.producer.message;

/**
 * created by simanov-an
 */
public class KafkaMessageImpl implements KafkaMessage {

    private final String message;

    public KafkaMessageImpl(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
