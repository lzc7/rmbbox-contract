package com.zipi.modules.contract.entity;

import com.zipi.modules.base.entity.BaseObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class CoreSealFlie extends BaseObject {

    /**  */
    private String fileId;

    /** 投资id */
    private String investId;

    /** 文件存储路径 */
    private String filePath;

    /** 文件名称 */
    private String fileName;

    /** 文件类型 */
    private String fileType;

    /** 文件创建时间 */
    private Date createTime;

    /** 文件期数 */
    private Integer filePeriod;
    
    /**是否盖章*/
    private boolean flagSeal;
}