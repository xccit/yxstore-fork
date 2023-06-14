package io.xccit.store.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.store.model.sys.Region;

import java.util.List;

/**
 * <p>
 * 地区表 服务类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
public interface IRegionService extends IService<Region> {

    List<Region> findRegionByKeyword(String keyword);
}
