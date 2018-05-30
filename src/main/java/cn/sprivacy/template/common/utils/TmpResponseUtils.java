package cn.sprivacy.template.common.utils;

import cn.sprivacy.template.common.http.TmpResponse;

/**
 * @author fanglang
 * @date 2018-05-30 15:32
 * @desc 自定义响应工具类
 */
public class TmpResponseUtils {

    public static TmpResponse<Object> success(int code, String message, Object object) {
        return new TmpResponse<>(code, message, object);
    }

    public static TmpResponse<Object> success(String message, Object object) {
        return success(1, message, object);
    }

    public static TmpResponse<Object> success(Object object) {
        return success("操作成功", object);
    }

    public static TmpResponse<Object> error(int code, String message) {
        return new TmpResponse<>(code, message, null);
    }

    public static TmpResponse<Object> error(String message) {
        return error(0, message);
    }

}
