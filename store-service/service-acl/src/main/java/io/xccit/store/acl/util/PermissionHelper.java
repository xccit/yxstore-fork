package io.xccit.store.acl.util;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.xccit.store.model.acl.Permission;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CH_ywx
 * @date 2023-06-13
 * @description 封装权限/菜单的工具类
 */
public class PermissionHelper {

    /**
     * 菜单格式转换
     * @param permissionList 所有菜单
     * @return 转换后的菜单列表
     */
    public static List<Permission> buildPermission(List<Permission> permissionList) {
        //最终结果
        List<Permission> trees = new ArrayList<>();
        for (Permission permission : permissionList) {
            // pid为0,代表是第一层菜单
            if (permission.getPid() == 0){
                permission.setLevel(1); //设置等级为第一层
                //从第一层往下递归找子菜单
                trees.add(findChildPermission(permission,permissionList));
            }
        }
        return trees;
    }

    /**
     *
     * @param permission 当前菜单
     * @param permissionList 所有菜单
     * @return 上层菜单
     */
    private static Permission findChildPermission(Permission permission, List<Permission> permissionList) {
        permission.setChildren(new ArrayList<Permission>()); //上层菜单设置子菜单为一个空集合(下面的逻辑判断有子菜单则递归add,没有则就是null)
        for (Permission current : permissionList){ //current:下一次递归的当前节点
            if ((permission.getId().longValue() == current.getPid().longValue())){ //判断当前菜单ID与上层菜单ID一致
                int level = permission.getLevel()+1;
                if (permission.getChildren() == null){
                    permission.setChildren(new ArrayList<>());
                }
                current.setLevel(level); //当前菜单设置等级为上层菜单level + 1
                permission.getChildren().add(findChildPermission(current,permissionList)); //上层菜单递归设置子菜单
            }
        }
        return permission;
    }
}
