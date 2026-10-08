package dev.nowshad.uap_gov.worker;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public  WorkerResponse save(CreateWorkerRequest request) {
        return WorkerResponse.toResponse(workerRepository.save(
                CreateWorkerRequest.toWorker(request)
        ));
    }

    public List<WorkerResponse> getAll() {
        return workerRepository.findAll()
                .stream().map(WorkerResponse::toResponse).toList();
    }
}
