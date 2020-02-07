package ru.nemodev.kafka.producer.api.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nemodev.kafka.producer.api.dto.WorkerDto;
import ru.nemodev.kafka.producer.service.WorkerService;

/**
 * created by simanov-an
 */
@RestController
@RequestMapping(value = "/v1/worker")
public class WorkerEndpoint {

    private final WorkerService workerService;

    public WorkerEndpoint(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping
    public ResponseEntity<WorkerDto> create(@RequestBody WorkerDto worker) {
        workerService.startWork(worker);
        return ResponseEntity.ok(worker);
    }

}
