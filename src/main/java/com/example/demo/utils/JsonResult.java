package com.example.demo.utils;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class JsonResult implements Serializable {


    private static final long serialVersionUID = 3827607677923745138L;
    //状态码
    private static final Integer SUCCESS=200;
    private static final Integer ERROR=201;
    /**
     * 状态码，成功返回200，失败返回201
     */
    private Integer state;

    /**
     * 成功时返回的json数据
     */
    private Object data;

    /**
     * 失败时返回的错误提示信息
     */
    private String msg;

    public JsonResult() {
    }

    public JsonResult(Integer state, Object data, String msg) {
        this.state = state;
        this.data = data;
        this.msg = msg;
    }

    public JsonResult(Exception e) {
        this.state = ERROR;
        this.data = null;
        this.msg = e.getMessage();
    }

    public JsonResult(Object data) {
        this.state = SUCCESS;
        this.data = data;
        this.msg = "";
    }

    public static JsonResult errorMsg(String msg) {
        return new JsonResult(ERROR, null, msg);
    }

    public static JsonResult ok(Object data) {
        return new JsonResult(data);
    }
}
