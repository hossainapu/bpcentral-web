package com.client.home.model;

import com.client.common.payload.ServiceResponse;
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
public class GetTeacherCountResponse extends ServiceResponse implements Serializable {

    Long count;

    public GetTeacherCountResponse(boolean status, String message) {
        super(status, message);
    }

    public GetTeacherCountResponse(Long count) {
        super();
        this.count = count;
    }
}
