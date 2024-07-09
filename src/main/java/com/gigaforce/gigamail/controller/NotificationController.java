package com.gigaforce.gigamail.controller;

import com.gigaforce.gigamail.dto.BounceNotification;
import com.gigaforce.gigamail.service.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController (NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/bounce")
    public void handleBounceNotification (@RequestBody BounceNotification notification) {
        notificationService.processNotification(notification);
    }
}
