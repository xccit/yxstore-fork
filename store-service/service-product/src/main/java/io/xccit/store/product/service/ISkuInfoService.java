package io.xccit.store.product.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.store.model.product.SkuInfo;
import io.xccit.store.vo.product.SkuInfoQueryVo;
import io.xccit.store.vo.product.SkuInfoVo;

/**
 * <p>
 * sku信息 服务类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
public interface ISkuInfoService extends IService<SkuInfo> {

    IPage<SkuInfo> getPageList(Page<SkuInfo> skuInfoPage, SkuInfoQueryVo skuInfoQueryVo);

    void saveSkuInfo(SkuInfoVo skuInfoVo);

    SkuInfoVo getSkuInfoByID(Long id);

    void updateBySkuID(SkuInfoVo skuInfoVo);

    SkuInfo check(Long skuID, Integer status);

    SkuInfo publish(Long skuID, Integer status);

    SkuInfo isNewPerson(Long skuID, Integer status);
}
