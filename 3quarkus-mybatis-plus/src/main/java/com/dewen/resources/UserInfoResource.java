package com.dewen.resources;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dewen.common.BaseResponse;
import com.dewen.entity.UserInfoEntity;
import com.dewen.mapper.UserInfoMapper;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class UserInfoResource {

    @Inject
    UserInfoMapper userInfoMapper;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserInfoEntity selectById(@PathParam("id") Integer id) {
        return userInfoMapper.selectById(id);
    }

    /**
     * 分页条件查询
     *
     * @param pageNo   页码
     * @param pageSize 每页显示条数
     */
    @GET
    @Path("/list")
    public BaseResponse<Page<UserInfoEntity>> list(@QueryParam("email") String email,
                                                   @QueryParam("actualName") String actualName,
                                                   @QueryParam("phone") String phone,
                                                   @QueryParam("pageNo") Integer pageNo,
                                                   @QueryParam("pageSize") Integer pageSize) {
        Page<UserInfoEntity> page = userInfoMapper.selectPage(new Page<>(pageNo, pageSize), new QueryWrapper<UserInfoEntity>()
                .eq(StringUtils.isNotBlank(email), "email", email)
                .eq(StringUtils.isNotBlank(actualName), "actual_name", actualName)
                .eq(StringUtils.isNotBlank(phone), "phone", phone));
        return BaseResponse.success(page);
    }

    /**
     * 新增
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public BaseResponse<Void> add(UserInfoEntity userInfo) {
        UserInfoEntity entity = userInfoMapper.selectOne(new QueryWrapper<UserInfoEntity>()
                .eq("phone", userInfo.getPhone())
                .eq("is_del", 0));
        if (entity != null) {
            return BaseResponse.error("手机号不能重复");
        }
        userInfo.setCreateTime(new Date());
        userInfo.setIsDel(0);
        userInfoMapper.insert(userInfo);
        return BaseResponse.success();
    }

    /**
     * 修改
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public BaseResponse<Void> update(UserInfoEntity userInfo) {
        UserInfoEntity entity = userInfoMapper.selectById(userInfo.getId());
        if (entity == null) {
            return BaseResponse.error("id不存在");
        }
        userInfoMapper.updateById(userInfo);
        return BaseResponse.success();
    }

    /**
     * 删除
     */
    @DELETE
    @Path("/{id}")
    public BaseResponse<Void> delete(@PathParam("id") Long id) {
        userInfoMapper.deleteById(id);
        return BaseResponse.success();
    }

}

