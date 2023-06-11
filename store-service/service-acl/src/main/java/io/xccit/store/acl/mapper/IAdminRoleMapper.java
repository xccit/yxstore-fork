package io.xccit.store.acl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xccit.store.model.acl.AdminRole;
import org.springframework.stereotype.Repository;

/**
 * @author CH_ywx
 * @date 2023-06-11
 * @description 用户角色mapper
 */

@Repository
public interface IAdminRoleMapper extends BaseMapper<AdminRole> {
}
