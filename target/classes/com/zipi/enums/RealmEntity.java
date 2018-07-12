/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.enums;

import com.zipi.base.BaseEntity;
import com.zipi.enums.bbt.Realm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * identify an model by its id and belonging realm
 *
 * @author rooseek
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@XmlRootElement
public class RealmEntity extends BaseEntity {

    private static final long serialVersionUID = 20131023L;

    @NotNull
    private Realm realm;

    @NotNull
    private String entityId;

    @Override
    public String toString() {
        return realm + ":" + entityId;
    }
}
