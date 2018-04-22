package com.zh.util;

import com.xiaoleilu.hutool.json.JSONObject;

import java.util.Map;

/**
 * Created by zhangheng on 2018/1/18.
 */
public class ResultMessage {
    /** */
    private static final long serialVersionUID = -7102370526170507252L;

    /** 成功 */
    public static final boolean SUCCESS = true;

    /** 失败 */
    public static final boolean FAIL = false;

    // 返回结果(成功或失败)
    private boolean result = SUCCESS;

    // 返回消息
    private String message = "";

    // 引起原因
    private String cause = "";

    private String error = "";

    private Map<String, Object> attributes;// 其他参数

    private ResultMessage() {
    }

    /**
     * 返回成功结果
     *
     * @param message
     *            消息
     * @return
     */
    public static ResultMessage getSuccessResult(String message) {
        ResultMessage rm = new ResultMessage();
        rm.result = true;
        rm.message = message;
        return rm;
    }

    /**
     * 返回成功结果
     *
     * @param message
     *            消息
     * @param attributes
     *            返回参数
     * @return
     */
    public static ResultMessage getSuccessResult(String message, Map<String, Object> attributes) {
        ResultMessage rm = new ResultMessage();
        rm.result = true;
        rm.message = message;
        rm.attributes = attributes;
        return rm;
    }

    /**
     * 返回失败结果信息
     *
     * @param message
     *            提示消息
     * @param cause
     *            失败原因
     * @return
     */
    public static ResultMessage getFailResult(String message, String cause) {
        ResultMessage rm = new ResultMessage();
        rm.result = false;
        rm.message = message;
        rm.cause = cause;
        return rm;
    }

    public static ResultMessage getErrorResult(String error) {
        ResultMessage rm = new ResultMessage();
        rm.result = false;
        rm.error = error;
        return rm;
    }

    /**
     * 返回失败结果信息
     *
     * @param message
     *            提示消息
     * @param cause
     *            失败原因
     * @param attributes
     *            返回参数
     * @return
     */
    public static ResultMessage getFailResult(String message, String cause, Map<String, Object> attributes) {
        ResultMessage rm = new ResultMessage();
        rm.result = false;
        rm.message = message;
        rm.cause = cause;
        rm.attributes = attributes;
        return rm;
    }

    public String toString() {
        JSONObject stringer = new JSONObject();
        stringer.put("result",result);
        stringer.put("message",message);
        stringer.put("cause",cause);
        stringer.put("attributes",attributes);
        stringer.put("error",error);
        return stringer.toString();
    }

    public static boolean isSUCCESS() {
        return SUCCESS;
    }

    public static boolean isFAIL() {
        return FAIL;
    }

    public boolean isResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public String getCause() {
        return cause;
    }

    public String getError() {
        return error;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }
}
