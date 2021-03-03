package com.status.common;

/**
 * @author 张志宇
 * @version V1.0
 * @Package com.status.common
 * @date 2021/2/23 19:56
 * 接口返回标准
 */
public class JsonData {
    /**
     * 返回状态码
     */
    private int code;
    /**
     * 请求返回数据
     */
    private Object data;
    /**
     * 返回信息
     */
    private String msg;

    public JsonData(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public JsonData(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public JsonData() { }

    public static JsonData successData(Object data){
        return new JsonData(200,data);
    }
    public static JsonData errorData(String data){
        return new JsonData(400,"",data);
    }
    public static JsonData errorData(String data,int code){
        return new JsonData(code,"",data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getObject() {
        return data;
    }

    public void setObject(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
