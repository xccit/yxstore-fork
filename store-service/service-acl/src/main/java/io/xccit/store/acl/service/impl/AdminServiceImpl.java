package io.xccit.store.acl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.store.acl.mapper.IAdminMapper;
import io.xccit.store.acl.service.IAdminService;
import io.xccit.store.model.acl.Admin;
import io.xccit.store.vo.acl.AdminQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CH_ywx
 * @date 2023-06-10
 * @description
 */
@Service
public class AdminServiceImpl extends ServiceImpl<IAdminMapper, Admin> implements IAdminService {

    @Autowired
    private IAdminMapper adminMapper;
    @Override
    public IPage<Admin> getAdminPageList(Page<Admin> adminPage, AdminQueryVo adminQueryVo) {
        String name = adminQueryVo.getName();
        String username = adminQueryVo.getUsername();
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(name)){
            queryWrapper.eq(Admin::getName,name);
        }
        if (!StringUtils.isEmpty(username)){
            queryWrapper.eq(Admin::getUsername,username);
        }
        return adminMapper.selectPage(adminPage,queryWrapper);
    }
}
