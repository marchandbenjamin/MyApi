package com.example.my_api.diagnostics.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DiagnosticController {

    @Autowired
    private HealthEndpoint healthEndpoint;

    public static HttpStatus mapStatusToHttpStatus(Status status) {
        return switch (status.getCode()) {
            case "UP" -> HttpStatus.OK;
            case "DOWN", "OUT_OF_SERVICE" -> HttpStatus.SERVICE_UNAVAILABLE;
            default -> HttpStatus.INTERNAL_SERVER_ERROR;
        };
    }

    @Operation(
            summary = "Health check endpoint",
            description = "Returns a simple status message to confirm that the application is running. "
                    + "Useful for uptime monitoring, load balancers, and deployment checks."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Application is up and running",
            content = @Content(mediaType = "text/plain", schema = @Schema(example = "UP")))
    @ApiResponse(
            responseCode = "503",
            description = "Application is down or unavailable",
            content = @Content(mediaType = "text/plain", schema = @Schema(example = "DOWN")))
    @GetMapping("/health/check")
    public ResponseEntity<String> healthCheck() {

        Status status = healthEndpoint.health().getStatus();
        return ResponseEntity.status(mapStatusToHttpStatus(status)).body(status.getCode());
    }
}
