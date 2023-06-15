package io.xccit.store.product.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.store.model.product.AttrGroup;
import io.xccit.store.vo.product.AttrGroupQueryVo;

/**
 * <p>
 * 属性分组 服务类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
public interface IAttrGroupService extends IService<AttrGroup> {

    IPage<AttrGroup> getPageList(Page<AttrGroup> attrGroupPage, AttrGroupQueryVo attrGroupQueryVo);
}
