package com.aws.sns.notifications.service;

import com.aws.sns.notifications.dto.NotificationMessage;
import com.aws.sns.notifications.dto.NotificationStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class NotificationService {

    private final ObjectMapper objectMapper;
    private final WebClient webClient;

    public NotificationService (WebClient webClient) {
        this.webClient = webClient;
        this.objectMapper = new ObjectMapper();
    }

    public void processNotification (NotificationMessage notification) {
        try {
            log.info("Notification Message: {}", notification.getMessage());
            NotificationStatus notificationString =
                    objectMapper.readValue(notification.getMessage(), NotificationStatus.class);
            log.info("Processing notification: {}", notificationString);
        } catch (JsonProcessingException e) {
            log.error("Error processing notification", e);
        }
    }

    /**
     * @param notificationMessage
     */
    public void confirmSubscription (NotificationMessage notificationMessage) {
        log.info("Attempting to confirm the subscription");
        if (StringUtils.hasLength(notificationMessage.getSubscribeURL())) {
            try {
                log.info("Subrscription URL:{}", notificationMessage.getSubscribeURL());
                webClient.get().uri(notificationMessage.getSubscribeURL()).retrieve().bodyToMono(String.class).block();
            } catch (Exception ex) {
                log.error("Exception occurred while confirming the subscriptipn");
            }
        }
        log.info("No Subrscription URL is present");
    }
}
