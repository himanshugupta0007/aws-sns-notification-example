package com.aws.sns.notifications.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BouncedRecipient implements Serializable {

    @JsonProperty("emailAddress")
    private String emailAddress;

    @JsonProperty("action")
    private String action;

    @JsonProperty("status")
    private String status;

    @JsonProperty("diagnosticCode")
    private String diagnosticCode;
}
