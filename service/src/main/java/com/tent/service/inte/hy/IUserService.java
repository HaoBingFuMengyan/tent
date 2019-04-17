package com.tent.service.inte.hy;


import com.tent.po.entity.hy.User;

import java.util.Map;

public interface IUserService {

	User findBySusernameOrSmobile(String susername,String smobile);

	void updateByPrimaryKeySelective(User record);




	int deleteByPrimaryKey(Long id);

	User insert(User record);

    User insertSelective(User record);

    User selectByPrimaryKey(Long id);


    int updateByPrimaryKey(User record);
    
    User login(String email, String pswd);

	User findUserByEmail(String email);

//	Pagination<User> findByPage(Map<String, Object> resultMap, Integer pageNo,
//                                 Integer pageSize);

	Map<String, Object> deleteUserById(String ids);

	Map<String, Object> updateForbidUserById(Long id, Long status);

//	Pagination<UserRoleAllocationBo> findUserAndRole(ModelMap modelMap,
//                                                     Integer pageNo, Integer pageSize);

//	List<URoleBo> selectRoleByUserId(Long id);

	Map<String, Object> addRole2User(Long userId, String ids);

	Map<String, Object> deleteRoleByUserIds(String userIds);
}
