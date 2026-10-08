package dev.nowshad.uap_gov.worker;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;

@Controller
@RequestMapping("/workers")
public class WorkerController {
    private final WorkerService workerService;


    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("")
    public String getWorkers(Model model) {
        var workers = workerService.getAll();
        model.addAttribute("workers", workers);
        model.addAttribute("worker", new CreateWorkerRequest(
                "", "", ""
        ));
        return "get-workers";
    }

    @PostMapping("")
    public String createWorkers(@ModelAttribute CreateWorkerRequest request, Model model) {
        var response = workerService.save(request);
        var workers = workerService.getAll();
        model.addAttribute("workers", workers);
        model.addAttribute("worker", new CreateWorkerRequest(
                "", "", ""
        ));
        return "get-workers";
    }
}
