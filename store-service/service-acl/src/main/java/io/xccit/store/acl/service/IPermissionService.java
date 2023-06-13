package io.xccit.store.acl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.store.model.acl.Permission;

import java.util.List;

/**
 * @author CH_ywx
 * @date 2023-06-12
 * @description
 */
public interface IPermissionService extends IService<Permission> {
    List<Permission> getPermissionList();

    void removeChildByID(Long id);
}
