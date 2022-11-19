package com.client.home.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rate implements Serializable {

    String ratedBy;
    Date ratedAt;
    String comment;
    Float rate;

    public Rate(String ratedBy, Date ratedAt, String comment, Float rate) {
        this.ratedBy = ratedBy;
        this.ratedAt = ratedAt;
        this.comment = comment;
        this.rate = rate;
    }
}
