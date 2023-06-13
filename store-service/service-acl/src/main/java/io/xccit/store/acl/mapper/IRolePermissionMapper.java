package io.xccit.store.acl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xccit.store.model.acl.RolePermission;
import org.springframework.stereotype.Repository;

/**
 * @author CH_ywx
 * @date 2023-06-13
 * @description 角色权限mapper
 */

@Repository
public interface IRolePermissionMapper extends BaseMapper<RolePermission> {
}
