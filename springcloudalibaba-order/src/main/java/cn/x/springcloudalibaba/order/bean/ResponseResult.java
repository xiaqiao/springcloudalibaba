package cn.x.springcloudalibaba.order.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xqa
 * @since 2021/2/2
 */
@Data
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code = 0;
    private String message = "success";
    private T data;

    public ResponseResult() {

    }

    public ResponseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private ResponseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseResult success(Object data) {
        return new ResponseResult<>(0, "success", data);
    }

    public static ResponseResult paramError() {
        return new ResponseResult(101, "failed: param error");
    }

    public static ResponseResult flowLimit() {
        return new ResponseResult(102, "failed: flow limit");
    }

    public static ResponseResult sysError() {
        return new ResponseResult(500, "failed: sys error");
    }

    public static ResponseResult forbidError() {
        return new ResponseResult(1001, "failed: forbid error");
    }

}
