package dev.nowshad.uap_gov.application;

import jakarta.validation.constraints.NotNull;

public record ApplicationApprovalRequest(
        @NotNull
        Status status,
        String reason
) {
}
