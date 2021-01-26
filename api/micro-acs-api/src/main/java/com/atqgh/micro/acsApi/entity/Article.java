package com.atqgh.micro.acsApi.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: education-project
 * @Description:
 * @Author: qiguohui
 * @Date: 2021/1/26 15:53
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("test_article")
@ApiModel(value="文章对象", description="文章")
public class Article  implements Serializable {

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "标签id")
    private String labelId;

    @ApiModelProperty(value = "图片url")
    private String imageUrl;

    @ApiModelProperty(value = "是否公开")
    private Long isPublish;

    @ApiModelProperty(value = "简介")
    private String summary;
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "查看次数")
    private Long viewCount;
    @ApiModelProperty(value = "点赞数")
    private Long thumhup;
    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private String delFlag;






}
