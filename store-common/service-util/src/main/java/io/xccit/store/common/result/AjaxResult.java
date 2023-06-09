package io.xccit.store.common.result;

import lombok.Data;

/**
 * @author CH_ywx
 * @date 2023-06-09
 * @description 统一结果返回类
 */
@Data
public class AjaxResult<T> {

    //状态码
    private Integer code;
    //信息
    private String message;
    //数据
    private T data;

    private AjaxResult(){}

    /**
     * 构建统一返回对象
     * @param data 数据
     * @param resultCodeEnum 结果枚举
     * @return 统一返回对象
     * @param <T> 传入的实体类型
     */
    public static<T> AjaxResult<T> build(T data,ResultCodeEnum resultCodeEnum){
        AjaxResult<T> result = new AjaxResult<>();
        if (data != null){
            result.setData(data);
        }
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    /**
     * 请求成功
     * @param data 数据
     * @return 统一结果对象
     * @param <T> 实体类型
     */
    public static<T> AjaxResult<T> ok(T data){
        return AjaxResult.build(data, ResultCodeEnum.SUCCESS);
    }

    /**
     * 请求失败
     * @param data 数据
     * @return 统一结果对象
     * @param <T> 实体类型
     */
    public static<T> AjaxResult<T> fail(T data){
        return AjaxResult.build(data,ResultCodeEnum.FAIL);
    }

}
