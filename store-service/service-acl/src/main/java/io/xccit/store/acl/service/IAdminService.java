package io.xccit.store.acl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.store.model.acl.Admin;
import io.xccit.store.vo.acl.AdminQueryVo;

/**
 * @author CH_ywx
 * @date 2023-06-10
 * @description
 */
public interface IAdminService extends IService<Admin> {
    IPage<Admin> getAdminPageList(Page<Admin> adminPage, AdminQueryVo adminQueryVo);
}
