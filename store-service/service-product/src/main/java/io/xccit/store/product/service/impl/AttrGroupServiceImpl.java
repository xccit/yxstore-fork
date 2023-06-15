package io.xccit.store.product.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.xccit.store.model.product.AttrGroup;
import io.xccit.store.product.mapper.AttrGroupMapper;
import io.xccit.store.product.service.IAttrGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.store.vo.product.AttrGroupQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 属性分组 服务实现类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
@Service
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroup> implements IAttrGroupService {


    @Autowired
    private AttrGroupMapper attrGroupMapper;
    @Override
    public IPage<AttrGroup> getPageList(Page<AttrGroup> attrGroupPage, AttrGroupQueryVo attrGroupQueryVo) {
        QueryWrapper<AttrGroup> queryWrapper = new QueryWrapper<>();
        String name = attrGroupQueryVo.getName();
        if (!StringUtils.isEmpty(name)){
            queryWrapper.like("name",name);
        }
        return attrGroupMapper.selectPage(attrGroupPage,queryWrapper);
    }
}
