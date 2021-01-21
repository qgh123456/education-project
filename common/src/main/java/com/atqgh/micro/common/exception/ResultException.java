package com.atqgh.micro.common.exception;

import com.atqgh.micro.common.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ProjectName: education-project
 * @Description:
 * @Author: qiguohui
 * @Date: 2020/10/19 22:53
 */
@Data
@ApiModel(value = "自定义全局异常类")
public class ResultException extends RuntimeException{

    @ApiModelProperty(value = "状态码")
    private Integer code;

    /**
     * 接收状态码和错误消息
     * @param code
     * @param message
     */
    public ResultException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public ResultException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }



    @Override
    public String toString() {
        return "GuliException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
