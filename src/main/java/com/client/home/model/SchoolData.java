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
public class SchoolData implements Serializable {

    String id;
    String department;
    String division;
    String school_name;
    String title;
    String education;
    String email;
    String first_name;
    String last_name;
    String grade;
    String image_url;
    String study;

}
