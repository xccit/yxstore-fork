package io.xccit.store.sys.service.impl;

import io.xccit.store.model.sys.Region;
import io.xccit.store.sys.mapper.RegionMapper;
import io.xccit.store.sys.service.IRegionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
