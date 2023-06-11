package io.xccit.store.acl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.store.acl.mapper.IRoleMapper;
import io.xccit.store.acl.service.IAdminRoleService;
import io.xccit.store.acl.service.IRoleService;
import io.xccit.store.model.acl.AdminRole;
import io.xccit.store.model.acl.Role;
import io.xccit.store.vo.acl.RoleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author CH_ywx
 * @date 2023-06-10
 * @description
 */
@Service
public class RoleServiceImpl extends ServiceImpl<IRoleMapper, Role> implements IRoleService {

    @Autowired
    private IRoleMapper roleMapper;
    @Autowired
    private IAdminRoleService adminRoleService;
    @Override
    public IPage<Role> getRolePageList(Page<Role> rolePage, RoleQueryVo roleQueryVo) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        if (roleQueryVo.getRoleName() != null){
            wrapper.like("role_name",roleQueryVo.getRoleName());
        }
        return roleMapper.selectPage(rolePage,wrapper);
    }

    @Override
    public Map<String, Object> getListByAdminID(Long adminID) {
        Map<String, Object> result = new HashMap<>(); //结果
        List<Role> allRolesList = roleMapper.selectList(null); //所有角色
        LambdaQueryWrapper<AdminRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //根据用户ID查询角色列表
        lambdaQueryWrapper.eq(AdminRole::getAdminId,adminID);
        List<AdminRole> adminRoleList = adminRoleService.list(lambdaQueryWrapper); //当前用户角色
        //将当前用户角色的ID分离
        List<Long> roleIdsList = adminRoleList
                .stream().map(AdminRole::getRoleId)
                .collect(Collectors.toList());
        List<Role> assignRoles = new ArrayList<>(); //用户已分配角色集合
        for (Role role : allRolesList) {
            if (roleIdsList.contains(role.getId())){
                assignRoles.add(role);
            }
        }
        result.put("allRolesList",allRolesList);
        result.put("assignRoles",assignRoles);
        return result;
    }
}
