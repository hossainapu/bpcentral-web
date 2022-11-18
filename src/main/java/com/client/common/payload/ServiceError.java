/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.common.payload;



import com.client.common.ErrorCode;
import java.io.Serializable;

public class ServiceError implements Serializable{
    private String errorMsg;
    private Integer errorCode;

    public ServiceError() {
    }
    
    public ServiceError(Integer errorCode, String errorMsg){
        this.errorCode = errorCode;
        String name = ErrorCode.getValue(errorCode).name();
        this.errorMsg = name + " [" + errorMsg + "]";        
        
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
    
    
}

