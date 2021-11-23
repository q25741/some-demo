package com.yxf.demo.tools.page;

import cn.hutool.core.util.ObjectUtil;
import com.excalibur.core.model.BaseObject;
import com.github.pagehelper.PageHelper;
import com.wanmei.sys.packapi.constant.MessageCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 前端分页请求参数
 *
 * @author yangxiangfeng
 * @date 2021/8/16
 */
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest extends BaseObject {

    @ApiModelProperty(value = "分页大小", required = true)
    private Integer pageSize;

    @ApiModelProperty(value = "页码", required = true)
    private Integer pageNum;

    /**
     * 使用PageHelper的分页功能
     * @param pageRequest
     * @param nullable
     */
    public static void setPageHelper(PageRequest pageRequest, Boolean nullable) {
        if (!nullable) {
            MessageCode.SERVICE_ERROR.checkPage(pageRequest);
            PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        } else if (ObjectUtil.isAllNotEmpty(
                    pageRequest,
                    pageRequest.getPageNum(),
                    pageRequest.getPageSize())) {
            PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        }

    }

}
