package com.kailash.land.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kailash.land.entity.Users;

@Mapper
public interface UsersMapper {
	/**
	 * 添加对象
	 *
	 * @param entity
	 * @return
	 */
	Users insert(Users entity);

	/**
	 * 根据userId查询对象
	 *
	 * @param userId
	 * @return
	 */
	Map<String, Object> selectByUserId(Integer userId);

	/**
	 * 根据条件更新对象
	 *
	 * @param entity
	 * @return
	 */
	int updateByCondition(Users entity);

	/**
	 * findByUserName登录用
	 *
	 * @param username
	 * @return
	 * @author zyz
	 */
	Users findByUserName(String username);

	/**
	 * 查询用户区域列表
	 *
	 * @param userId
	 * @return
	 */
	List<Map<String, Object>> queryAreaByUserId(Integer userId);

	/**
	 * 查询用户行业列表
	 *
	 * @param userId
	 * @return
	 */
	List<Map<String, Object>> queryTradeByUserId(Integer userId);

	/**
	 * Users
	 *
	 * @param users
	 * @return
	 * @author zyz
	 */
	List<Map<String, Object>> findCompanyNameByUsers(Users users);

	/**
	 * Users count
	 *
	 * @author zyz
	 * @param paramMap
	 * @return
	 */
	int findCountByMap(Map<String, Object> paramMap);
	
	/**
	 * users, url_info
	 * 
	 * @author zyz
	 * @return
	 */
	List<Map<String, Object>> urlUserList(@Param("urlKind")String urlKind);

}