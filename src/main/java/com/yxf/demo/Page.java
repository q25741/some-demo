package com.yxf.demo.tools.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * 分页处理工具类
 *
 * @author yangxiangfeng
 * @date 2021/8/16
 */
@ApiModel
@Data
public class Page<T> extends PageRequest {

    @ApiModelProperty("数据总数量")
    private long total;

    private List<T> list;

    private final static Page<Object> EMPTY_PAGE = new Page<>(0, Collections.emptyList());

    public Page() {}

    public Page(long total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    public Page(Integer pageSize, Integer pageNum, long total, List<T> list) {
        super(pageSize, pageNum);
        this.total = total;
        this.list = list;
    }

    /**
     * 返回空的分页对象
     * @param pageRequest
     * @param <T>
     * @return
     */
    public static <T> Page<T> emptyPage(PageRequest pageRequest) {
        if (Objects.isNull(pageRequest)) {
            return emptyPage();
        }
        return new Page<>(pageRequest.getPageSize(), pageRequest.getPageNum(), 0, Collections.emptyList());
    }

    /**
     * 针对PageHelper的查询结果，转换为分页对象
     * @param list  PageHelper的分页查询结果
     * @param <T>
     * @return
     */
    public static <T> Page<T> wrapList(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return new Page<>(0, new ArrayList<>());
        }

        if (list instanceof com.github.pagehelper.Page) {
            com.github.pagehelper.Page page = (com.github.pagehelper.Page) list;
            return new Page<>(page.getPageSize(), page.getPageNum(), page.getTotal(), list);
        }

        return new Page<>(list.size(), list);
    }

    /**
     * 针对PageHelper的查询结果，转换为分页对象，并转换里面实体类
     * @param list      PageHelper查询结果
     * @param function  实体类转换函数
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> Page<R> wrapList(List<T> list, Function<T, R> function) {
        if (list == null) {
            return new Page<>(0, new ArrayList<>());
        }

        List<R> rList = new ArrayList<>(list.size());
        for (T t : list) {
            rList.add(function.apply(t));
        }

        if (list instanceof com.github.pagehelper.Page) {
            com.github.pagehelper.Page page = (com.github.pagehelper.Page) list;
            return new Page<R>(page.getPageSize(), page.getPageNum(), page.getTotal(), rList);
        }

        return new Page<R>(list.size(), rList);
    }

    /**
     * 转换普通list为分页对象，继承当前分页对象的分页参数
     * @param list
     * @param <S>
     * @return
     */
    public <S> Page<S> newPage(List<S> list) {
        return new Page<>(this.getPageSize(), this.getPageNum(), this.getTotal(), list);
    }
}
