/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.entity;

import com.zipi.base.BaseObject;
import com.zipi.enums.RealmEntity;
import com.zipi.enums.bbt.VehicleType;
import com.zipi.enums.common.Source;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 *
 * @author rooseek
 */
@Data
@NoArgsConstructor
@XmlRootElement
public class Vehicle extends BaseObject {

    private static final long serialVersionUID = 20130926L;

    private String id;

    private String userId;

    /**
     * 相关联的实体，例如贷款申请
     */
    private RealmEntity owner;

    /**
     * 车辆基本型号信息:奥迪A8L
     */
    @NotNull
    private String model;

    @NotNull
    private VehicleType type;

    /**
     * 机动车行驶证
     */
    @NotNull
    private String vehicleLicense;

    /*
     * 车牌号
     */
    @NotNull
    private String plateNumber;

    /**
     * 购车年月份，2014表示年，如果精确到月格式为201404
     */
    @NotNull
    private int yearOfPurchase;

    /**
     * 购车价格
     */
    @NotNull
    private int priceOfPurchase;

    /**
     * 现估值
     */
    @NotNull
    private int estimatedValue;

    private String description;

    /**
     * 车辆品牌（奥迪）
     */
    @NotNull
    private String brand;

    /**
     * 车辆性质（运营 or 非运营）
     */
    private boolean operating;

    /**
     * 行驶里程(公里)
     */
    private int mileage;

    private Date timeCreated;

    private Date timeLastUpdated;

    private Source source;

    private String lastModifiedBy;

    public Vehicle(String id,
                   String userId,
                   RealmEntity owner,
                   String model,
                   VehicleType type,
                   String vehicleLicense,
                   String plateNumber,
                   int yearOfPurchase,
                   int priceOfPurchase,
                   int estimatedValue,
                   String description,
                   String brand,
                   boolean operating,
                   int mileage,
                   Source source,
                   String lastModifiedBy) {
        this.id = id;
        this.userId = userId;
        this.owner = owner;
        this.model = model;
        this.type = type;
        this.vehicleLicense = vehicleLicense;
        this.plateNumber = plateNumber;
        this.yearOfPurchase = yearOfPurchase;
        this.priceOfPurchase = priceOfPurchase;
        this.estimatedValue = estimatedValue;
        this.description = description;
        this.brand = brand;
        this.operating = operating;
        this.mileage = mileage;
        this.source = source;
        this.lastModifiedBy = lastModifiedBy;
    }
}
