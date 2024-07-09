package com.gigaforce.gigamail.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BounceNotification {
    @JsonProperty("eventType")
    private String eventType;

    @JsonProperty("bounce")
    private Bounce bounce;
}
