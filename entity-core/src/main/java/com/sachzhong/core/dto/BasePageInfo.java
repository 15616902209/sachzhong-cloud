package com.sachzhong.core.dto;

import java.io.Serializable;
import java.util.List;

/**
 @Author: SachZhong
 @Description: 基础分页对象
 @Date Created in 2021/5/31 20:12
 */
public class BasePageInfo<T> implements Serializable {

    public List<T> list;

    public int Total;

    public int pageSize;

    public int pageNumber;

}
