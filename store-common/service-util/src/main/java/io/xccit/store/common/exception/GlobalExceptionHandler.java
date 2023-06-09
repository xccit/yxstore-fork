package io.xccit.store.common.exception;

import io.xccit.store.common.result.AjaxResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CH_ywx
 * @date 2023-06-09
 * @description 全局异常处理器
 */

@ControllerAdvice //处理全局异常
public class GlobalExceptionHandler {

    /**
     *
     * @param e 全局异常
     * @return 统一结果返回对象
     */
    @ExceptionHandler(Exception.class) //处理所有Exception
    @ResponseBody //将AjaxResult转成JSON返回至前端
    public AjaxResult error(Exception e){
        e.printStackTrace();
        return AjaxResult.fail(null);
    }

    /**
     * 处理StoreException中的异常
     * @param e
     * @return
     */
    @ExceptionHandler(StoreException.class)
    @ResponseBody
    public AjaxResult error(StoreException e){
        e.printStackTrace();
        return AjaxResult.fail(null);
    }

}
