package io.xccit.store.sys.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.store.model.sys.RegionWare;
import io.xccit.store.vo.sys.RegionWareQueryVo;

/**
 * <p>
 * 城市仓库关联表 服务类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
public interface IRegionWareService extends IService<RegionWare> {

    IPage<RegionWare> getPageList(Page<RegionWare> regionWarePage, RegionWareQueryVo regionWare);

    void openRegionWare(RegionWare regionWare);

    Boolean updateStatus(Long id, Integer status);
}
