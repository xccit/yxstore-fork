package io.xccit.store.sys.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.xccit.store.common.exception.StoreException;
import io.xccit.store.common.result.ResultCodeEnum;
import io.xccit.store.model.sys.RegionWare;
import io.xccit.store.sys.mapper.RegionWareMapper;
import io.xccit.store.sys.service.IRegionWareService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.store.vo.sys.RegionWareQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 城市仓库关联表 服务实现类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
@Service
public class RegionWareServiceImpl extends ServiceImpl<RegionWareMapper, RegionWare> implements IRegionWareService {

    @Autowired
    private RegionWareMapper regionWareMapper;
    @Override
    public IPage<RegionWare> getPageList(Page<RegionWare> regionWarePage, RegionWareQueryVo regionWare) {
        LambdaQueryWrapper<RegionWare> queryWrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(regionWare.getKeyword())){
            queryWrapper.like(RegionWare::getRegionName,regionWare.getKeyword())
                    .or()
                    .like(RegionWare::getWareName,regionWare.getKeyword());
        }
        return regionWareMapper.selectPage(regionWarePage,queryWrapper);
    }

    @Override
    public void openRegionWare(RegionWare regionWare) {
        QueryWrapper<RegionWare> wrapper = new QueryWrapper<>();
        wrapper.eq("region_id",regionWare.getRegionId());
        Integer count = regionWareMapper.selectCount(wrapper);
        if (count > 0){ //表示已开通
            throw new StoreException(ResultCodeEnum.REGION_OPEN);
        }
        regionWareMapper.insert(regionWare);
    }

    @Override
    public Boolean updateStatus(Long id, Integer status) {
        RegionWare regionWare = regionWareMapper.selectById(id);
        regionWare.setStatus(status);
        if (regionWareMapper.updateById(regionWare) == 1){
            return true;
        }
        return false;
    }
}
