package dev.nowshad.uap_gov.application;

import dev.nowshad.uap_gov.worker.WorkerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final WorkerRepository workerRepository;

    public ApplicationService(ApplicationRepository applicationRepository, WorkerRepository workerRepository) {

        this.applicationRepository = applicationRepository;
        this.workerRepository = workerRepository;
    }

    public List<ApplicationResponse> getAll() {
        var applications = applicationRepository.getAllByStatus("SUBMITTED");
        return applications.stream()
                .map(ApplicationResponse::toResponse)
                .toList();
    }

    public ApplicationResponse save(Long workerId) {
        var worker = workerRepository.getReferenceById(workerId);
        return ApplicationResponse.toResponse(applicationRepository.save(
                new Application(
                        Instant.now(),
                        null,
                        worker,
                        Status.SUBMITTED
                )
        ));
    }

    @Transactional
    public ApplicationResponse update(Long id, ApplicationApprovalRequest request) {
        var application = applicationRepository.getReferenceById(id);

        application.setStatus(request.status());
        application.setReason(request.reason());

        return  ApplicationResponse.toResponse(application);
    }

    public List<ApplicationReportResponse> getReport() {
        var applications = applicationRepository.getAllByStatus(Status.APPROVED.toString());
        return applications.stream().map(ApplicationReportResponse::toApplicationReportResponse).toList();
    }
}
