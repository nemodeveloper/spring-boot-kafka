package ru.nemodev.kafka.producer.config.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.nemodev.kafka.producer.api.dto.WorkerDto;
import ru.nemodev.kafka.producer.transport.kafka.producer.KafkaMessageProducer;
import ru.nemodev.kafka.producer.service.WorkerService;
import ru.nemodev.kafka.producer.service.WorkerServiceImpl;
import ru.nemodev.kafka.producer.transport.kafka.producer.message.builder.factory.KafkaMessageBuilderFactory;
import ru.nemodev.kafka.producer.transport.kafka.producer.message.builder.factory.KafkaMessageBuilderFactoryImpl;

/**
 * created by simanov-an
 */
@Configuration
@EnableScheduling
public class WorkerServiceConfig {

    private static long counter = 0L;

    private final ObjectMapper objectMapper;
    private final KafkaMessageProducer kafkaMessageProducer;

    public WorkerServiceConfig(ObjectMapper objectMapper, KafkaMessageProducer kafkaMessageProducer) {
        this.objectMapper = objectMapper;
        this.kafkaMessageProducer = kafkaMessageProducer;
    }

    @Bean
    public WorkerService workerService() {
        return new WorkerServiceImpl(kafkaMessageBuilderFactory(), kafkaMessageProducer);
    }

    @Bean
    public KafkaMessageBuilderFactory kafkaMessageBuilderFactory() {
        return new KafkaMessageBuilderFactoryImpl(objectMapper);
    }

    @Scheduled(initialDelay = 2000, fixedDelay = 1000)
    public void produce() {
        workerService().startWork(new WorkerDto("Kafka Tester " + counter, "Kafka spammer"));
        ++counter;
    }
}
