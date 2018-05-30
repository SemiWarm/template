package cn.sprivacy.template.common.exception;

/**
 * @author fanglang
 * @date 2018-05-30 15:17
 * @desc 自定义异常类,Springboot只针对RuntimeException进行事务回滚
 */
public class TmpException extends RuntimeException {

    private Integer code;

    public TmpException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
