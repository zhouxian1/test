package com.geovis.utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @desc: 封装返回结果集
 * @author: zhouxian
 * @date: 2018/12/18
 */
public class ResultUtil {

    public static String result(final Integer status, final String msg, final Object data, final Integer total) {
        JSONObject jsonObject = new JSONObject() {
            {
                try {
                    put("status", status);
                    put("msg", msg);
                    put("data", data);
                    put("total", total);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };
        return jsonObject.toString();
    }

    public static String result(final Integer status, final String msg, final Object data) {
        JSONObject jsonObject = new JSONObject() {
            {
                try {
                    put("status", status);
                    put("msg", msg);
                    put("data", data);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };
        return jsonObject.toString();
    }

    public static String result(final Integer status, final String msg) {
        JSONObject jsonObject = new JSONObject() {
            {
                try {
                    put("status", status);
                    put("msg", msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };
        return jsonObject.toString();
    }

}
