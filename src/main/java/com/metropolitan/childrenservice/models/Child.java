package com.metropolitan.childrenservice.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(value = "child")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Child {
    @Id
    String id;
    String name;
    @JsonProperty("birth_place")
    String birthPlace;
    @JsonProperty("reg_number")
    String regNumber;
    @JsonFormat(pattern = "yyyy/MM/dd")
    Date dob;
    char gender;
    double weight;
    Mother mother;


}
