package com.sachzhong.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sachzhong.core.constants.MessageCode;
import lombok.Data;
import lombok.Value;
import org.apache.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author SachZhong
 * @Description 返回回对象
 * @Date 12:40 2021/7/22
 **/
@Data
public class BaseResponseDTO implements Serializable {

    /**
     * 返回状态码，默认成功
     */
    public int code = HttpStatus.SC_OK;
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
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date time = new Date();

    public BaseResponseDTO() {
    }

    public BaseResponseDTO(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponseDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponseDTO(int code) {
        this.code = code;
    }

    public BaseResponseDTO(Object data) {
        this.data = data;
    }

    public BaseResponseDTO Success(Object data){
        this.data = data;
        return this;
    }

    public BaseResponseDTO Fail(Object data){
        this.code = HttpStatus.SC_INTERNAL_SERVER_ERROR;
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "BaseResponseDTO{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", pageInfo=" + pageInfo +
                ", time=" + time +
                '}';
    }
}
