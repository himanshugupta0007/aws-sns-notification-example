package com.aws.sns.notifications.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bounce implements Serializable {
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
