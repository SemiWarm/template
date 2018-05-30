package cn.sprivacy.template.common.exception;

import cn.sprivacy.template.common.http.TmpResponse;
import cn.sprivacy.template.common.utils.TmpResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author fanglang
 * @date 2018-05-30 15:39
 * @desc 自定义异常处理类
 */
@ControllerAdvice
public class TmpExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(TmpExceptionHandler.class);

    /**
     * 处理自定义异常
     *
     * @param e 异常
     * @return
     */
    @ExceptionHandler(Exception.class)
    public TmpResponse handleException(Exception e) {
        LOGGER.error(e.getMessage(), e);
        if (e instanceof TmpException) {
            return TmpResponseUtils.error(e.getMessage());
        } else {
            return TmpResponseUtils.error(500, e.getMessage());
        }
    }
}
