package io.xccit.store.common.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CH_ywx
 * @date 2023-06-09
 * @description  统一结果返回对象
 */
@ApiModel("统一返回对象")
@Data
public class AjaxResult<T> {

    @ApiModelProperty("状态码")
    //状态码
    private Integer code;
    @ApiModelProperty("状态信息")
    //信息
    private String message;
    @ApiModelProperty("响应数据")
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
