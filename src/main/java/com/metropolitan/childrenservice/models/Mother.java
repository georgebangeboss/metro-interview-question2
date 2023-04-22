package com.metropolitan.childrenservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mother {
    String name;
    int age;
    String occupation;
    @JsonProperty("marital_status")
    String maritalStatus;
}
