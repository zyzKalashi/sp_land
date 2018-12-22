package com.kailash.land.common.web;

import java.util.List;
import java.util.Map;

/**
 * 基础Dao(还需在XML文件里，有对应的SQL语句)
 */
public interface BaseDao<T> {
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
     * 根据id查询
     *
     * @param id
     * @return
     */
    List<T> queryList(Object id);

    /**
     * 保存单个对象
     *
     * @param t
     */
    int save(T t);

    /**
     * 保存Map对象
     *
     * @param map
     */
    int save(Map<String, Object> map);

    /**
     * 批量保存
     *
     * @param list
     */
    int saveBatch(List<T> list);

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
