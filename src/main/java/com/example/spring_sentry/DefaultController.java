package com.example.spring_sentry;

import io.sentry.Sentry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/")
    public String home() throws Exception {
        try {
            throw new UnsupportedOperationException("You shouldn't call this!");
        } catch (Exception e) {
            Sentry.captureException(e);
            throw e;
        }
    }
}
