package com.aws.sns.notifications.controller;

import com.aws.sns.notifications.dto.NotificationMessage;
import com.aws.sns.notifications.service.NotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@Slf4j
public class NotificationController {
    private final NotificationService notificationService;

    /**
     * @param notificationService
     * @param
     */
    public NotificationController (NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping(value = "/aws/status", consumes = {MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void handleNotificationStatus (@RequestBody NotificationMessage notificationData,
            @RequestHeader("x-amz-sns-message-type") String type) {
        log.info("Type : {}", type);
        log.info("Notification Data: {}", notificationData);
        if (type.equalsIgnoreCase("SubscriptionConfirmation")) {
            log.info("Attempting to confirm the subscription");
            notificationService.confirmSubscription(notificationData);
        }

        if (type.equalsIgnoreCase("Notification")) {
            log.info("Attempting to confirm the subscription");
            notificationService.processNotification(notificationData);
        }
    }
}
