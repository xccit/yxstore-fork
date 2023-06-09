package io.xccit.store.common.exception;

import io.xccit.store.common.result.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author CH_ywx
 * @date 2023-06-09
 * @description 自定义异常处理类
 */
@Data
@ToString
public class StoreException extends RuntimeException {
    //状态码
    private Integer code;

    /**
     * @param message 异常信息
     * @param code 状态码
     */
    public StoreException(String message,Integer code){
        super(message);
        this.code = code;
    }

    /**
     *
     * @param resultCodeEnum 结果枚举
     */
    public StoreException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

}
