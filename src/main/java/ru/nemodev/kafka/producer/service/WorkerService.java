package ru.nemodev.kafka.producer.service;

import ru.nemodev.kafka.producer.api.dto.WorkerDto;

/**
 * created by simanov-an
 */
public interface WorkerService {
    void startWork(WorkerDto workerDto);
}
