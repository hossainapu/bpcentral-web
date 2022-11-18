package com.client.common.payload;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceResponse implements Serializable {

    boolean status;
    String message;

    public ServiceResponse() {
        this.status = true;
        this.message = null;
    }

    public ServiceResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }
}
