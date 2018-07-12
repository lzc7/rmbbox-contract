/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.enums;


import com.zipi.base.BaseEnum;

/**
 * 学历水平
 *
 * @author sobranie
 */
public enum EducationLevel implements BaseEnum {

    HIGHSCHOOL("高中及以下"),
    TECHNICALSCHOOL("中专"),
    JUNIORCOLLEGE("大专"),
    UNDERGRADUATE ("本科"),
    MASTER("硕士"),
    DOCTOR("博士");

    private final String key;

    private EducationLevel(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}