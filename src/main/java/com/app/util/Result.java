package com.app.util;
//static 静态
import cn.hutool.http.HttpStatus;
import lombok.Data;

//Result类包含 T 泛型，使用Result类时，必须指定T具体是什么类型。
@Data
public class Result<T> {
    public static final String REQUEST_OK = "OK";
    private int code;    //200
    private String msg;   //OK
    private T data;       //响应给前端数据。

    public static Result<Void> ok() {
        return new Result<Void>(HttpStatus.HTTP_OK, REQUEST_OK, null);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(HttpStatus.HTTP_OK, REQUEST_OK, data);
    }

    public static <T> Result<T> error(String msg) {
        return new Result<>(HttpStatus.HTTP_BAD_REQUEST, msg, null);
    }

    public static <T> Result<T> error(int code, String msg) {
        return new Result<>(code, msg, null);
    }

    public Result() {
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public boolean success() {
        return code == HttpStatus.HTTP_OK;
    }
}
