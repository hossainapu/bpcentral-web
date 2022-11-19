package com.client.home.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SearchRateRequest implements Serializable {

    String id;
    String schoolName;
    String teacherName;
    String subjectTeaches;
    String gradeTeaches;

    Integer from;
    Integer size;
}
