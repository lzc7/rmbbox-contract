package com.zipi.enums.bbt;

import com.zipi.base.BaseEnum;

/** 文件类型
 * Created by Tony on 2015/6/9.
 */
public enum FileType implements BaseEnum{
    IMAGE("图片"),
    VIDEO("视频"),
    DOCUMENT("文档")
    ;

    private  String key;
    FileType(String key){
        this.key=key;
    }
    @Override
    public String getKey() {
        return key;
    }
}
