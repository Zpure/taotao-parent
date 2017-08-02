package com.taotao.common.pojo;

/**
 * Created by zhangchun on 2017/3/29.
 */
public class PictureResult {
    private int error;
    private String url;
    private String message;

    public PictureResult(int error, String url, String message) {
        this.error = error;
        this.url = url;
        this.message = message;
    }

    public static PictureResult ok(String url){
        return new PictureResult(0, url, null);
    }
    public static PictureResult error(String message){
        return new PictureResult(1, null, message);
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
