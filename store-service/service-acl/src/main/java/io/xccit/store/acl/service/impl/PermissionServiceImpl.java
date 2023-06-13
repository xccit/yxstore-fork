package io.xccit.store.acl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.store.acl.mapper.IPermissionMapper;
import io.xccit.store.acl.service.IPermissionService;
import io.xccit.store.acl.util.PermissionHelper;
import io.xccit.store.model.acl.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CH_ywx
 * @date 2023-06-12
 * @description
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<IPermissionMapper, Permission> implements IPermissionService {

    @Autowired
    private IPermissionMapper permissionMapper;

    @Override
    public List<Permission> getPermissionList() {
        //所有菜单
        List<Permission> permissionList = permissionMapper.selectList(null);
        //最终结果
        return PermissionHelper.buildPermission(permissionList);
    }

    @Override
    public void removeChildByID(Long id) {
        //要删除菜单下的所有子菜单
        List<Long> idList = new ArrayList<>();
        this.getChildPermissionByPID(id, idList);
        idList.add(id);//要删除的ID集合中加入当前选中的菜单ID
        permissionMapper.deleteBatchIds(idList);//删除当前菜单及所有子菜单
    }

    /**
     * 获取菜单下的所有子菜单
     *
     * @param id     菜单ID
     * @param idList 要删除的ID集合
     */
    private void getChildPermissionByPID(Long id, List<Long> idList) {
        LambdaQueryWrapper<Permission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Permission::getPid,id);
        List<Permission> childPermission = permissionMapper.selectList(wrapper);//子菜单
        childPermission.stream().forEach(child -> {
            idList.add(child.getId());//要删除的ID集合添加子菜单ID
            getChildPermissionByPID(child.getId(),idList);//递归调用,继续根据子菜单ID查询子菜单
        });
    }
}
