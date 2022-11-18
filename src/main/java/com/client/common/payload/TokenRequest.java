package com.client.common.payload;

import java.io.Serializable;
import lombok.Data;

@Data
public class TokenRequest implements Serializable {
    private String userName;
    private String password;
    
}
