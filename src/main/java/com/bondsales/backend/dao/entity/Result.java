package com.bondsales.backend.dao.entity;

public class Result<T> {
    private String msg;
    private boolean success;
    private T detail;

    public void setSuccess(boolean b) {
        this.success = b;
    }

    public void setDetail(Object o) {
        this.detail = (T) o;
    }

    public String setMsg(String username_or_password_wrong) {
        return username_or_password_wrong;
    }
}
