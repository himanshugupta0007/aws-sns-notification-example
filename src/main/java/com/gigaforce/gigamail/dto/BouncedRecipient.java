package com.gigaforce.gigamail.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BouncedRecipient {

    @JsonProperty("emailAddress")
    private String emailAddress;

    @JsonProperty("action")
    private String action;

    @JsonProperty("status")
    private String status;

    @JsonProperty("diagnosticCode")
    private String diagnosticCode;
}
