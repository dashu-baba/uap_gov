package dev.nowshad.uap_gov.application;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    public List<Application> getAllByStatus(String status);
}
