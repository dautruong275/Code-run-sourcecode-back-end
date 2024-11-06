package com.project.shopapp.components;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class CustomHealthCheck implements HealthIndicator {
    @Override
    public Health health() {
       try {
           String computerName = InetAddress.getLocalHost().getHostName();
           return Health.up().withDetail("computerName", computerName).build();
       } catch (UnknownHostException e) {
           return Health.down().withDetail("Error", e.getMessage()).build();
       }
    }
}
