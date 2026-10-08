package dev.nowshad.uap_gov.worker;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public class CreateWorkerRequest {


    private String nid;
    private String mobile;
    private String name;

    public CreateWorkerRequest(String nid, String mobile, String name) {
        this.nid = nid;
        this.mobile = mobile;
        this.name = name;
    }


    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static Worker toWorker(CreateWorkerRequest request) {
        return new Worker(
                request.getNid(),
                request.getMobile(),
                request.getName()
        );
    }
}
