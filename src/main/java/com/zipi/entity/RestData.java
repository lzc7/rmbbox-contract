package com.zipi.entity;

import com.zipi.base.BaseObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by hbutt on 2014/11/24.
 * Define a standard JSON return format for client
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RestData<T> extends BaseObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3954882033689918344L;
	
	//response status
    private int success = 0;  // 默认为0,失败
    //return code
    private String  code="";
    private String  switchURL;//调转url
    //if some error occurs, it will set some reasons to comment
    private String comment;
    //data field
    private Object data;
    private Object loans;

    private List<T> resultList;

    private List<T> resultListByCount;

    private int result_code;
    
    private String result_msg;
    
    private int page_count;
    
    private int page_index;
    
    private String token;
    
    //wdzj pagecontent
    
    private int totalPage;
    
    private int currentPage;
    
    private int totalCount;
    
    private double totalAmount;
    

    public RestData(int success, String comment, Object data){
    	
    	this.success=success;
    	
    	this.comment=comment;

    	this.data=data;
    	
    }
    public void setMessages(String comment,int success){
        
        this.success=success;
        
        this.comment=comment;
    }

    public RestData(int success, String code, String comment, Object data) {
        this.success = success;
        this.code = code;
        this.comment = comment;
        this.data = data;
    }
}
