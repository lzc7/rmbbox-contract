/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.base;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 *
 * @author sobranie
 */
public abstract class BaseObject implements Serializable {

    private static final long serialVersionUID = 20131015L;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, false);
    }
}
