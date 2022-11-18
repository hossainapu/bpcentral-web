/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.home.model;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author hossain
 */
@Data
public class DataSearchRequest implements Serializable{
    private String query;
    private Integer from;
    private Integer size;
}
