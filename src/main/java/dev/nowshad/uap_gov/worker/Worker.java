package dev.nowshad.uap_gov.worker;

import dev.nowshad.uap_gov.application.Application;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String mobile;

    @OneToMany(
            mappedBy = "worker",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Application> items = new ArrayList<>();

    protected Worker() {

    }

    public Worker(String nid, String name, String mobile) {
        this.nid = nid;
        this.name = name;
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public String getNid() {
        return nid;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
