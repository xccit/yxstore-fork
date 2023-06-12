package io.xccit.store.acl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.store.acl.mapper.IPermissionMapper;
import io.xccit.store.acl.service.IPermissionService;
import io.xccit.store.model.acl.Permission;
import org.springframework.stereotype.Service;

/**
 * @author CH_ywx
 * @date 2023-06-12
 * @description
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<IPermissionMapper, Permission> implements IPermissionService {
}
