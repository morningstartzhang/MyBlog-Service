package com.lovesh.dto;

import java.io.Serializable;

/**
 * @author zdm
 * @Date 2023/09/08
 */
public class Result<T> implements Serializable {

    private Integer code;

    private boolean success;

    private T result;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Result() {
    }

    public Result(Integer code, boolean success, T result) {
        this.code = code;
        this.success = success;
        this.result = result;
    }
}
