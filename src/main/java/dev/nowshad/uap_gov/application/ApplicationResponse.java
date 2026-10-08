package dev.nowshad.uap_gov.application;

import dev.nowshad.uap_gov.worker.Worker;

import java.time.Instant;

public record ApplicationResponse(
        String worker,
        String status,
        Instant applicationDate,
        Long id
) {
        static ApplicationResponse toResponse(Application application) {
                return new ApplicationResponse(
                        application.getWorker().getName(),
                        application.getStatus(),
                        application.getApplicationDate(),
                        application.getId()
                );
        }
}
