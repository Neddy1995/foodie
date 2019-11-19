package com.example.foodie.util;

import org.springframework.stereotype.Component;

/**
 * @Description: 接口数据返回对象，数据都封装到这个类对象里， 统一格式
 * @Param:
 * @return
 */
@Component
public class ControllerResult {

    public static final String RESULT_CODE_SUCCESS = "success";
    public static final String RESULT_CODE_FAIL = "fail";
    public static final String RESULT_CODE_ERROR = "error";


//     success 或者 fail 或者 error
    private String resultCode;

//     返回的附带信息
    private String message;

//     返回的具体数据
    private Object data;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ControllerResult{" +
                "resultCode='" + resultCode + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
