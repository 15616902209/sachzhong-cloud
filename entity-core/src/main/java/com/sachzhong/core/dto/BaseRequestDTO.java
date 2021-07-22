package com.sachzhong.core.dto;

import com.sachzhong.core.constants.MessageCode;
import org.apache.http.HttpStatus;

import java.util.Date;
import java.util.List;

/**
 * @Author: SachZhong
 * @Description:
 * @Date Created in 2021/5/31 19:35
 */
public class BaseRequestDTO {
    /**
     * 返回状态码，默认成功
     */
    public int code = HttpStatus.SC_ACCEPTED;
    /**
     * 返回消息，默认为成功
     */
    public String message = MessageCode.SUCCESS;
    /**
     * 返回的数据，默认为null，一般以json格式返回
     */
    public Object data = null;
    /**
     * 分页对象
     */
    public BasePageInfo pageInfo =null;
    /**
     * 返回时间，默认为空
     */
    public Date time = null;


    public BaseRequestDTO(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseRequestDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseRequestDTO(int code) {
        this.code = code;
    }

    public BaseRequestDTO(Object data) {
        this.data = data;
    }

    public void Success(){

    }

}
