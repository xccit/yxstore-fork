package io.xccit.store.acl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xccit.store.model.acl.Permission;
import org.springframework.stereotype.Repository;

/**
 * @author CH_ywx
 * @date 2023-06-12
 * @description 菜单mapper
 */

@Repository
public interface IPermissionMapper extends BaseMapper<Permission> {
}
