package com.example.demo.healthChecks;

import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class HealthIndicator implements org.springframework.boot.actuate.health.HealthIndicator {

    @Override
    public Health health() {
        Health h=null;
        if(true){
            h=Health.down().withDetail("Down Error", 111).build();
        }
        else{
            h=Health.up().withDetail("Up Success", 2000).build();
        }
        return h;
        
    }
    
}
