package com.meiyingying.springlaunch.model;


import lombok.Data;

@Data
public class AjaxResponse {

    private boolean isok;
    private int code;
    private String message;
    private Object data;

    public static AjaxResponse success(){
        AjaxResponse response = new AjaxResponse();
        response.setIsok(true);
        response.setCode(200);
        response.setMessage("success");
        return response;
    }

    public static AjaxResponse success(Object data){
        AjaxResponse response = new AjaxResponse();
        response.setIsok(true);
        response.setCode(200);
        response.setMessage("success");
        response.setData(data);
        return response;
    }
}
