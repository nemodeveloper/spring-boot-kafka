package ru.nemodev.kafka.producer.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * created by simanov-an
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDto {
    private String name;
    private String desc;
}
