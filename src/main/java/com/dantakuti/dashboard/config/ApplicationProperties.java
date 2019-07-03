package com.dantakuti.dashboard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author adarshbhattarai on 2019-06-30
 * @project dashboard
 */
@Configuration
public class ApplicationProperties {

    @Value("${jwt.token.secret}")
    private String secretKey;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
