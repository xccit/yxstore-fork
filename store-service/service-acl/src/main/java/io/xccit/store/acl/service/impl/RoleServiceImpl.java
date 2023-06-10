package io.xccit.store.acl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.store.acl.mapper.IRoleMapper;
import io.xccit.store.acl.service.IRoleService;
import io.xccit.store.model.acl.Role;
import io.xccit.store.vo.acl.RoleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CH_ywx
 * @date 2023-06-10
 * @description
 */
@Service
public class RoleServiceImpl extends ServiceImpl<IRoleMapper, Role> implements IRoleService {

    @Autowired
    private IRoleMapper roleMapper;
    @Override
    public IPage<Role> getRolePageList(Page<Role> rolePage, RoleQueryVo roleQueryVo) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        if (roleQueryVo.getRoleName() != null){
            wrapper.like("role_name",roleQueryVo.getRoleName());
        }
        return roleMapper.selectPage(rolePage,wrapper);
    }
}
