package com.gigaforce.gigamail.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bounce {
    @JsonProperty("feedbackId")
    private String feedbackId;

    @JsonProperty("bounceType")
    private String bounceType;

    @JsonProperty("bounceSubType")
    private String bounceSubType;

    @JsonProperty("bouncedRecipients")
    private List<BouncedRecipient> bouncedRecipients;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("reportingMTA")
    private String reportingMTA;
}
