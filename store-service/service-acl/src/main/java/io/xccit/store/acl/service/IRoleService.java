package io.xccit.store.acl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.store.model.acl.Role;
import io.xccit.store.vo.acl.RoleQueryVo;

import java.util.Map;

/**
 * @author CH_ywx
 * @date 2023-06-10
 * @description
 */
public interface IRoleService extends IService<Role> {
    IPage<Role> getRolePageList(Page<Role> rolePage, RoleQueryVo roleQueryVo);

    Map<String, Object> getListByAdminID(Long adminID);
}
