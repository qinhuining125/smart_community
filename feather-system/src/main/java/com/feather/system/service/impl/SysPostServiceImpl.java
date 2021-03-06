package com.feather.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feather.common.config.UidWorker;
import com.feather.common.constant.FeatherConstants;
import com.feather.common.core.text.Convert;
import com.feather.common.exception.BusinessException;
import com.feather.system.domain.SysPost;
import com.feather.system.mapper.SysPostMapper;
import com.feather.system.mapper.SysUserPostMapper;
import com.feather.system.service.ISysPostService;

/**
 * 岗位信息 服务层处理
 * 
 * @author feather
 */
@Service
public class SysPostServiceImpl implements ISysPostService {
    @Autowired
    private SysPostMapper postMapper;

    @Autowired
    private SysUserPostMapper userPostMapper;

    @Autowired
    private UidWorker uidWorker;

    /**
     * 查询岗位信息集合
     * 
     * @param post
     *            岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<SysPost> selectPostList(SysPost post) {
        return postMapper.selectPostList(post);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<SysPost> selectPostAll() {
        return postMapper.selectPostAll();
    }

    /**
     * 根据用户ID查询岗位
     * 
     * @param userId
     *            用户ID
     * @return 岗位列表
     */
    @Override
    public List<SysPost> selectPostsByUserId(Long userId) {
        return postMapper.selectPostsByUserId(userId);
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param postId
     *            岗位ID
     * @return 角色对象信息
     */
    @Override
    public SysPost selectPostById(Long postId) {
        return postMapper.selectPostById(postId);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids
     *            需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deletePostByIds(String ids) throws BusinessException {
        Long[] postIds = Convert.toLongArray(ids);
        for (Long postId : postIds) {
            SysPost post = selectPostById(postId);
            if (countUserPostById(postId) > 0) {
                throw new BusinessException(String.format("%1$s已分配,不能删除", post.getPostName()));
            }
        }
        return postMapper.deletePostByIds(postIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param post
     *            岗位信息
     * @return 结果
     */
    @Override
    public int insertPost(SysPost post) {
        if (post.getPostId() == null) {
            post.setPostId(uidWorker.getNextId());
        }
        if (post.getStatus() == null) {
            post.setStatus(FeatherConstants.TRUE_SUCCESS_ENABLED_PRIMARY);
        }
        return postMapper.insertPost(post);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param post
     *            岗位信息
     * @return 结果
     */
    @Override
    public int updatePost(SysPost post) {
        return postMapper.updatePost(post);
    }

    /**
     * 通过岗位ID查询岗位使用数量
     * 
     * @param postId
     *            岗位ID
     * @return 结果
     */
    @Override
    public int countUserPostById(Long postId) {
        return userPostMapper.countUserPostById(postId);
    }

    /**
     * 校验岗位名称是否唯一
     * 
     * @param post
     *            岗位信息
     * @return 结果
     */
    @Override
    public boolean checkPostNameUnique(SysPost post) {
        Long postId = post.getPostId() == null ? -1L : post.getPostId();
        SysPost info = postMapper.checkPostNameUnique(post.getPostName());
        if (info != null && info.getPostId().longValue() != postId.longValue()) {
            return false;
        }
        return true;
    }

    /**
     * 校验岗位编码是否唯一
     * 
     * @param post
     *            岗位信息
     * @return 结果
     */
    @Override
    public boolean checkPostCodeUnique(SysPost post) {
        Long postId = post.getPostId() == null ? -1L : post.getPostId();
        SysPost info = postMapper.checkPostCodeUnique(post.getPostCode());
        if (info != null && info.getPostId().longValue() != postId.longValue()) {
            return false;
        }
        return true;
    }

    ///
    ///
    ///
    /**
     * 通过用户ID标记所有岗位
     */
    @Override
    public List<SysPost> flagAllByUserId(Long userId) {
        List<SysPost> userPosts = postMapper.selectPostsByUserId(userId);
        List<SysPost> posts = postMapper.selectPostAll();
        for (SysPost post : posts) {
            for (SysPost userRole : userPosts) {
                if (post.getPostId().longValue() == userRole.getPostId().longValue()) {
                    post.setFlag(true);
                    break;
                }
            }
        }
        return posts;
    }
}
