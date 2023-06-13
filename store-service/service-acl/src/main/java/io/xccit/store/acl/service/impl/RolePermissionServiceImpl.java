package io.xccit.store.acl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.store.acl.mapper.IPermissionMapper;
import io.xccit.store.acl.mapper.IRolePermissionMapper;
import io.xccit.store.acl.service.IPermissionService;
import io.xccit.store.acl.service.IRolePermissionService;
import io.xccit.store.model.acl.Permission;
import io.xccit.store.model.acl.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CH_ywx
 * @date 2023-06-13
 * @description
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<IRolePermissionMapper, RolePermission> implements IRolePermissionService {

    @Autowired
    private IRolePermissionMapper rolePermissionMapper;
    @Autowired
    private IPermissionMapper permissionMapper;
    @Override
    public List<Permission> getPermissionListByRoleID(Long roleId) {
        //所有权限
        return permissionMapper.selectList(null);
    }

    @Override
    public void doAssignByRoleID(Long roleId, Long[] permissionIds) {
        QueryWrapper<RolePermission> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id",roleId);
        rolePermissionMapper.delete(wrapper); //删除原有的角色权限记录
        for (Long permissionId : permissionIds) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permissionId);
            rolePermissionMapper.insert(rolePermission);
        }
    }
}
