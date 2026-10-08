package dev.nowshad.uap_gov.application;

import java.time.Instant;

public record ApplicationReportResponse(
        Long applicationId,
        String workerName,
        String nid,
        Instant applicationDate,
        Instant approvedDate,
        String status
) {
    static ApplicationReportResponse toApplicationReportResponse(Application application) {
        return new ApplicationReportResponse(
                application.getId(),
                application.getWorker().getName(),
                application.getWorker().getNid(),
                application.getApplicationDate(),
                null,
                application.getStatus()
        );
    }
}
