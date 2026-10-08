package dev.nowshad.uap_gov.application;

import dev.nowshad.uap_gov.worker.Worker;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Instant applicationDate;

    @Column()
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY)
    private Worker worker;

    @Column(name = "status", nullable = false)
    private String status;

    protected Application() {

    }


    public Application(Instant applicationDate, String reason, Worker worker, Status status) {
        this.id = id;
        this.applicationDate = applicationDate;
        this.reason = reason;
        this.worker = worker;
        this.status = status.name();
    }

    public Long getId() {
        return id;
    }

    public void setStatus(Status status) {
        this.status = status.name();
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Instant getApplicationDate() {
        return applicationDate;
    }

    public String getReason() {
        return reason;
    }

    public Worker getWorker() {
        return worker;
    }

    public String getStatus() {
        return status;
    }
}
