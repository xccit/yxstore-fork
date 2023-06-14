package io.xccit.store.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xccit.store.model.sys.Region;
import io.xccit.store.sys.mapper.RegionMapper;
import io.xccit.store.sys.service.IRegionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 地区表 服务实现类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements IRegionService {

    @Autowired
    private RegionMapper regionMapper;
    @Override
    public List<Region> findRegionByKeyword(String keyword) {
        QueryWrapper<Region> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(keyword)){
            wrapper.like("name",keyword);
        }
        return regionMapper.selectList(wrapper);
    }
}
