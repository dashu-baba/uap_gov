package dev.nowshad.uap_gov.application;

import dev.nowshad.uap_gov.worker.CreateWorkerRequest;
import dev.nowshad.uap_gov.worker.WorkerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("applications")
public class ApplicationController {
    private final ApplicationService applicationService;
    private final WorkerService workerService;

    public ApplicationController(ApplicationService applicationService, WorkerService workerService) {
        this.applicationService = applicationService;
        this.workerService = workerService;
    }


    @GetMapping("")
    public String getApplications(Model model) {
        var applications = applicationService.getAll();
        model.addAttribute("applications", applications);
        model.addAttribute("approve", new ApplicationApprovalRequest(
                Status.APPROVED, ""
        ));
        model.addAttribute("reject",
                new ApplicationApprovalRequest(Status.REJECTED, ""
        ));
        var workers = workerService.getAll();
        model.addAttribute("workers", workers);
        return "get-applications";
    }

    @PostMapping("")
    public String submitApplication(Model model, @ModelAttribute CreateApplicationRequest request) {
        applicationService.save(request.workerId());
        return "get-workers";
    }
}
