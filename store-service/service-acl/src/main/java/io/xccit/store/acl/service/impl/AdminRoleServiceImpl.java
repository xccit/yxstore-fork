package io.xccit.store.acl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.store.acl.mapper.IAdminRoleMapper;
import io.xccit.store.acl.service.IAdminRoleService;
import io.xccit.store.model.acl.AdminRole;
import org.springframework.stereotype.Service;

/**
 * @author CH_ywx
 * @date 2023-06-11
 * @description
 */

@Service
public class AdminRoleServiceImpl extends ServiceImpl<IAdminRoleMapper, AdminRole> implements IAdminRoleService {
}
