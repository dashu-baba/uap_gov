package dev.nowshad.uap_gov.worker;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public record WorkerResponse(
        String nid,
        String mobile,
        String name,
        Long id
) {
        static WorkerResponse toResponse(Worker worker) {
                return new WorkerResponse(
                        worker.getNid(),
                        worker.getMobile(),
                        worker.getName(),
                        worker.getId()
                );
        }
}
