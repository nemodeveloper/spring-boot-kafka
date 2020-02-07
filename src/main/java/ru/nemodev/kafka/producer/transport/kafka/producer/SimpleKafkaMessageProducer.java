package ru.nemodev.kafka.producer.transport.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import ru.nemodev.kafka.producer.transport.kafka.producer.message.KafkaMessage;

/**
 * created by simanov-an
 */
@Slf4j
public class SimpleKafkaMessageProducer implements KafkaMessageProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topicName;

    public SimpleKafkaMessageProducer(KafkaTemplate<String, String> kafkaTemplate, String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    @Override
    public void send(KafkaMessage kafkaMessage) {
        try {
            kafkaTemplate.send(topicName, kafkaMessage.getMessage());
        }
        catch (Exception e) {
            log.error("Произошла ошибка отправки сообщения в kafka!", e);
        }
        finally {
            log.info(String.format("Сообщение=%s \nУспешно отправлено в kafka topic=%s",
                    kafkaMessage.getMessage(), topicName));
        }
    }
}
