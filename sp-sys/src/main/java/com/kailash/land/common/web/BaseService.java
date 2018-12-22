package com.kailash.land.common.web;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author: jinjx
 * T1代表*entity
 * T2代表*filter
 * @Date: Create in 2017/12/29
 */
public interface BaseService<T> {
    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     */
    T queryObject(Object id);

    /**
     * 根据参数查询对象列表
     *
     * @param map
     * @return
     */
    List<T> queryList(Map<String, Object> map);

    /**
     * 返回pageInfo对象的list
     *
     * @param searchMap
     * @return
     */
    PageInfo<T> queryListPageInfo(Map<String, Object> searchMap);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    List<T> queryList(Object id);

    /**
     * 返回pageinfo对象的list
     *
     * @param id
     * @return
     */
    PageInfo<T> queryListPageInfo(Object id);

    /**
     * 保存单个对象
     *
     * @param t
     */
    void save(T t);

    /**
     * 保存Map对象
     *
     * @param map
     */
    void save(Map<String, Object> map);

    /**
     * 批量保存
     *
     * @param list
     */
    void saveBatch(List<T> list);

    /**
     * 更新单个对象
     *
     * @param t
     * @return
     */
    int update(T t);

    /**
     * 更新Map对象
     *
     * @param map
     * @return
     */
    int update(Map<String, Object> map);

    /**
     * 批量更新
     *
     * @param list
     */
    void updateBatch(List<T> list);

    /**
     * 根据id删除对象
     *
     * @param id
     * @return
     */
    int delete(Object id);

    /**
     * 批量删除对象
     *
     * @param ids 数组
     * @return
     */
    int deleteBatch(Object[] ids);

}
