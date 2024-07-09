package com.gigaforce.gigamail.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gigaforce.gigamail.dto.BounceNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    private final ObjectMapper objectMapper;

    public NotificationService () {
        this.objectMapper = new ObjectMapper();
    }

    public void processNotification (BounceNotification notification) {
        try {
            String notificationString = objectMapper.writeValueAsString(notification);
            log.info("Processing notification: {}", notificationString);
        } catch (JsonProcessingException e) {
            log.error("Error processing notification", e);
        }
    }
}
