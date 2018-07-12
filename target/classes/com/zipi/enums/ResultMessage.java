/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zipi.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 返回前端简单信息，Ajax请求用
 * 
 * @author sobranie
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultMessage implements Serializable {
    
    private boolean result;
    
    private String message;
    private Object obj;
    
}
