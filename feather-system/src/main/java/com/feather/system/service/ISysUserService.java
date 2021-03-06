package com.feather.system.service;

import java.util.List;

import com.feather.system.domain.SysUser;

/**
 * 用户 业务层
 * 
 * @author feather
 */
public interface ISysUserService {
    /**
     * 根据条件分页查询用户列表
     * 
     * @param user
     *            用户信息
     * @return 用户信息集合信息
     */
    public List<SysUser> selectUserList(SysUser user);

    /**
     * 根据条件分页查询已分配用户角色列表
     * 
     * @param user
     *            用户信息
     * @return 用户信息集合信息
     */
    public List<SysUser> selectAllocatedList(SysUser user);

    /**
     * 根据条件分页查询未分配用户角色列表
     * 
     * @param user
     *            用户信息
     * @return 用户信息集合信息
     */
    public List<SysUser> selectUnallocatedList(SysUser user);

    /**
     * 通过用户名查询用户
     * 
     * @param userName
     *            用户名
     * @return 用户对象信息
     */
    public List<SysUser> selectUserByLoginName(String userName);

    /**
     * 通过手机号码查询用户
     * 
     * @param phoneNumber
     *            手机号码
     * @return 用户对象信息
     */
    public List<SysUser> selectUserByPhoneNumber(String phoneNumber);

    /**
     * 通过身份证号查询用户
     * 
     * @param idcard
     *            身份证号
     * @return 用户对象信息
     */
    public List<SysUser> selectUserByIdcard(String idcard);

    /**
     * 通过openid查询用户
     * 
     * @param openid
     *            openid
     * @return 用户对象信息
     */
    public List<SysUser> selectUserByOpenid(String openid);

    /**
     * 通过邮箱查询用户
     * 
     * @param email
     *            邮箱
     * @return 用户对象信息
     */
    public List<SysUser> selectUserByEmail(String email);

    /**
     * 通过用户ID查询用户
     * 
     * @param userId
     *            用户ID
     * @return 用户对象信息
     */
    public SysUser selectUserById(Long userId);

    /**
     * 通过用户ID删除用户
     * 
     * @param userId
     *            用户ID
     * @return 结果
     */
    public int deleteUserById(Long userId);

    /**
     * 批量删除用户信息
     * 
     * @param ids
     *            需要删除的数据ID
     * @return 结果
     * @throws Exception
     *             异常
     */
    public int deleteUserByIds(String ids) throws Exception;

    /**
     * 保存用户信息
     * 
     * @param user
     *            用户信息
     * @return 结果
     */
    public int insertUser(SysUser user);

    /**
     * 保存用户信息
     * 
     * @param user
     *            用户信息
     * @return 结果
     */
    public int updateUser(SysUser user);

    /**
     * 修改用户详细信息
     * 
     * @param user
     *            用户信息
     * @return 结果
     */
    public int updateUserInfo(SysUser user);

    /**
     * 修改用户密码信息
     * 
     * @param user
     *            用户信息
     * @return 结果
     */
    public int resetUserPwd(SysUser user);

    /**
     * 校验登录名称是否唯一
     *
     * @param user
     *            用户信息
     * @return 结果
     */
    public boolean checkLoginNameUnique(SysUser user);

    /**
     * 校验手机号码是否唯一
     *
     * @param user
     *            用户信息
     * @return 结果
     */
    public boolean checkPhoneUnique(SysUser user);

    /**
     * 校验身份证号是否唯一
     *
     * @param user
     *            用户信息
     * @return 结果
     */
    public boolean checkIdcardUnique(SysUser user);

    /**
     * 校验openid是否唯一
     *
     * @param user
     *            用户信息
     * @return 结果
     */
    public boolean checkOpenidUnique(SysUser user);

    /**
     * 校验email是否唯一
     *
     * @param user
     *            用户信息
     * @return 结果
     */
    public boolean checkEmailUnique(SysUser user);

    /**
     * 根据用户ID查询用户所属角色组
     * 
     * @param userId
     *            用户ID
     * @return 结果
     */
    public String selectUserRoleGroup(Long userId);

    /**
     * 根据用户ID查询用户所属岗位组
     * 
     * @param userId
     *            用户ID
     * @return 结果
     */
    public String selectUserPostGroup(Long userId);

    /**
     * 导入用户数据
     * 
     * @param userList
     *            用户数据列表
     * @param isUpdateSupport
     *            是否更新支持，如果已存在，则进行更新数据
     * @param userId
     *            操作用户
     * @return 结果
     */
    public String importUser(List<SysUser> userList, Boolean isUpdateSupport, String loginUserName, Long loginUserId);

    /**
     * 用户状态修改
     * 
     * @param user
     *            用户信息
     * @return 结果
     */
    public int changeStatus(SysUser user);
}
