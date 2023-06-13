package io.xccit.store.acl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.store.model.acl.Permission;
import io.xccit.store.model.acl.RolePermission;

import java.util.List;
import java.util.Map;

/**
 * @author CH_ywx
 * @date 2023-06-13
 * @description 角色权限Service
 */
public interface IRolePermissionService extends IService<RolePermission> {
    List<Permission> getPermissionListByRoleID(Long roleId);

    void doAssignByRoleID(Long roleId,Long[] permissionIds);
}
